public class SkinCare extends Cosmetic {
  public static int stock = 0;

  public int isBabySensitive;

  public SkinCare(Float price, String manufacturer, String brand, int isOrganic, String expirationYear, float weight,
      int isBabySensitive) {
    super(brand, manufacturer, price, weight, expirationYear, isOrganic);
    this.isBabySensitive = isBabySensitive;
    stock++;

    Item.addToList(this);
  }

  @Override
  public String toString() {
    return "ID: " + this.id + "\n" + "Type: Skin Care" + "\n" + "Brand: " + this.brand + "\n" + "Manufacturer: "
        + this.manufacturer + "\n" + "Price: " + this.price + "\n" + "Weight: " + this.weight + "\n"
        + "Expiration Year: " + this.expirationYear + "\n" + "Is Organic: " + this.isOrganic + "\n"
        + "Is Baby Sensitive: " + this.isBabySensitive + "\n";
  }
}
