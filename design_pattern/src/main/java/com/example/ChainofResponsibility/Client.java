package com.example.ChainofResponsibility;

public class Client {
      public static void main(String[] args) {
            Logger logger = AppLogger.getLogger();
            logger.logMessage(LogLevel.NONE, "NONE");
            logger.logMessage(LogLevel.ERROR, "ERROR");
            logger.logMessage(LogLevel.DEBUG, "DEBUG");
            logger.logMessage(LogLevel.INFO, "INFO");
           
      }
}
