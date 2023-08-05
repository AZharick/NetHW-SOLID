//Open-Closed principle: Product имплементирует Cartable, как и Services
//Можно без помех добавлять любые категории товаров, главное, чтобы они реализовывали Cartable

//По Liskov Substitution principle Услуги не обладают всеми кач-вами Продуктов, поэтому не могут наследоваться от них,
//но, как и Продукты, их можно поместить в корзину (Cartable)

public class Service implements Cartable {
   static Catalog catalog = Catalog.get();
   static Cart cart = Cart.get();
   private final int USDtoRURrate = 95;     //no magic numbers in da code!
   private final String category = "Услуга";
   private String name;
   private int priceRUR;
   private int priceUSD;

   public Service(String name, int priceUSD) {
      this.name = name;
      this.priceRUR = priceUSD * USDtoRURrate;      //no magic number here
      this.priceUSD = priceUSD;
      catalog.addToCatalog(this);      //DRY: created Article goes into Catalog automatically
   }

   @Override
   public String toString() {
      return name + ". Цена: "
              + priceRUR + "\u20BD\\" + priceUSD + "$";
   }

   @Override
   public void toCart() {
      cart.addToCart(this);
   }

   public String getCategory() {
      return category;
   }

   public String getName() {
      return name;
   }

   public int getPrice() {
      return priceUSD;
   }
}
