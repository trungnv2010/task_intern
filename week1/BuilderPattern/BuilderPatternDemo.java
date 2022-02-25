public class BuilderPatternDemo {
      public static void main(String[] args) {
            BillBuilder billBuilder = new BillBuilder();
            Bill bill = billBuilder.prinBill();
            System.out.println("Print Bill");
            bill.showItems();
            System.out.println("Total cost: " + bill.getCost() );

            
      }
      
}
