import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.stream(new Scanner(System.in).nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        for (int i = list.size() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                list.remove(i);
            }
        }
        Collections.reverse(list);
        list.forEach(element -> System.out.print(element + " "));
    }
}