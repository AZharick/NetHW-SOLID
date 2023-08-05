import java.util.ArrayList;
import java.util.List;

//Cart = Singleton
public class Cart {
   private static Cart instance = null;
   private static List<Cartable> list = new ArrayList<>();
   private int sum;

   private Cart() {
   }

   public static Cart get() {
      if (instance == null) {
         instance = new Cart();
      }
      return instance;
   }

   public int getTotalCartSum() {
      return sum;
   }

   public void addToCart(Cartable cartable) {
      list.add(cartable);
      System.out.println(cartable + " добавлено в корзину");
      sum += cartable.getPrice();
      System.out.println("Сумма корзины: " + getTotalCartSum() + "$");
   }

}