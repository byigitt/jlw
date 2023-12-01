public class Fibonacci {
  public static void fibonacci(int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(fibonacciHelper(i) + " ");
    }
  }

  private static int fibonacciHelper(int n) {
    if (n <= 1) {
      return n;
    };
    
    return fibonacciHelper(n - 1) + fibonacciHelper(n - 2);
  }

  public static void main(String[] args) {
    fibonacci(20);
  }
}