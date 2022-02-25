public class SetLanguage {
      private static SetLanguage instance = new SetLanguage();
      public static SetLanguage getInstance() {
            return instance;
      }
      private SetLanguage() {
      }
      public void showMessage() {
            System.out.println("SetLanguage");
      }
}