package com.example;
// import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
// import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
// import java.nio.charset.StandardCharsets;
// import java.nio.file.Files;
// import java.nio.file.Paths;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
// import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;



/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException
     * @throws GeneralSecurityException
     * @throws InvalidKeyException
     * @throws URISyntaxException
     * 
     */
//      java -jar task3.jar -a rsa -p 1024 -priv rsa.key -pub rsa.pub
//      java -jar task3.jar -a rsa -priv rsa.key -s test.txt -o test.sig 
//      java -jar task3.jar -a rsa -pub rsa.pub -v test.sig -i test.txt
    public static void main(String[] args) throws IOException, InvalidKeyException, GeneralSecurityException, URISyntaxException {
        
        if (args[3].equalsIgnoreCase("-a")){
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(args[4]);
            if (args[5].equalsIgnoreCase("-p")){
                keyGen.initialize(Integer.parseInt(args[6]));
                KeyPair keyPair = keyGen.generateKeyPair();
                PublicKey publicKey = keyPair.getPublic();
                PrivateKey privateKey = keyPair.getPrivate();
                System.out.println("Private key: " + privateKey);
                String priKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
                String pubKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
                // StringBuffer pubString = new StringBuffer(); 
                // StringBuffer priString = new StringBuffer();
                // for (int i = 0; i < publicKey.length; ++i) {
                //     pubString.append(Integer.toHexString(0x0100 + (publicKey[i] & 0x00FF)).substring(1));
                // }
        
                // for (int i = 0; i < privateKey.length; ++i) {
                //     priString.append(Integer.toHexString(0x0100 + (privateKey[i] & 0x00FF)).substring(1));
                // }
                if (args[7].equalsIgnoreCase("-priv")){
                    FileWriter writer = new FileWriter(args[8]);
                    writer.write(priKeyString);
                    writer.close();
                }
                else System.out.println("Error 4");
                if (args[9].equalsIgnoreCase("-pub")){
                    FileWriter writer = new FileWriter(args[10]);
                    writer.write(pubKeyString);
                    writer.close();
                }
                else System.out.println("Error 3 ");
                // System.out.println(priString);
                // FileWriter writer = new FileWriter("rsa.key", true);

                // writer.write(pubString.toString());
                // writer.close();
            }
            else if (args[5].equalsIgnoreCase("-priv")){
                if (args[7].equalsIgnoreCase("-s")){
                    if (args[9].equalsIgnoreCase("-o")){
                        String privKeyString = new String();
                        String mes = new String();
                        try {
                            File myObj = new File(args[6]);
                            Scanner myReader = new Scanner(myObj);
                            while (myReader.hasNextLine()) {
                            privKeyString = myReader.nextLine();
                            }
                            myReader.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                        try {
                            File myObj = new File(args[8]);
                            Scanner myReader = new Scanner(myObj);
                            while (myReader.hasNextLine()) {
                            mes = myReader.nextLine();
                            }
                            myReader.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                        Signature sig = Signature.getInstance("SHA256withRSA");
                        
                        sig.initSign((PrivateKey) loadPrivateKey(privKeyString));
                        System.out.println(loadPrivateKey(privKeyString));
                        sig.update(mes.getBytes());
                        byte [] signature = sig.sign();
                        FileWriter writer = new FileWriter(args[10]);
                        writer.write(Base64.getEncoder().encodeToString(signature));
                        writer.close();
                      


                        // String privateKeyContent = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("rsa.key").toURI())));
                        // String publicKeyContent = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("rsa.pub").toURI())));
                
                        // privateKeyContent = privateKeyContent.replaceAll("\\n", "").replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", "");
                        // publicKeyContent = publicKeyContent.replaceAll("\\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "");;
                
                        // KeyFactory kf = KeyFactory.getInstance("RSA");
                
                        // PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyContent));
                        // PrivateKey privKey = kf.generatePrivate(keySpecPKCS8);
                
                        // X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyContent));
                        // RSAPublicKey pubKey = (RSAPublicKey) kf.generatePublic(keySpecX509);
                
                        // System.out.println(privKey);
                        // System.out.println(pubKey);

                        
                        
                    }
                }


            }
            else if (args[5].equalsIgnoreCase("-pub")){
                if (args[7].equalsIgnoreCase("-v")){
                    if (args[9].equalsIgnoreCase("-i")){
                        // convert string to signature
                        String pubKeyString = new String();
                        String mes = new String();
                        String signature = new String();
                       
                        try {
                            File myObj = new File(args[6]);
                            Scanner myReader = new Scanner(myObj);
                            while (myReader.hasNextLine()) {
                            pubKeyString = myReader.nextLine();
                            }
                            myReader.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                        
                        try {
                            File myObj = new File(args[8]);
                            Scanner myReader = new Scanner(myObj);
                            while (myReader.hasNextLine()) {
                            signature = myReader.nextLine();
                            }
                            myReader.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                        try {
                            File myObj = new File(args[10]);
                            Scanner myReader = new Scanner(myObj);
                            while (myReader.hasNextLine()) {
                            mes = myReader.nextLine();
                            }
                            myReader.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                        Signature sig = Signature.getInstance("SHA256withRSA");
                        sig.initVerify((PublicKey) loadPublicKey(pubKeyString));
                        // System.out.println((PublicKey) loadPublicKey(pubKeyString));
                        sig.update(mes.getBytes());
                        
                        boolean verifies = sig.verify(Base64.getDecoder().decode(signature.getBytes()));
                        if(verifies) {
                            System.out.println("Signature verified");   
                         } else {
                            System.out.println("Signature failed");
                         }
                        // System.out.println(mes);

                    }
                }
            }
            else System.out.println("Error 2 ");
            
        }
        else System.out.println("Error 1");
        

        
        // byte[] publicKey = keyGen.genKeyPair().getPublic().getEncoded();
        // byte[] privateKey = keyGen.genKeyPair().getPrivate().getEncoded();
        // StringBuffer pubString = new StringBuffer(); 
        // StringBuffer priString = new StringBuffer();
        // for (int i = 0; i < publicKey.length; ++i) {
        //     pubString.append(Integer.toHexString(0x0100 + (publicKey[i] & 0x00FF)).substring(1));
        // }
        // System.out.println(pubString);
        // for (int i = 0; i < privateKey.length; ++i) {
        //     priString.append(Integer.toHexString(0x0100 + (privateKey[i] & 0x00FF)).substring(1));
        // }
        // System.out.println(priString);
        // FileWriter writer = new FileWriter("rsa.key", true);
        
        // writer.write(pubString.toString());
        // writer.close();
    }

    public static Key loadPrivateKey(String stored) throws GeneralSecurityException, IOException {
        // java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        // Security.addProvider(new BouncyCastleProvider());
        
        byte[] data = Base64.getDecoder().decode((stored));
        // X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        // KeyFactory fact = KeyFactory.getInstance("RSA");
        // return  fact.generatePrivate(spec);
        
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(data);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(spec);
        return privKey;
        
     }

     public static Key loadPublicKey(String stored) throws GeneralSecurityException, IOException {
        // java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        // Security.addProvider(new BouncyCastleProvider());
        
        byte[] data = Base64.getDecoder().decode((stored));
        // X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        // KeyFactory fact = KeyFactory.getInstance("RSA");
        // return  fact.generatePrivate(spec);
        
        X509EncodedKeySpec spec1 = new X509EncodedKeySpec(data);
        KeyFactory kf1 = KeyFactory.getInstance("RSA");
        RSAPublicKey pubKey = (RSAPublicKey) kf1.generatePublic(spec1);
        return pubKey;
        
     }
    }

