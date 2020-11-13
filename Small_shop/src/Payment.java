import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Создать класс Payment с внутренним классом, с помощью объектов которого можно
//сформировать покупку из нескольких товаров.

public class Payment {
    ShoppingCart cart = new ShoppingCart();
    private String amount;

    public void doShopping(Product...products) {
        cart.addProducts(products);
    }

    public void showCart() {
        double count = 0.0;
        System.out.println("Products in your cart:");
        for (Product product : cart.products) {
            System.out.println(product);
            count += product.getCost();
        }
        amount = new DecimalFormat("#0.00").format(count);
        System.out.println("Amount to be paid: " + amount);
    }

    public class ShoppingCart {
        List<Product> products = new ArrayList<>();

        public void addProducts(Product...product) {
            products.addAll(Arrays.asList(product));
        }

    }
}
