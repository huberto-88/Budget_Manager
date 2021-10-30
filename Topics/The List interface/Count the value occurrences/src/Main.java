class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        int counterList1 = 0;
        int counterList2 = 0;

        for (Integer i : list1) {
            if (i.equals(elem)) {
                counterList1++;
            }
        }

        for (Integer i : list2) {
            if (i.equals(elem)) {
                counterList2++;
            }
        }

        return counterList1 == counterList2;
    }
}