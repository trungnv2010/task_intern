public class TestAcountDecorator extends AcountDecorator {

      public TestAcountDecorator(Acount acount){
            super(acount);
      }

      public void draw(){
            acount.draw();
            addNewFeature(acount);
      }

      private void addNewFeature(Acount acount){
            System.out.println("This is new feature");
      }
}
