public class Book extends OfficeSupplies {
  public int pages;
  public String publisher;
  public String[] authors;

  public static int stock = 0;

  public Book(float price, String releaseDate, String coverTitle, String publisher, String[] authors, int pages) {
    super(coverTitle, releaseDate, price);
    this.publisher = publisher;
    this.authors = authors;
    this.pages = pages;
    stock++;

    Item.addToList(this);
  }

  @Override
  public String toString() {
    String authorsString = "";
    for (String author : authors) {
      authorsString += author + ", ";
    }
    authorsString = authorsString.substring(0, authorsString.length() - 2);

    return "ID: " + this.id + "\n" + "Type: Book" + "\n" + "Title: " + this.coverTitle + "\n" + "Price: " + this.price
        + "\n" + "Release Date: " + this.releaseDate + "\n" + "Publisher: " + this.publisher + "\n" + "Authors: "
        + authorsString + "\n" + "Pages: " + this.pages + "\n";
  }

}
