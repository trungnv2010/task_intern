package com.example.ChainofResponsibility;

public class FileLogger extends Logger{
      public FileLogger(LogLevel logLevel){
            super(logLevel);
      }
      public void write(String message) {
            System.out.println("File::Logger: " + message);
      }
}
