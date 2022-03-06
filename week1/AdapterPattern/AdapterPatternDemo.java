public class AdapterPatternDemo {
      public static void main(String[] args) {
            User user = new User();
            user.setName("Jhon Wick");
            UserCustomerAdapter adapter = new UserCustomerAdapter(user);
            System.out.println(adapter.getFirstName());
            System.out.println(adapter.getLastName());

            
      }
}