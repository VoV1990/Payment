public class Product {
    private int id;
    private String name;
    private double cost;

    public Product(String name, double cost, int id) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }


    public static double[] getPrices(ListOfGoods listOfGoods) {
        if (listOfGoods.equals(ListOfGoods.FOOD))
            return new double[] {0.5, 0.7, 2.5, 2.3, 2.0, 1.5};
        else if(listOfGoods.equals(ListOfGoods.APPLIANCES))
            return new double[] {100, 105, 107, 90, 50.5, 91};
        else if(listOfGoods.equals(ListOfGoods.ELECTRONICS))
        return new double[] {150, 140, 92, 170, 108, 112};
        return new double[] {};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id. " + id +
                " " + name +
                ", cost: " + cost;
    }

    enum ListOfGoods {
        FOOD("Bread", "Milk", "Pork", "Beef", "Chicken", "Sausage"),
        APPLIANCES("Fridge", "Washing machine", "Dishwasher", "Cleaner", "Iron", "Microwave"),
        ELECTRONICS("Mobile phone", "TV", "Tablet", "Laptop", "Camera", "Game console");
        String[] listOfGoods;

        ListOfGoods(String...listOfGoods) {
            this.listOfGoods = listOfGoods;
        }

        public String[] getListOfGoods() {
            return listOfGoods;
        }
    }
}
