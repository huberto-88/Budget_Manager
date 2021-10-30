package budget;

import java.io.Serializable;

public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final double price;

    public Purchase(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {

        return String.format("%s $%f2", name, price);
    }
//
//    @Override
//    public int compareTo(Purchase o) {
//        return Double.compare(this.getPrice(), o.getPrice());
//    }
}
