import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(List.of(2, 0, 1, 7));
        System.out.println(queue);
    }
}