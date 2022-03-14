package com.example.BuilderPattern;

public class BuilderPatternDemo {
      public void run() {
            BillBuilder billBuilder = new BillBuilder();
            Bill bill = billBuilder.prinBill();
            System.out.println("Print Bill");
            bill.showItems();
            System.out.println("Total cost: " + bill.getCost() );

            
      }
      
}
