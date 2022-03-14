package com.example.BuilderPattern;

public abstract class DressShirt implements Item {
      public Packing packing() {
            return new Box();
      }
      public abstract float price();
}
      

