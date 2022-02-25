package com.example;

import org.json.JSONObject;
import org.json.JSONException;
public class test{
      public static void main(String[] args){
            JSONObject jsonObject = new JSONObject();
            String trung = "{\"name\":\"trung\",\"age\":\"20\"}";
            try {
                  jsonObject = new JSONObject(trung);
                  
             }catch (JSONException err){
                  System.out.println("JSONException " + err.toString());
             }
             String jsonString = jsonObject.toString();
             System.out.println(jsonString);
             
            
      }     
      //print string
      

}