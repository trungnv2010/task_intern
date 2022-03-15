package com.example.ChainofResponsibility;

public class AppLogger {
      public static Logger getLogger(){
            Logger consoleLogger = new ConsoleLogger(LogLevel.INFO);
            Logger fileLogger = new FileLogger(LogLevel.DEBUG);
            Logger emailLogger = new EmailLogger(LogLevel.ERROR);
            consoleLogger.setNextLogger(fileLogger);
            fileLogger.setNextLogger(emailLogger);
            return consoleLogger;
      }
}
