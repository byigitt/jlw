// ************************************************************************
// Seller.java
//
// A seller class with methods for adding and removing products, changing ratings, and printing seller information.
// ************************************************************************
public class Seller {
    public String name;
    public double rating;
    public int Numberofproducts;

    // ---------------------------------------------------------------
    // Constructor -- initializes name, rating, number of products
    // ---------------------------------------------------------------

    public Seller(String name, double rating, int numberOfProducts) {
        this.name = name;
        this.rating = rating;
        this.Numberofproducts = numberOfProducts;
    };
    
    // --------------------------------
    // Decrements products number by the given parameter
    // --------------------------------
    public int removeProduct(int num) {
        if (Numberofproducts >= num) {
            Numberofproducts -= num;
            return Numberofproducts;
        } else {
            System.out.println("Insufficient products in stock.");
            return -1;
        }
    };
    
    // --------------------------------
    // Increases product number by the given parameter
    // --------------------------------
    public int addProduct(int num) {
        Numberofproducts += num;
        return Numberofproducts;
    };   

    // --------------------------------------------------------------------
    // Returns a string containing the name, number of products.
    // --------------------------------------------------------------------
    public String toString() {
        return "Seller " + name + " has " + Numberofproducts + " products and the seller rating is " + rating;
    };
    
    // --------------------------------------------------
    // Change the rating of the seller by the given parameter
    // --------------------------------------------------
    public void changeRating(double rating) {
        this.rating = rating;
    };
    
};