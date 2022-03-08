public class CompositePatternDemo {
      public static void main(String[] args) {
            Staff CEO = new Staff("John", "CEO", 30000);
            Staff headSales = new Staff("Robert", "Head Sales", 20000);
            Staff headMarketing = new Staff("Michel", "Head Marketing", 20000);
            Staff clerk1 = new Staff("Laura", "Marketing", 10000);
            Staff clerk2 = new Staff("Bob", "Marketing", 10000);
            Staff saleExecutive1 = new Staff("Carla", "Sales", 10000);
            Staff saleExecutive2 = new Staff("Thomas", "Sales", 10000);
            CEO.add(headSales);
            CEO.add(headMarketing);

            headSales.add(saleExecutive1);
            headSales.add(saleExecutive2);

            headMarketing.add(clerk1);
            headMarketing.add(clerk2);

            // print out the employee tree
            System.out.println(CEO);
            for (Staff headEmployee : CEO.getSubordinates()) {
                  System.out.println(headEmployee);
                  for (Staff employee : headEmployee.getSubordinates()) {
                        System.out.println(employee);
                  }
            }
      }
}
