package com.example.ChainofResponsibility;

public abstract class Logger {
      protected LogLevel logLevel;
      protected Logger nextLogger;
      public Logger(LogLevel logLevel) {
            this.logLevel = logLevel;
      }
      public void setNextLogger(Logger nextLogger) {
            this.nextLogger = nextLogger;
      }
      public void logMessage(LogLevel logLevel, String message) {
            if (this.logLevel.getLevel() <= logLevel.getLevel()) {
                  write(message);
            }
            if (nextLogger != null) {
                  nextLogger.logMessage(logLevel, message);
            }
      }
      public abstract void write(String message);
}
