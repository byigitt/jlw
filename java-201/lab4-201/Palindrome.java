public class Palindrome {
  public static Boolean isPalindrome(String word) {
    if (word.length() == 0 || word.length() == 1) return true;
    if (word.charAt(0) == word.charAt(word.length() - 1)) {
      return isPalindrome(word.substring(1, word.length() - 1));
    };

    return false;
  };
  
  public static void main(String[] args) {
    System.out.println(Palindrome.isPalindrome("racecar"));
    System.out.println(Palindrome.isPalindrome("racecars"));   
  }
}