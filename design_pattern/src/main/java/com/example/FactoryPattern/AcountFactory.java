package com.example.FactoryPattern;




public class AcountFactory {
      public Account getShape(String shapeType){
            if (shapeType == null){
                  return null;
            }
            if (shapeType.equalsIgnoreCase("ANONYMOUS")){
                  return new AnonymousCustomer();
            } else if (shapeType.equalsIgnoreCase("SALEMANAGER")){
                  return new SaleManager();
            } else if (shapeType.equalsIgnoreCase("REGISTERED")){
                  return new RegisteredCustomer();
            }

            return null;
      }
}
