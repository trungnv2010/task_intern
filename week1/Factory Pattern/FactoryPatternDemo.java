
public class FactoryPatternDemo {
       public static void main(String[] args) {
             AcountFactory shapeFactory = new AcountFactory();
             Account anonymousCustomer = shapeFactory.getShape("ANONYMOUS");
             anonymousCustomer.draw();
             Account registeredCustomer = shapeFactory.getShape("REGISTERED");
             registeredCustomer.draw();
             Account saleManager = shapeFactory.getShape("SALEMANAGER");
             saleManager.draw();
       }
}
      

