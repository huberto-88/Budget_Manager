package budget;

import java.io.Serializable;
import java.util.*;

public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;
    private double balance;
    private final Map<String, List<Purchase>> purchases = new HashMap<>();

    public Budget() {
        this.purchases.put("Food", new ArrayList<>());
        this.purchases.put("Entertainment", new ArrayList<>());
        this.purchases.put("Clothes", new ArrayList<>());
        this.purchases.put("Other", new ArrayList<>());
    }

    public double getBalance() {
        return balance;
    }

    public void addIncome(double income) {
        this.balance += income;
    }

    public Map<String, List<Purchase>> getPurchasesAsMap() {
        return purchases;
    }

    public List<Purchase> getPurchasesAsTypeList(String type) {
        if (purchases.containsKey(type)) {
            return purchases.get(type);
        } else if (type.equals("All")) {
            List<Purchase> tempList = new ArrayList<>();
            for (List<Purchase> list : purchases.values()) {
                tempList.addAll(list);
            }
            return tempList;
        }
        return Collections.emptyList();
    }

    public void addPurchase(String category, Purchase purchase) {
        if (!purchases.containsKey(category)) {
            purchases.put(category, new ArrayList<>());
        }
        purchases.get(category).add(purchase);
        balance -= purchase.getPrice();
    }
}