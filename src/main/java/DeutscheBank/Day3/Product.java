package DeutscheBank.Day3;

public class Product implements Comparable<Product>{

    private int id;
    private double price;
    private String name;


    @Override
    public int compareTo(Product o) {
        return (int) (this.price-o.price);
    }
}

