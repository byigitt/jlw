public class HairCare extends Cosmetic {
  public static int stock = 0;

  public int isMedicated;

  public HairCare(Float price, String manufacturer, String brand, int isOrganic, String expirationYear, float weight,
      int isMedicated) {
    super(brand, manufacturer, price, weight, expirationYear, isOrganic);
    this.isMedicated = isMedicated;
    stock++;

    Item.addToList(this);
  }

  @Override
  public String toString() {
    return "ID: " + this.id + "\n" + "Type: Hair Care" + "\n" + "Brand: " + this.brand + "\n" + "Manufacturer: "
        + this.manufacturer + "\n" + "Price: " + this.price + "\n" + "Weight: " + this.weight + "\n"
        + "Expiration Date: " + this.expirationYear + "\n" + "Is Organic: " + this.isOrganic + "\n" + "Is Medicated: "
        + this.isMedicated + "\n";
  }
}
