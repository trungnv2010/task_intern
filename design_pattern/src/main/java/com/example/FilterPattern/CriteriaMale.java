package com.example.FilterPattern;

import java.util.List;
import java.util.ArrayList;
public class CriteriaMale implements Criteria {
      @Override
      public List<Customer> meetCriteria(List<Customer> customers) {
            List<Customer> maleCustomers = new ArrayList<Customer>();
            for (Customer customer : customers) {
                  if (customer.getGender().equalsIgnoreCase("MALE")){
                        maleCustomers.add(customer);
                  }
      
}
      return maleCustomers;
      }
}
