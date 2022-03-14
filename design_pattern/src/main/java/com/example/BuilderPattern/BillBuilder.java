package com.example.BuilderPattern;

public class BillBuilder {
      public Bill prinBill(){
            Bill bill = new Bill();
            bill.addItem(new TShirt());
            bill.addItem(new Blazer());
            bill.addItem(new Suit());
            bill.addItem(new Aloha());
            return bill;
      }
     
}
