import java.util.Scanner;
    public class StringManips {
        public static void main (String[] args) {
            String phrase = new String ("This is a String test.");
            int phraseLength; // number of characters in the phrase String
            int middleIndex; // index of the middle character in the String
            String firstHalf; // first half of the phrase String
            String secondHalf; // second half of the phrase String
            String switchedPhrase; //a new phrase with original halves switched
            // compute the length and middle index of the phrase
            phraseLength = phrase.length();
            middleIndex = phraseLength / 2;
            // get the substring for each half of the phrase
            firstHalf = phrase.substring(0,middleIndex);
            secondHalf = phrase.substring(middleIndex, phraseLength);
            // concatenate the firstHalf at the end of the secondHalf
            switchedPhrase = secondHalf.concat(firstHalf);
            // print information about the phrase
            System.out.println();
            System.out.println("Original phrase: " + phrase);
            System.out.println("Length of the phrase: " + phraseLength + " characters");
            System.out.println("Index of the middle: " + middleIndex);
            System.out.println("Character at the middle index: " + phrase.charAt(middleIndex));
            System.out.println("Switched phrase: " + switchedPhrase);
            System.out.println();
            
            String[] stringArray = phrase.split("");
            System.out.println(stringArray[middleIndex - 1] + "" + stringArray[middleIndex] + "" + stringArray[middleIndex + 1]);
            System.out.println(switchedPhrase.replaceAll(" ", "*"));
            
            Scanner keyboard = new Scanner(System.in);
            
            System.out.println("Please enter a city: ");
            String city = keyboard.next().toLowerCase();
            
            System.out.println("Please enter a state: ");
            String state = keyboard.next().toUpperCase();
        
            System.out.println(state + "" + city + "" + state);
            keyboard.close();
    }
}