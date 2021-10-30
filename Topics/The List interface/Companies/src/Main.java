import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.stream(new Scanner(System.in).nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        System.out.println(list);
    }
}