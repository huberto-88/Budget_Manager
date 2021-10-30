import java.util.*;

class Main {

    private static Deque<Integer> array;
    private static Deque<Integer> arrayOfMax;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = scanner.nextInt();

        array = new ArrayDeque<>();
        arrayOfMax = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String command = scanner.next();

            switch (command) {
                case "push": {
                    push(scanner.next());
                }
                break;

                case "pop": {
                    pop();
                }
                break;

                case "max": {
                    System.out.println(getMax());
                }
                break;
            }
        }

    }

    private static void push(String value) {
        int valueAsInt = Integer.parseInt(value);
        array.offerLast(valueAsInt);
        if (arrayOfMax.size() == 0) {
            arrayOfMax.offerLast(valueAsInt);
        }
        else if (valueAsInt > arrayOfMax.peekLast()) {
            arrayOfMax.offerLast(valueAsInt);
        } else {
            arrayOfMax.offerLast(arrayOfMax.peekLast());
        }

    }

    private static void pop () {
        array.pollLast();
        arrayOfMax.pollLast();
    }

    private static int getMax() {
        return arrayOfMax.peekLast();
    }
}