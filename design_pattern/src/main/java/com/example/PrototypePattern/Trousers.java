package com.example.PrototypePattern;

public class Trousers extends Clothes {
      public Trousers() {
            type = "Trousers";
      }

      @Override
      public void draw(){
            System.out.println("Inside Trousers::draw() method.");
      }
}
