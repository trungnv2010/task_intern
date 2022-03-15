package com.example.ChainofResponsibility;

public class EmailLogger extends Logger {
      public EmailLogger(LogLevel logLevel) {
            super(logLevel);
      }

      public void write(String message) {
            System.out.println("Email::Logger: " + message);
      }
}
      

