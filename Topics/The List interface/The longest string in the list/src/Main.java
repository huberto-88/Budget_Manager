import java.util.*;


public class Main {

    static void changeList(List<String> list) {
        ArrayList<String> arr = new ArrayList<>(list);

        int index = 0;
        int longest = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).length() > longest) {
                longest = arr.get(i).length();
                index = i;
            }
        }
        String temp = new String(arr.get(index));

        for (int i = 0; i < list.size(); i++){
            list.set(i, temp);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}