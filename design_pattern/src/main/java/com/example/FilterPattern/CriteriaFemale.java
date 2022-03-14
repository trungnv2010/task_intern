package com.example.FilterPattern;

import java.util.List;
import java.util.ArrayList;
public class CriteriaFemale implements Criteria {
      public List<Customer> meetCriteria(List<Customer> customers) {
            List<Customer> femaleCustomers = new ArrayList<Customer>();
            for (Customer customer : customers) {
                  if (customer.getGender().equalsIgnoreCase("FEMALE")){
                        femaleCustomers.add(customer);
                  }
            }
            return femaleCustomers;
      }
      
}
