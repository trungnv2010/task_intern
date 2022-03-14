package com.example.AdapterPattern;

public class User implements UserInterface {
      private String name;
      public void setName(String name) {
            this.name = name;
      }
      public String getName(){
            return name;
      }
}
