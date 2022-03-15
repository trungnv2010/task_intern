package com.example.ProxyPattern;

public class AcountPermission implements Permission{
      public void request() {
            System.out.println("request");
      }
      public void load() {
            System.out.println("load");
      }
      public void delete() {
            System.out.println("delete");
      }
      public void update() {
            System.out.println("update");
      }
}
