package com.example.FacadePattern;

public class ShoppingFacade {
      private Acount acount;
      private PaymentService paymentService;
      private ShippingService shippingService;
      private EmailService emailService;
      private ShoppingFacade(){
            acount = new Acount();
            paymentService = new PaymentService();
            shippingService = new ShippingService();
            emailService = new EmailService();
      }

      public static ShoppingFacade getInstance(){
            return new ShoppingFacade();
      }

      public void buyProductByCashWithStandardShipping(String email, String name, String phone, String address){
            acount.setEmail(email);
            acount.setName(name);
            acount.setPhone(phone);
            acount.setAddress(address);
            paymentService.payByMoney();
            shippingService.standardShipping(acount);
            emailService.sendingEmail(acount);
            System.out.println("Done!\n");
      }
}
