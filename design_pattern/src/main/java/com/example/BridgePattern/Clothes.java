package com.example.BridgePattern;

public abstract class Clothes {
      protected Color color;
      protected Clothes(Color color){
            this.color = color;
      }
      public abstract void draw();
}
