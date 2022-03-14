package com.example.FlyweightPattern;

public class Context {
      private Integer id;
      private String type;
      public Context(String type, Integer id) {
            this.type = type;
            this.id = id;
      }
      public String getType() {
            return type;
      }
      public Integer getId() {
            return id;
      }
}

