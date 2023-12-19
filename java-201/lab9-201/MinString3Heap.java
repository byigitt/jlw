public class MinString3Heap {
  private String[] valueString;
  private int N = 0;

  public MinString3Heap() {
    this.valueString = new String[100];
  }

  public void insert(String value) {
    if (N == valueString.length - 1) {
      resize();
    }

    valueString[++N] = value;
    swimRecursive(N);
  }

  private void swimRecursive(int index) {
    if (index > 1) {
      int parent = (index - 2) / 3 + 1;
      if (valueString[index].compareTo(valueString[parent]) < 0) {
        swap(index, parent);
        swimRecursive(parent);
      }
    }
  }

  public String removeMin() {
    if (N == 0) {
      return null;
    }

    String minValue = valueString[1];
    swap(1, N--);
    sinkRecursive(1);

    return minValue;
  }

  private void sinkRecursive(int index) {
    int minChild = findMinChild(index);
    if (minChild != -1 && valueString[index].compareTo(valueString[minChild]) > 0) {
      swap(index, minChild);
      sinkRecursive(minChild);
    }
  }

  private int findMinChild(int index) {
    int startChild = 3 * (index - 1) + 2;
    int endChild = Math.min(startChild + 2, N);

    if (startChild > N) {
      return -1;
    }

    int minChild = startChild;
    for (int i = startChild + 1; i <= endChild; i++) {
      if (valueString[i].compareTo(valueString[minChild]) < 0) {
        minChild = i;
      }
    }

    return minChild;
  }

  public void delete(int index) {
    if (index > 0 && index <= N) {
      valueString[index] = valueString[N--];
      swimRecursive(index);
      sinkRecursive(index);
    }
  }

  public void update(int index, String newValue) {
    if (index > 0 && index <= N) {
      String oldValue = valueString[index];
      valueString[index] = newValue;

      if (newValue.compareTo(oldValue) < 0) {
        swimRecursive(index);
      } else {
        sinkRecursive(index);
      }
    }
  }

  public void print() {
    for (int i = 1, _N = N; i <= _N; i++) {
      System.out.println(removeMin());
    }
  }

  private void resize() {
    int newSize = valueString.length * 2;
    String[] newValues = new String[newSize];
    System.arraycopy(valueString, 1, newValues, 1, N);
    valueString = newValues;
  }

  private void swap(int i, int j) {
    String temp = valueString[i];
    valueString[i] = valueString[j];
    valueString[j] = temp;
  }

  public static void main(String[] args) {
    MinString3Heap heap = new MinString3Heap();

    heap.insert("Kemal");
    heap.insert("Zerrin");
    heap.insert("Ahmet");
    heap.insert("Beril");
    heap.insert("Canan");
    heap.insert("Hikmet");
    heap.insert("Okan");

    heap.update(2, "Mehmet");
    heap.update(4, "Fatih");

    heap.delete(2);
    heap.print();
  }

}
