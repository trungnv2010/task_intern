package com.example;
import static spark.Spark.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
// import Gson
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

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


        get("/", (req, res) -> {
          
            //     try {
            //         jsonObject = new JSONObject(input);
                    
            //    }catch (JSONException err){
            //         System.out.println("JSONException " + err.toString());
            //    }
            //    // get all values from jsonobject
            //     String att1 = jsonObject.getString("att1");
            //     String att2 = jsonObject.getString("att2");
            //     String att3 = jsonObject.getString("att3");
            //    // encode to base64
            //     String att1_base64 = Base64.getEncoder().encodeToString(att1.getBytes());
            //     String att2_base64 = Base64.getEncoder().encodeToString(att2.getBytes());
            //     String att3_base64 = Base64.getEncoder().encodeToString(att3.getBytes());
            //    // change value of jsonobject
            //    JSONObject result = new JSONObject();
            //     result.put("att1", att1_base64);
            //     result.put("att2", att2_base64);
            //     result.put("att3", att3_base64);
                // input = input.substring(1, input.length()-1);    
                    
                // String[] keyValuePairs = input.split(",");              //split the string to creat key-value pairs
                // Map<String,String> map = new HashMap<>();
                // // Gson gson = new Gson();                
                // // Map<String,Object> map = new HashMap<String,Object>();
                // // map = (Map<String,Object>) gson.fromJson(input, map.getClass()); 
                // for(String pair : keyValuePairs)                        //iterate over the pairs
                // {
                //     String[] entry = pair.split(":");                   //split the pairs to get key and value 
                //     map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
                // }
                // Gson gson = new Gson();
                // Map<String,Object> map = new HashMap<String,Object>();
                // gson.toJson(input);
                
                // for (Entry<String, Object> entry : map.entrySet()) {
                    
                //     String value = (String) entry.getValue();
                //     //remove quotes
                //     value = value.substring(1, value.length()-1);
    
                //     String keyBase64 = Base64.getEncoder().encodeToString(value.getBytes());
                //     entry.setValue(keyBase64);
                // }
                // Gson gson = new Gson();
                // Type type = new TypeToken<Map<String, String>>(){}.getType();
                // Map<String, String> myMap = gson.fromJson("{'k1':'apple','k2':'orange'}", type);
                // Gson gson = new Gson();
                // String test = gson.toJson(input);
                // Map<String,String> map = new HashMap<>();
                // // @SuppressWarnings("unchecked")
                // map = gson.fromJson(input, map.getClass());
                // Gson gson = new Gson(); 
                
                // HashMap<String, String> map = new HashMap<String, String>();  
                
                // map = gson.fromJson(gson.toJson(input),HashMap.class);
                // for (Entry<String, String> entry : map.entrySet()) {
                //     String value = entry.getValue();
                //     //remove quotes
                //     value = value.substring(1, value.length()-1);
                //     String keyBase64 = Base64.getEncoder().encodeToString(value.getBytes());
                //     entry.setValue(keyBase64);
                // }
                
                // access the map
                
        
                // for (String key: outputMap.keySet()) {
                    
                //     if (outputMap.get(key) instanceof String) {
                //         String value = (String) outputMap.get(key);
                //         //remove quotes
                        
                //         String keyBase64 = Base64.getEncoder().encodeToString(value.getBytes());
                //         outputMap.put(key, keyBase64);
                //     }
                //     // if (outputMap.get(key) instanceof ArrayList<Object>) {
                        
                //     // }
                // }
            
                // convert trung to arraylist
                // ArrayList<Object> trung = new ArrayList<Object>();
                // trung = gson.fromJson(gson.toJson(outputMap.get("c")), trung.getClass());
                
                String input = req.body();
                Gson gson = new Gson();
               
                Type mapType = new TypeToken<HashMap<String, Object>>(){}.getType();
                HashMap<String, Object> outputMap = gson.fromJson(input, mapType);
                outputMap = test(outputMap);
                return outputMap;
        });
       
    }
    static HashMap<String, Object>  test(Object object){
        
        Gson gson = new Gson();       
        Type mapType = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> outputMap = gson.fromJson(gson.toJson(object), mapType);
        for (String key: outputMap.keySet()) {
                
                    if (outputMap.get(key) instanceof String) {
                        String value = (String) outputMap.get(key);
                        //remove quotes
                        
                        String keyBase64 = Base64.getEncoder().encodeToString(value.getBytes());
                        outputMap.put(key, keyBase64);
                    }
                    else {
                        Type type = new TypeToken<ArrayList<Object>>(){}.getType();
                        ArrayList<Object> arr = gson.fromJson(gson.toJson(outputMap.get(key)), type); 
                        
                        for (int counter = 0; counter < arr.size(); counter++) { 	
                            // if (arr.get(counter) instanceof String) {
                            //     String [] values = ((String) arr.get(counter)).split(":");
                            //     HashMap<String, Object> map = new HashMap<String, Object>();
                            //     map.put(values[0], values[1]);
                            //     arr.set(counter, test(map));
                            //     // arr.set(counter, 1);
                            // }
                            // else 	      
                            arr.set(counter, test(arr.get(counter)));	
                            // arr.set(counter, 1);	
                        }
                        outputMap.put(key, arr);
                        
                    }
        }
        return outputMap;
                       
    }
    

   
    
}
