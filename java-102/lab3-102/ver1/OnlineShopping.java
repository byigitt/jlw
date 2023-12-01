import java.util.Scanner;

public class OnlineShopping {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        String name;
        double rating;
        int numberOfProducts;

        System.out.println("Enter the number of sellers: ");
        int sellerNumber = keyboard.nextInt();
        
        Seller sellers[] = new Seller[sellerNumber];

        for (int i = 0; i < sellerNumber; i++) {
            System.out.println("Seller name: ");
            name = keyboard.next();

            System.out.println("Seller rating: ");
            rating = keyboard.nextDouble();

            System.out.println("Number of products by the seller: ");
            numberOfProducts = keyboard.nextInt();

            sellers[i] = new Seller(name, rating, numberOfProducts);
        };

        keyboard.close();

        for (int i = 0; i < sellers.length; i++) {
            System.out.println(sellers[i].toString());
        };

        sellers[0].removeProduct(50);
        System.out.println("Current number of products: " + sellers[0].Numberofproducts);
        
        sellers[2].addProduct(100);
        System.out.println("Current number of products: " + sellers[2].Numberofproducts);
        
        sellers[1].changeRating(sellers[1].rating - 0.6);
        sellers[2].changeRating(sellers[2].rating + 0.5);

        for (int i = 0; i < sellers.length; i++) {
            System.out.println(sellers[i].toString());
        };
    };
}
