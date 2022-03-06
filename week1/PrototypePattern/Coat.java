public class Coat extends Clothes{
      public Coat() {
            type = "Coat";
      }

      @Override
      public void draw(){
            System.out.println("Inside Coat::draw() method.");
      }
      
}
