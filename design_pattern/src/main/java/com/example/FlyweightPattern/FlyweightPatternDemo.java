package com.example.FlyweightPattern;

import java.util.ArrayList;
import java.util.List;

public class FlyweightPatternDemo {
      private static List<CustomerInterface> customers = new ArrayList<>();
      public  void run() {
            createCustomer(5, "test", "KH");
            
      }
      private static void createCustomer(int numberOfCustomer, String typeOfCustomer, String nameCustomer){
            for (int i = 0; i < numberOfCustomer; i++) {
                  Context context = new Context(typeOfCustomer, i);
                  CustomerInterface customer = CustomerFactory.createCustomer(nameCustomer + CustomerFactory.getNumberOfCustomer());
                  customer.draw(context);
                  customers.add(customer);

            }
      }
}
