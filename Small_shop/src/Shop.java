import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<Product> productsList = new ArrayList<>();
    Payment payment = new Payment();

    public void chooseOption() {
        boolean stop = false;
        int option = 0;
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
        chooseTypeOfGoods(option);
    }
    
    private void chooseTypeOfGoods(int option) {
        double[] price;
        String[] goods;
        switch (option) {
            case 1 -> {
                goods = Product.ListOfGoods.FOOD.getListOfGoods();
                price = getPrices(Product.ListOfGoods.FOOD);
                createListOfGoods(goods, price);
            }
            case 2 -> {
                goods = Product.ListOfGoods.APPLIANCES.getListOfGoods();
                price = getPrices(Product.ListOfGoods.APPLIANCES);
                createListOfGoods(goods, price);
            }
            case 3 -> {
                goods = Product.ListOfGoods.ELECTRONICS.getListOfGoods();
                price = getPrices(Product.ListOfGoods.ELECTRONICS);
                createListOfGoods(goods, price);
            }
        }
    }

    private double[] getPrices(Product.ListOfGoods listOfGoods) {
        if (listOfGoods.equals(Product.ListOfGoods.FOOD))
            return new double[] {0.5, 0.7, 2.5, 2.3, 2.0, 1.5};
        else if(listOfGoods.equals(Product.ListOfGoods.APPLIANCES))
            return new double[] {100, 105, 107, 90, 50.5, 91};
        else if(listOfGoods.equals(Product.ListOfGoods.ELECTRONICS))
            return new double[] {150, 140, 92, 170, 108, 112};
        return new double[] {};
    }

    private void createListOfGoods(String[] goods, double[]price) {
        for (int i = 0; i < goods.length; i++) {
            productsList.add(new Product(goods[i], price[i], i + 1));
        }
    }

    public void chooseGoods() {
        for (Product product : productsList) System.out.println(product);
        boolean stop = false;
        int option;
        do{
            System.out.println("Please select the product id, if you are finished " +
                    "and want to go to the shopping cart press 0:");
            try {
                while ((option = Integer.parseInt(reader.readLine())) != 0) {
                    for (Product product : productsList) {
                        if(product.getId() == (option)) {
                            payment.doShopping(product);
                        }
                    }
                }
                stop = true;
            } catch (Exception e) {
                System.out.println("Invalid data.");
            }
        } while (!stop);
        payment.showCart();
    }
}
