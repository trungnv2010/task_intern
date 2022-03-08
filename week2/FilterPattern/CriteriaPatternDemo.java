import java.util.List;
import java.util.ArrayList;
public class CriteriaPatternDemo {
      public static void main(String[] args) {
            List<Customer> customers = new ArrayList<Customer>();
            customers.add(new Customer("Robert", "Male"));
            customers.add(new Customer("John", "Male"));
            customers.add(new Customer("Laura", "Female"));
            customers.add(new Customer("Diana", "Female"));
            customers.add(new Customer("Mike", "Male"));
            customers.add(new Customer("Bobby", "Male"));
            Criteria male = new CriteriaMale();
            Criteria female = new CriteriaFemale();
          
          
            
            System.out.println("Males: ");
            printcustomers(male.meetCriteria(customers));
      
            System.out.println("\nFemales: ");
            printcustomers(female.meetCriteria(customers));
      
            
      
          
         }
      
         public static void printcustomers(List<Customer> customers){
         
            for (Customer customer : customers) {
               System.out.println("customer : [ Name : " + customer.getName() + ", Gender : " + customer.getGender() +  " ]");
            }
         }      
      }
      