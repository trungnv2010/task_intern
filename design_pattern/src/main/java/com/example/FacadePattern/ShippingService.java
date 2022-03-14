package com.example.FacadePattern;

public class ShippingService {
      public void freeShipping(Acount acount){
            System.out.println("Free Shipping to : " + acount.phone + "  " + acount.address);
      }
      public void premiumShipping(Acount acount){
            System.out.println("Premium Shipping :" + acount.phone + "  " + acount.address);
      }
      public void expressShipping(Acount acount){
            System.out.println("Express Shipping: " + acount.phone + "  " + acount.address);
      }
      public void standardShipping(Acount acount){
            System.out.println("Standard Shipping: " + acount.phone + "  " + acount.address);
      }
}
