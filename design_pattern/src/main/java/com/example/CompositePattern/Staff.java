package com.example.CompositePattern;

import java.util.List;
import java.util.ArrayList;
public class Staff {
      private String name;
      private String position;
      private int salary;
      private List<Staff> subordinates;
      public Staff(String name, String pos, int sal) {
            this.name = name;
            this.position = pos;
            this.salary = sal;
            subordinates = new ArrayList<Staff>();
      }
      public void add(Staff e) {
            subordinates.add(e);
      }
      public void remove(Staff e) {
            subordinates.remove(e);
      }
      public List<Staff> getSubordinates() {
            return subordinates;
      }
      public String toString() {
            return ("Staff :[ Name : " + name + ", position : " + position + ", salary :" + salary + " ]");
      }
}
