package com.example.ChainofResponsibility;

public class ConsoleLogger extends Logger {
      public ConsoleLogger(LogLevel logLevel){
            super(logLevel);
      }
      public void write(String message) {
            System.out.println("Console::Logger: " + message);
      }
}
