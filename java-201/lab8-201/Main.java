import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    BinarySearchTree input1_bst = new BinarySearchTree();
    BinarySearchTree input2_bst = new BinarySearchTree();
    BinarySearchTree input3_bst = new BinarySearchTree();

    try {
      String[] input1 = readTextFile(System.getProperty("user.dir") + "/input1.txt");

      for (String word : input1) {
        input1_bst.insert(word);
      }

      input1_bst.printFrequencies();
      System.out.println();

      String[] input2 = readTextFile(System.getProperty("user.dir") + "/input2.txt");
      for (String word : input2) {
        input2_bst.insert(word);
      }

      input2_bst.printFrequencies();
      System.out.println();

      String[] input3 = readTextFile(System.getProperty("user.dir") + "/input3.txt");
      for (String word : input3) {
        input3_bst.insert(word);
      }

      input3_bst.printFrequencies();
    } catch (IOException e) {
      System.err.println("Error reading the file: " + e.getMessage());
    }
  }

  public static String[] readTextFile(String filename) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      StringBuilder content = new StringBuilder();

      while ((line = br.readLine()) != null) {
        content.append(line).append("\n");
      }

      return content.toString().split("\\s+");
    }
  }
}