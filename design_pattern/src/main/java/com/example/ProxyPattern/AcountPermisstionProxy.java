package com.example.ProxyPattern;

public class AcountPermisstionProxy {
      private String role; 
      private Permission acountPermission;
      public AcountPermisstionProxy(String role) {
            this.role = role;
            acountPermission = new AcountPermission();
      }
      private boolean isAdmin(){
            return role.equalsIgnoreCase("admin");
      }
      public void load(){
            acountPermission.load();
      }
      public void request(){
            acountPermission.request();
      }
      public void delete(){
            if(isAdmin()){
                  acountPermission.delete();
            } else {
                  System.out.println("No permission");
            }
      }
      
      public void update(){
            if(isAdmin()){
                  acountPermission.update();
            } else {
                  System.out.println("No permission");
            
            }
      }
      

}
