package com.example.ProxyPattern;

public class ProxyPatternDemo {
      public void run() {
            System.out.println("Staff Permission");
            AcountPermisstionProxy staff = new AcountPermisstionProxy("staff");
            staff.load();
            staff.request();
            staff.delete();
            staff.update();
            System.out.println("\n");
            System.out.println("Admin Permission");
            AcountPermisstionProxy admin = new AcountPermisstionProxy("admin");
            admin.load();
            admin.request();
            admin.delete();
            admin.update();
      }

}
