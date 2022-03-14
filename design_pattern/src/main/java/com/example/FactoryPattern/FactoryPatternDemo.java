package com.example.FactoryPattern;


public class FactoryPatternDemo {
       public void run() {
             AcountFactory shapeFactory = new AcountFactory();
             Account anonymousCustomer = shapeFactory.getShape("ANONYMOUS");
             anonymousCustomer.draw();
             Account registeredCustomer = shapeFactory.getShape("REGISTERED");
             registeredCustomer.draw();
             Account saleManager = shapeFactory.getShape("SALEMANAGER");
             saleManager.draw();
       }
}
      

