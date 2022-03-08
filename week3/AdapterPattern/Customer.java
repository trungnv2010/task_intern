public class Customer implements CustomerInterface {
      
      private String firstName;
      private String lastName;
      
      public Customer(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
      }
      
      @Override
      public void setFirstName(String firstName) {
            this.firstName = firstName;
      }
      
      @Override
      public void setLastName(String lastName) {
            this.lastName = lastName;
      }
      
      @Override
      public String getFirstName() {
            return firstName;
      }
      
      @Override
      public String getLastName() {
            return lastName;
      }
}
