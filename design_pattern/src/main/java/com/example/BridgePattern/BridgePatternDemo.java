package com.example.BridgePattern;



public class BridgePatternDemo {
      public void run() {
            Clothes redShirt = new Shirt( new RedOne());
            Clothes greenShirt = new Shirt(new GreenOne());

            redShirt.draw();
            greenShirt.draw();
      }
}
