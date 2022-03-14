package com.example.PrototypePattern;

public class Shirt extends Clothes{
      public Shirt() {
            type = "Shirt";
      }
      @Override
      public void draw(){
            System.out.println("Inside Shirt::draw() method.");
      }
}
