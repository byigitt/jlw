public class MergeSortTester {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 7, 8, 11};
        int[] arr2 = {3, 6, 8, 9, 10, 11, 12, 14};
        int[] merged = Sorter.merge(arr1, arr2);
        System.out.print("New Array: ");
        for (int i : merged) {
            System.out.print(i + " ");
        }
        System.out.println("\nMax value is: " + Sorter.getMax(merged));
        System.out.println("Min value is: " + Sorter.getMin(merged));
    }

}
