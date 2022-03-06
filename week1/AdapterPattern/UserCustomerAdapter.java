public class UserCustomerAdapter implements CustomerInterface {
       private UserInterface user;
       private String firstName;
       private String lastName;
       public UserCustomerAdapter(UserInterface user) {
            this.user = user;
            String fullName = user.getName();
            String[] names = fullName.split(" ");
            this.firstName = names[0];
            this.lastName = names[1];
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
      

