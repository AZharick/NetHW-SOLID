import java.util.ArrayList;
import java.util.List;

//Каталог = Singleton
public class Catalog {
   private static Catalog instance = null;
   private static List<Cartable> productList = new ArrayList<>();

   private Catalog() {
   }

   public static Catalog get() {
      if (instance == null) {
         instance = new Catalog();
      }
      return instance;
   }

   public int getCatalogSize() {
      return productList.size();
   }

   public Cartable getProductFromCatalog(int index) {
      return productList.get(index);
   }

   public void addToCatalog(Cartable article) {
      productList.add(article);
   }

   public void displayAvailableArticles() {
      int count = 1;
      System.out.println("\nДоступные для заказа товары:");
      for (Cartable a : productList) {
         System.out.println(count + ". " + a);
         count++;
      }
   }

}