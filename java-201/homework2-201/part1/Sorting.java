import java.util.Arrays;
import java.util.Comparator;

public class Sorting {
  public static <T extends Comparable<T>> void mergeSort(T[] array, Comparator<T> comparator) {
    if (array.length > 1) {
      int mid = array.length / 2;
      T[] left = Arrays.copyOfRange(array, 0, mid);
      T[] right = Arrays.copyOfRange(array, mid, array.length);

      mergeSort(left, comparator);
      mergeSort(right, comparator);

      merge(array, left, right, comparator);
    }
  }

  private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right, Comparator<T> comparator) {
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
      if (comparator.compare(left[i], right[j]) > 0) {
        array[k++] = left[i++];
      } else {
        array[k++] = right[j++];
      }
    }

    while (i < left.length) {
      array[k++] = left[i++];
    }

    while (j < right.length) {
      array[k++] = right[j++];
    }
  }

  public static <T> void quickSort(T[] array, Comparator<T> comparator) {
    quickSort(array, 0, array.length - 1, comparator);
  }

  private static <T> void quickSort(T[] array, int low, int high, Comparator<T> comparator) {
    if (low < high) {
      int partitionIndex = partition(array, low, high, comparator);

      quickSort(array, low, partitionIndex - 1, comparator);
      quickSort(array, partitionIndex + 1, high, comparator);
    }
  }

  private static <T> int partition(T[] array, int low, int high, Comparator<T> comparator) {
    T pivot = array[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (comparator.compare(array[j], pivot) > 0) {
        i++;

        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    T temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    return i + 1;
  }

  public static void main(String[] args) {
    Person[] people = {
        new Person("Todd", "Fairbanks", 372450),
        new Person("Richard", "Eckhardt", 913395),
        new Person("Carlos", "Badilla", 115762),
        new Person("Arthur", "Brackett", 270406),
        new Person("Kimberly", "Giles", 829956),
        new Person("Kristy", "Wetter", 697097),
        new Person("Jovita", "Romo", 665044),
        new Person("Keith", "Carpenter", 640242),
        new Person("Jane", "Smith", 765802),
        new Person("Alice", "Johnson", 374075)
    };

    mergeSort(people, Comparator.naturalOrder());
    System.out.println("mergeSort natural, descending: \n"
        + Arrays.toString(people).substring(1, Arrays.toString(people).length() - 1));

    mergeSort(people, Comparator.comparing(Person::getName).reversed());
    System.out.println("\nmergeSort by name, descending: \n"
        + Arrays.toString(people).substring(1, Arrays.toString(people).length() - 1));

    mergeSort(people, Comparator.comparing(Person::getSurname).reversed());
    System.out.println("\nmergeSort by surname, descending: \n"
        + Arrays.toString(people).substring(1, Arrays.toString(people).length() - 1));

    quickSort(people, Comparator.naturalOrder());
    System.out.println("\nquickSort natural, descending: \n"
        + Arrays.toString(people).substring(1, Arrays.toString(people).length() - 1));

    quickSort(people, Comparator.comparing(Person::getName).reversed());
    System.out.println("\nquickSort by name, descending: \n"
        + Arrays.toString(people).substring(1, Arrays.toString(people).length() - 1));

    quickSort(people, Comparator.comparing(Person::getSurname).reversed());
    System.out.println("\nquickSort by surname, descending: \n"
        + Arrays.toString(people).substring(1, Arrays.toString(people).length() - 1));
  }
}
