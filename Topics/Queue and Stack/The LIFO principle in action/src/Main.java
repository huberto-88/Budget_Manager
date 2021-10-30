import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        ArrayDeque<String> queue = new ArrayDeque<>();

        new Scanner(System.in).useDelimiter("\n").tokens().forEach(queue::offerFirst);
        queue.removeLast();
        queue.forEach(System.out::println);
    }
}