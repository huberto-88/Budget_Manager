package budget;

import java.util.*;

public class Analyzer {
    public static void sortAll(Budget budget) {
        List<Purchase> sortedList = budget.getPurchasesAsTypeList("All");
        if (sortedList.isEmpty()) {
            System.out.println("The purchase list is empty!");
        } else {
            sortedList.sort(Comparator.comparingDouble(Purchase::getPrice).reversed());
            for (Purchase purchase : sortedList) {
                System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice());
            }
        }
    }

    public static void sortByType(Budget budget) {
        budget.getPurchasesAsMap()
                .entrySet()
                .stream()
                .sorted((o1, o2) -> (int)Math.ceil(o2.getValue().stream().mapToDouble(Purchase::getPrice).sum()
                        - o1.getValue().stream().mapToDouble(Purchase::getPrice).sum()))
                .forEach(entry -> System.out.printf("%s - $%.2f\n",
                        entry.getKey(), entry.getValue()
                                .stream()
                                .mapToDouble(Purchase::getPrice)
                                .sum()));
    }

    public static void sortByCertainType(Budget budget, String sortingType) {
        if (budget.getPurchasesAsTypeList(sortingType).isEmpty()) {
            System.out.println("\nThe purchase list is empty!");
            return;
        }
        System.out.println();
        budget.getPurchasesAsTypeList(sortingType).stream()
                .sorted(Comparator.comparingDouble(Purchase::getPrice).reversed())
                .forEach(purchase -> System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice()));
    }
}
