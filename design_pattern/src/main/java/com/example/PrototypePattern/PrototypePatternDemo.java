package com.example.PrototypePattern;

public class PrototypePatternDemo {
      public void run() {
            ClothesCache.loadCache();
            Clothes clonedCloth = (Clothes) ClothesCache.getCloth("1");
            System.out.println("Cloth : " + clonedCloth.getType());
            Clothes clonedCloth2 = (Clothes) ClothesCache.getCloth("2");
            System.out.println("Cloth : " + clonedCloth2.getType());
            Clothes clonedCloth3 = (Clothes) ClothesCache.getCloth("3");
            System.out.println("Cloth : " + clonedCloth3.getType());
      }
      
}
