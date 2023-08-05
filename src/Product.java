//Open-Closed principle: Product имплементирует Cartable, как и Services
//Interface sergegation: только Product реализует Rateable, согласно принципу разделения интерфейсов

public class Product implements Cartable, Rateable {
   static Catalog catalog = Catalog.get();
   static Cart cart = Cart.get();
   private final int USDtoRURrate = 95;     //no magic numbers in da code!
   private String name;
   private String brand;
   private String category;
   private String keyTag;
   private int priceRUR;
   private int priceUSD;
   private int rating;

   public Product(String category, String brand, String name, int priceUSD, String keyTag) {
      this.name = name;
      this.brand = brand;
      this.category = category;
      this.keyTag = keyTag;
      this.priceUSD = priceUSD;
      this.priceRUR = priceUSD * USDtoRURrate;      //no magic number here
      catalog.addToCatalog(this);      //DRY: created Article goes into Catalog automatically
   }

   @Override
   public void setRating(int rating) {
      this.rating = rating;
   }

   @Override
   public String toString() {
      return category + " \""
              + brand + " "
              + name + "\". Цена: "
              + priceRUR + "\u20BD\\" + priceUSD + "$"
              + " (Рейтинг: " + rating + ")";
   }

   @Override
   public void toCart() {
      cart.addToCart(this);
   }

   public String getName() {
      return name;
   }

   public int getPrice() {
      return priceUSD;
   }

   public String getKeyTag() {
      return keyTag;
   }
}