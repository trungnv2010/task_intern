import java.security.GeneralSecurityException;

public class BridgePatternDemo {
      public static void main(String[] args) {
            Clothes redShirt = new Shirt( new RedOne());
            Clothes greenShirt = new Shirt(new GreenOne());

            redShirt.draw();
            greenShirt.draw();
      }
}
