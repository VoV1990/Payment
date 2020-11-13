import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Product> productsList = new ArrayList<>();
    Payment payment = new Payment();

    public void chooseTypeOfGoods() {
        boolean stop = false;
        int option = 0;
        double[] price;
        String[] goods;
        do{
            System.out.println("Please select the product type:");
            System.out.println("1. FOOD.");
            System.out.println("2. APPLIANCES.");
            System.out.println("3. ELECTRONICS.");
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Invalid data.");
            }
            if(option >= 1 && option <= 3) stop = true;
            else System.out.println("Please try again");
        } while (!stop);
        switch (option) {
            case 1 -> {
                goods = Product.ListOfGoods.FOOD.getListOfGoods();
                price = Product.getPrices(Product.ListOfGoods.FOOD);
                createListOfGoods(goods, price);
            }
            case 2 -> {
                goods = Product.ListOfGoods.APPLIANCES.getListOfGoods();
                price = Product.getPrices(Product.ListOfGoods.APPLIANCES);
                createListOfGoods(goods, price);
            }
            case 3 -> {
                goods = Product.ListOfGoods.ELECTRONICS.getListOfGoods();
                price = Product.getPrices(Product.ListOfGoods.ELECTRONICS);
                createListOfGoods(goods, price);
            }
        }
    }

    private void createListOfGoods(String[] goods, double[]price) {
        for (int i = 0; i < goods.length; i++) {
            productsList.add(new Product(goods[i], price[i], i + 1));
        }
    }

    public void chooseGoods() {
        for (Product product : productsList) System.out.println(product);
        boolean stop = false;
        List<Integer> options = new ArrayList<>();
        int option;
        do{
            System.out.println("Please select the product id, if you are finished " +
                    "and want to go to the shopping cart press 0:");
            try {
                while ((option = Integer.parseInt(reader.readLine())) != 0) {
                    options.add(option);
                }
                stop = true;
            } catch (Exception e) {
                System.out.println("Invalid data.");
            }
            for (Product product : productsList) {
                for (Integer i : options) {
                    if(product.getId() == (i)) {
                        payment.doShopping(product);
                    }
                }
            }
        } while (!stop);
        payment.showCart();
    }
}
