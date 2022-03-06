import java.util.Hashtable;
public class ClothesCache {
      private static Hashtable<String, Clothes> shapeMap  = new Hashtable<String, Clothes>();
      public static Clothes getCloth(String shapeId) {
            Clothes cachedShape = shapeMap.get(shapeId);
            return (Clothes) cachedShape.clone();
      }

      public static void loadCache(){
            Shirt shirt = new Shirt();
            shirt.setId("1");
            shapeMap.put(shirt.getId(), shirt);

            Coat coat = new Coat();
            coat.setId("2");
            shapeMap.put(coat.getId(), coat);

            Trousers trousers = new Trousers();
            trousers.setId("3");
            shapeMap.put(trousers.getId(), trousers);
      }
}
