package com.example.BuilderPattern;

public abstract class CasualShirt implements Item {
      public Packing packing() {
            return new PaperBag();
      }
      public abstract float price();
}
      

