import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> words = new HashSet<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine().toLowerCase());
        }

        Set<String> inputWords = new HashSet<>();
        n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            inputWords.addAll(Arrays.stream(scanner.nextLine().toLowerCase().split("\\s+"))
                    .collect(Collectors.toSet()));
        }
        inputWords.removeAll(words);
        inputWords.forEach(System.out::println);
    }
}