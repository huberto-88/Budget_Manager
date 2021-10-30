import java.util.List;

class StockItem {
    private String name;
    private double pricePerUnit;
    private int quantity;

    public StockItem(String name, double pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ": " + pricePerUnit + ", " + quantity + ";";
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Utils {
    public static List<StockItem> sort(List<StockItem> stockItems) {
        stockItems.sort((s2, s1) -> Double.compare(
                s1.getPricePerUnit() * s1.getQuantity(), s2.getPricePerUnit() * s2.getQuantity()));
        return stockItems;
    }
}
