public class MergeSortTester {
    public static void main(String[] args) {
        int[] arr1 = {11, 8, 7, 4, 2, 1};
        int[] arr2 = {14, 12, 11, 10, 9, 8, 6, 3};
        
        int[] merged = Sorter.merge(arr1, arr2);
        
        System.out.print("New Array: ");
        for (int num : merged) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int max = Sorter.getMax(merged);
        System.out.println("Max value is: " + max);
        
        int min = Sorter.getMin(merged);
        System.out.println("Min value is: " + min);
    }
}
