package com.example.FacadePattern;

public class EmailService {
      public void sendingEmail(Acount acount){
            System.out.println("Sending Email to " + acount.email);
      }
}
