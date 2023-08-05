import java.io.*;
import java.util.Scanner;

public class Main {
   private static Catalog catalog = Catalog.get();
   private static Cart cart = Cart.get();
   private static Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) throws IOException {
      System.out.println("Добро пожаловать в магазин \"Потребитель-2023\"!");

      Product baby1 = new Product("Игрушка", "Лопотуля", "Чёрная кукла Лилит", 70, "Toy");
      Product baby2 = new Product("Игрушка", "Лопотуля", "Автомат АК-47", 80, "Toy");
      Product baby3 = new Product("Игрушка", "Юный гонщик", "Машинка Ferrari", 50, "Toy");
      Product adult1 = new Product("Автомобиль", "Porsche", "Carrera", 50000, "Vehicle");
      Product adult2 = new Product("Оружие", "Калашников", "Автомат AK-47", 20000, "Gun");
      Product teen1 = new Product("Смартфон", "Samsung", "S-123456", 200, "Device");
      Service service1 = new Service("Расширенная гарантия на 5 лет", 55);
      Service service2 = new Service("Установка подствольного гранатомёта", 300);
      Service service3 = new Service("Замена экрана", 200);

      catalog.displayAvailableArticles();
      requestForProductToCart();
   }

   public static void requestForProductToCart() {
      boolean flagToExit = false;
      while (true) {
         System.out.print("\nВведите номер товара для помещения в корзину или \"0\" для оформления заказа: ");
         int answer = scanner.nextInt();

         if ((answer > 0) && (answer <= catalog.getCatalogSize())) {
            cart.addToCart(catalog.getProductFromCatalog(answer - 1));
         } else if (answer == 0) {
            flagToExit = true;
         }

         if (flagToExit) {
            System.out.println("Заказ на " + cart.getTotalCartSum() + "$ оформлен.");
            System.out.println("СПАСИБО ЗА ЗАКАЗ!");
            break;
         }

      }
   }

}