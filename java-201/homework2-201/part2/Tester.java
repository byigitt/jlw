import java.util.Random;

public class Tester {
  public static void main(String[] args) {
    int[] tA10 = generateRandomArray(10), tA100 = generateRandomArray(100), tA1000 = generateRandomArray(1000),
        tA10000 = generateRandomArray(10000), tA100000 = generateRandomArray(100000);

    System.out.println("Testing with 10 element random integer array:");
    sortAndCompare(tA10);
    System.out.println("Testing with 100 element random integer array:");
    sortAndCompare(tA100);
    System.out.println("Testing with 1000 element random integer array:");
    sortAndCompare(tA1000);
    System.out.println("Testing with 10000 element random integer array:");
    sortAndCompare(tA10000);
    System.out.println("Testing with 100000 element random integer array:");
    sortAndCompare(tA100000);

    int[] tA10A = generateAscendingArray(10), tA100A = generateAscendingArray(100),
        tA1000A = generateAscendingArray(1000), tA10000A = generateAscendingArray(10000),
        tA100000A = generateAscendingArray(100000);

    System.out.println("Testing with 10 element ascending integer array:");
    sortAndCompare(tA10A);
    System.out.println("Testing with 100 element ascending integer array:");
    sortAndCompare(tA100A);
    System.out.println("Testing with 1000 element ascending integer array:");
    sortAndCompare(tA1000A);
    System.out.println("Testing with 10000 element ascending integer array:");
    sortAndCompare(tA10000A);
    System.out.println("Testing with 100000 element ascending integer array:");
    sortAndCompare(tA100000A);

    int[] tA10D = generateDescendingArray(10), tA100D = generateDescendingArray(100),
        tA1000D = generateDescendingArray(1000), tA10000D = generateDescendingArray(10000),
        tA100000D = generateDescendingArray(100000);

    System.out.println("Testing with 10 element descending integer array:");
    sortAndCompare(tA10D);
    System.out.println("Testing with 100 element descending integer array:");
    sortAndCompare(tA100D);
    System.out.println("Testing with 1000 element descending integer array:");
    sortAndCompare(tA1000D);
    System.out.println("Testing with 10000 element descending integer array:");
    sortAndCompare(tA10000D);
    System.out.println("Testing with 100000 element descending integer array:");
    sortAndCompare(tA100000D);
  }

  public static int[] generateRandomArray(int size) {
    int[] array = new int[size];
    Random random = new Random();

    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(100);
    }

    return array;
  }

  public static int[] generateAscendingArray(int size) {
    int[] array = new int[size];

    for (int i = 0; i < size; i++) {
      array[i] = i;
    }

    return array;
  }

  public static int[] generateDescendingArray(int size) {
    int[] array = new int[size];

    for (int i = 0; i < size; i++) {
      array[i] = size - i;
    }

    return array;
  }

  public static void sortAndCompare(int[] array) {
    int[] dummyArray = array.clone();
    sorter.sort1(dummyArray);

    int[][] sortArrays = new int[5][];
    for (int i = 0; i < sortArrays.length; i++) {
      sortArrays[i] = array.clone();
    }

    String[] sortNames = { "sort1", "sort2", "sort3", "sort4", "sort5" };
    long[] durations = new long[5];

    for (int i = 0; i < sortArrays.length; i++) {
      long startTime = System.nanoTime();
      sorterByName(sortArrays[i], sortNames[i]);
      long endTime = System.nanoTime();
      durations[i] = endTime - startTime;
    }

    for (int i = 0; i < sortNames.length; i++) {
      System.out.println(sortNames[i] + ": " + durations[i] + "ns, " + durations[i] / 1000000 + "ms");
    }

    System.out.println();
  }

  private static void sorterByName(int[] array, String sortName) {
    switch (sortName) {
      case "sort1":
        sorter.sort1(array);
        break;
      case "sort2":
        sorter.sort2(array);
        break;
      case "sort3":
        sorter.sort3(array);
        break;
      case "sort4":
        sorter.sort4(array);
        break;
      case "sort5":
        sorter.sort5(array);
        break;
      default:
    }
  }

}
