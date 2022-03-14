package com.example.AdapterPattern;

public class AdapterPatternDemo {
      public void run() {
            User user = new User();
            user.setName("Jhon Wick");
            UserCustomerAdapter adapter = new UserCustomerAdapter(user);
            System.out.println(adapter.getFirstName());
            System.out.println(adapter.getLastName());

            
      }
}