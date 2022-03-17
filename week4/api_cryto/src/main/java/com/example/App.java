package com.example;
import static spark.Spark.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Scanner;



import javax.net.ssl.KeyManagerFactorySpi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        post("/create/:user", (req, res) -> {
            String user = req.params(":user");
            String bodyString = req.body();
            String fileName = findFileName(user);
            
            if (fileName.equalsIgnoreCase("message: File not found")) {
                HashMap<String, String> map = convertToMap(bodyString);
                //convert string to int
                int param = Integer.parseInt(map.get("parameter"));
                String algorithm = map.get("algorithm");
                KeyPair keyPair = generateKeyPair(algorithm, param);
                PrivateKey privateKey = keyPair.getPrivate();
                PublicKey publicKey = keyPair.getPublic();
                String priKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
                String pubKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
                writeToFile(user + "_" + algorithm + ".pub", pubKeyString);
                writeToFile(user + "_" + algorithm + ".key", priKeyString);
                return createResponseMessage("success");
            } else {
                return createResponseMessage("User existed");
            }
           
        });

        post("/sign/:user", (req, res) -> {
            String user = req.params(":user");
            String bodyString = req.body();
            HashMap<String, String> map = convertToMap(bodyString);
            String data = map.get("data"); 
            String pivateKeyFileName = findFileName(user, "key");
            // get algorithm from file name
            String algorithm = pivateKeyFileName.split("_")[1].split("\\.")[0];
            String priKeyString = readFromFile(pivateKeyFileName);
            Signature sig = Signature.getInstance("SHA256with" + algorithm);
            sig.initSign((PrivateKey) loadPrivateKey(priKeyString, algorithm));
            sig.update(data.getBytes());
            byte [] signature = sig.sign();
            String signatureString = Base64.getEncoder().encodeToString(signature);
            writeToFile(user + ".sig", signatureString);
            return signatureString;
        });

        post("/verify/:user", (req, res) -> {
            String user = req.params(":user");
            String bodyString = req.body();
            HashMap<String, String> map = convertToMap(bodyString);
            String data = map.get("data");
            String signatureString = map.get("signature");
            String publicKeyFileName = findFileName(user, "pub");
            String algorithm = publicKeyFileName.split("_")[1].split("\\.")[0];
            String pubKeyString = readFromFile(publicKeyFileName);
            Signature sig = Signature.getInstance("SHA256with" + algorithm);
            sig.initVerify((PublicKey) loadPublicKey(pubKeyString, algorithm));
            sig.update(data.getBytes());
            byte [] signature = Base64.getDecoder().decode(signatureString);
            boolean verify = sig.verify(signature);
            if (verify){
                return createResponseMessage( "verify success");
            } else {
                return createResponseMessage( "verify fail");
            }
        });

        post("/getpublic/:user", (req, res) -> {
            String user = req.params(":user");
            String fileName = findFileName(user, "pub");
            String publicKeyString = readFromFile(fileName);
            // pem format
            String publicKeyStringPem = "-----BEGIN PUBLIC KEY-----\n";
            for (int i = 0; i < publicKeyString.length(); i += 64) {
                publicKeyStringPem += publicKeyString.substring(i, Math.min(i + 64, publicKeyString.length())) + "\n";
            }
            publicKeyStringPem += "-----END PUBLIC KEY-----";
            return publicKeyStringPem;
           
        });
        
    }

    private static String findFileName(String user) {
        return findFileName(user, "key");
    }

    public static HashMap<String, String> convertToMap(String bodyString) {
                Gson gson = new Gson();             
                Type mapType = new TypeToken<HashMap<String, String>>(){}.getType();
                HashMap<String, String> outputMap = gson.fromJson(bodyString, mapType); 
        return outputMap;
    }
    
    public static KeyPair generateKeyPair(String algorithm, int param) throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm);
        keyGen.initialize(param);
        KeyPair keyPair = keyGen.generateKeyPair();
        return keyPair;
    }

    public static void writeToFile(String fileName, String content) throws IOException {
        //write to file
        FileWriter writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }

    public static String readFromFile(String fileName) throws IOException {
        //read from file
        String output = new String();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
            output = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            return createResponseMessage("File not found");
        }
        return output;
    }

    public static String createResponseMessage(String message) {
        //create response message
        return "message: " + message;
    }

    public static String findFileName(String userName, String extenString ) {
        //find file name in directory
        File folder = new File("G:\\Groo International\\task_intern\\week4\\api_cryto");
        File[] listOfFiles = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(userName) && name.endsWith(extenString);
            }
        });
        if (listOfFiles.length == 0) {
            return createResponseMessage("File not found");
        } else return listOfFiles[0].getName();
        
    }
    public static Key loadPrivateKey(String stored, String type) throws GeneralSecurityException, IOException {
        // java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        // Security.addProvider(new BouncyCastleProvider());
        
        byte[] data = Base64.getDecoder().decode((stored));
        // X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        // KeyFactory fact = KeyFactory.getInstance("RSA");
        // return  fact.generatePrivate(spec);
        
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(data);
        KeyFactory kf = KeyFactory.getInstance(type);
        PrivateKey privKey = (PrivateKey) kf.generatePrivate(spec);
        return privKey;
        
     }

     public static Key loadPublicKey(String stored, String type) throws GeneralSecurityException, IOException {
        // java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        // Security.addProvider(new BouncyCastleProvider());
        
        byte[] data = Base64.getDecoder().decode((stored));
        // X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        // KeyFactory fact = KeyFactory.getInstance("RSA");
        // return  fact.generatePrivate(spec);
        
        X509EncodedKeySpec spec1 = new X509EncodedKeySpec(data);
        KeyFactory kf1 = KeyFactory.getInstance(type);
        PublicKey pubKey = (PublicKey) kf1.generatePublic(spec1);
        return pubKey;
        
     }
}

