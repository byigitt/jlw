public class OfficeSupplies extends Item {
  public String coverTitle;
  public String releaseDate;

  public static int stock = 0;

  public OfficeSupplies(String coverTitle, String releaseDate, float price) {
    super(price);
    this.coverTitle = coverTitle;
    this.releaseDate = releaseDate;
    stock++;
  }
}
