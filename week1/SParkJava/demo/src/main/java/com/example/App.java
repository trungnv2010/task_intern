// package com.example;
// import static spark.Spark.*;
// import java.util.Base64;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Map.Entry;



// public final class App {
//     private App() {
//     }

//     /**
//      * Says hello to the world.
//      *  The arguments of the program.
//      */
//     public static void main(String[] args) {
        
//         get("/", (req, res) -> {
            
            
//             String input = req.body();
//         //     try {
//         //         jsonObject = new JSONObject(input);
                
//         //    }catch (JSONException err){
//         //         System.out.println("JSONException " + err.toString());
//         //    }
//         //    // get all values from jsonobject
        
//         //     String att1 = jsonObject.getString("att1");
//         //     String att2 = jsonObject.getString("att2");
//         //     String att3 = jsonObject.getString("att3");
//         //    // encode to base64
//         //     String att1_base64 = Base64.getEncoder().encodeToString(att1.getBytes());
//         //     String att2_base64 = Base64.getEncoder().encodeToString(att2.getBytes());
//         //     String att3_base64 = Base64.getEncoder().encodeToString(att3.getBytes());
//         //    // change value of jsonobject
//         //    JSONObject result = new JSONObject();
//         //     result.put("att1", att1_base64);
//         //     result.put("att2", att2_base64);
//         //     result.put("att3", att3_base64);
//             input = input.substring(1, input.length()-1);    
                
//             String[] keyValuePairs = input.split(",");              //split the string to creat key-value pairs
//             Map<String,String> map = new HashMap<>();               
            
//             for(String pair : keyValuePairs)                        //iterate over the pairs
//             {
//                 String[] entry = pair.split(":");                   //split the pairs to get key and value 
//                 map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
//             }
//             for (Entry<String, String> entry : map.entrySet()) {
                
//                 String value = entry.getValue();
//                 //remove quotes
//                 value = value.substring(1, value.length()-1);

//                 String keyBase64 = Base64.getEncoder().encodeToString(value.getBytes());
//                 entry.setValue(keyBase64);
//             }
//             return map;
          
//         });
//     }
// }
           
package com.example;
import static spark.Spark.*;
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
        get("/hello", (req, res) -> "Hello World");
    }
}


      


