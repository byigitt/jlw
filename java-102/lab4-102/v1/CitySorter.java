import java.util.Scanner;

public class CitySorter {
    public static void main(String[] args) {
        String[] strArr = {"ANKARA", "ISTANBUL"};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a city name:");
            String city = scanner.nextLine().toUpperCase();
            if (city.equals("STOP")) {
                break;
            }
            int index = 0;
            while (index < strArr.length && city.compareTo(strArr[index]) > 0) {
                index++;
            }
            String[] newStrArr = new String[strArr.length + 1];
            for (int i = 0; i < index; i++) {
                newStrArr[i] = strArr[i];
            }
            newStrArr[index] = city;
            for (int i = index; i < strArr.length; i++) {
                newStrArr[i + 1] = strArr[i];
            }
            strArr = newStrArr;
            for (String cityInArr : strArr) {
                System.out.print(cityInArr + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
