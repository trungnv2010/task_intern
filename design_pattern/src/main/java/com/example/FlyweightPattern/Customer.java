package com.example.FlyweightPattern;

import javax.naming.Context;


public class Customer implements CustomerInterface {

      private final String name;
      public Customer(String name) {
            this.name = name;
            System.out.println("Customer " + name + " is created");
      }

      @Override
      public void draw(com.example.FlyweightPattern.Context context) {
            
            System.out.println("id: " + context.getId() + " type: " + context.getType() + " name: " + name);
            
      }
      
}
