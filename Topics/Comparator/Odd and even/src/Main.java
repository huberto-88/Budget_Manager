import java.util.List;        

class Utils {

    public static List<Integer> sortOddEven(List<Integer> numbers) {
        numbers.sort((a, b) -> {
            if (a % 2 != 0) {
                return b % 2 != 0 ? Integer.compare(a, b) : -1;
            } else {
                return b % 2 == 0 ? Integer.compare(b, a) : 1;
            }
        });
        return numbers;
    }
}

