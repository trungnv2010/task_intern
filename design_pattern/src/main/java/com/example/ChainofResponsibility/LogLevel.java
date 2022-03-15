package com.example.ChainofResponsibility;

public enum LogLevel {
      NONE(0), INFO(1), DEBUG(2), ERROR(3);
      private int level;
      private LogLevel(int level) {
            this.level = level;
      }
      public int getLevel() {
            return level;
      }
}
      

      

