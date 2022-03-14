package com.example.DecoratorPattern;

public class DecoratorPatternDemo {
      public  void run() {
            Acount customerAcount = new CustomerAcount();
            Acount testCustomerAcount = new TestAcountDecorator(new CustomerAcount());
            Acount testStaffAcount = new TestAcountDecorator(new StaffAcount());
            customerAcount.draw();
            System.out.println("\n");
            testCustomerAcount.draw();
            System.out.println("\n");
            testStaffAcount.draw();
      }
}
