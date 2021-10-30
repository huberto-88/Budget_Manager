import java.util.List;
import java.util.Comparator;


class Utils {

    public static void sortStrings(List<String> strings) {
        strings.sort((s1, s2) -> s1.compareTo(s2));
        strings.sort(Comparator.reverseOrder());
    }
}