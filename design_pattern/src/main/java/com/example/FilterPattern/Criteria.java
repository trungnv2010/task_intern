package com.example.FilterPattern;

import java.util.List;

public interface Criteria {
      public List<Customer> meetCriteria(List<Customer> customers);
}
