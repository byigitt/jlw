public class Code {
    public static void main( String[] args ) {
        int testArray[] = { 4, 12, 3, 26, 18, 1, 55 };
        BubbleSort(testArray, false);
        
        for (int i : testArray) {
            System.out.print(i + " "); 
        };
    };

    public static void BubbleSort(int[] arr, boolean reverse){
        int num;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (reverse) {
                    if (arr[j - 1] < arr[j]) {
                        num = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = num;
                    };
                } else {
                    if (arr[j - 1] > arr[j]) {
                        num = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = num;
                    };
                };
            };
        };

    };
}