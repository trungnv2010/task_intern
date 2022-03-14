package com.example.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

public class CustomerFactory {
      private final static Map<String, CustomerInterface> map = new HashMap<String, CustomerInterface>();
      public static synchronized CustomerInterface createCustomer(String name) {
            CustomerInterface customer = map.get(name);
            if (customer == null){
                  customer = new Customer(name);
                  map.put(name, customer);
            }
            return customer;
      }
      public static synchronized Integer getNumberOfCustomer(){
            return map.size();
      }
}
