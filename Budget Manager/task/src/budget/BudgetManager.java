package budget;

import java.io.*;
import java.util.Scanner;

public class BudgetManager {
    private final Scanner scanner = new Scanner(System.in);
    private Budget budget = new Budget();

    private void displayMenu() {
        System.out.println("\nChoose your action:\n" +
                "1) Add income\n" +
                "2) Add purchase\n" +
                "3) Show list of purchases\n" +
                "4) Balance\n" +
                "5) Save\n" +
                "6) Load\n" +
                "7) Analyze (Sort)\n" +
                "0) Exit");
    }

    public void runApp() {
        while (true) {
            displayMenu();

            int request = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (request) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addPurchase();
                    break;
                case 3:
                    showListOfPurchases();
                    break;
                case 4:
                    balance();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    this.budget = load();
                    break;
                case 7:
                    sort();
                    break;
                case 0:
                    closeApp();
            }
        }
    }

    private void addIncome() {
        System.out.println("Enter income:");
        budget.addIncome(Double.parseDouble(scanner.nextLine()));
        System.out.println("Income was added!");
        System.out.println();
    }

    private void addPurchase() {
        while (true) {
            String type = purchasesMenu("addPurchases");
            if (type.equals("back")) {
                return;
            } else {
                System.out.println();
                System.out.println("Enter purchase name:");
                String name = scanner.nextLine();
                System.out.println("Enter its price:");
                double price = Double.parseDouble(scanner.nextLine());
                budget.addPurchase(type, new Purchase(name, price));
                System.out.println("Purchase was added!");
            }
        }
    }

    private void showListOfPurchases() {
        while (true) {
            String type = purchasesMenu("showPurchases");
            if (type.equals("back")) {
                return;
            }
            System.out.println();
            System.out.println(type);
            if (budget.getPurchasesAsTypeList(type).isEmpty()) {
                System.out.println("The purchase list is empty!");
            } else {
                double sum = 0.0;
                for (Purchase purchase : budget.getPurchasesAsTypeList(type)) {
                    System.out.printf("%s $%.2f\n", purchase.getName(), purchase.getPrice());
                    sum += purchase.getPrice();
                }
                System.out.printf("Total sum $%.2f\n", sum);
                System.out.println();
            }
        }
    }

    private void balance() {
        System.out.printf("Balance: $%.2f\n\n", budget.getBalance());
    }

    private String purchasesMenu(String action) {
        System.out.println();
        System.out.println("Choose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) All\n" +
                "6) Back");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                return "Food";
            case 2:
                return "Clothes";
            case 3:
                return "Entertainment";
            case 4:
                return "Other";
            case 5:
                return action.equals("addPurchases") ? "back" : "All";
            case 6:
                return "back";
            case 0:
                closeApp();
        }
        return "";
    }

    private void closeApp() {
        System.out.println("Bye!");
        System.exit(0);
    }

    private void sort() {
        while (true) {
            System.out.println("\nHow do you want to sort?\n" +
                    "1) Sort all purchases\n" +
                    "2) Sort by type\n" +
                    "3) Sort certain type\n" +
                    "4) Back");
            int type = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (type) {
                case 1:
                    Analyzer.sortAll(budget);
                    break;
                case 2:
                    Analyzer.sortByType(budget);
                    break;
                case 3:
                    System.out.println("\nChoose the type of purchase\n" +
                            "1) Food\n" +
                            "2) Clothes\n" +
                            "3) Entertainment\n" +
                            "4) Other");
                    String sortingType = null;
                    switch (Integer.parseInt(scanner.nextLine())) {
                        case 1:
                            sortingType = "Food";
                            break;
                        case 2:
                            sortingType = "Clothes";
                            break;
                        case 3:
                            sortingType = "Entertainment";
                            break;
                        case 4:
                            sortingType = "Other";
                            break;
                    }
                    Analyzer.sortByCertainType(budget, sortingType);
                    break;
                case 4:
                    return;
            }
        }
    }

    private void save() {
        try (
                FileOutputStream fos = new FileOutputStream("purchases.txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(budget);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private Budget load() {
        try (
                FileInputStream fis = new FileInputStream("purchases.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis)) {
            System.out.println("Purchases were loaded!");
            return budget = (Budget) ois.readObject();
        } catch (IOException | ClassNotFoundException fileNotFoundException) {
            return new Budget();
        }
    }
}
