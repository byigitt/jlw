public class Perfume extends Cosmetic {
  public static int stock = 0;
  public float lastingDuration;

  public Perfume(Float price, String manufacturer, String brand, int isOrganic, String expirationYear, float weight,
      float lastingDuration) {
    super(brand, manufacturer, price, weight, expirationYear, isOrganic);
    this.lastingDuration = lastingDuration;
    stock++;

    Item.addToList(this);
  }

  @Override
  public String toString() {
    return "ID: " + this.id + "\n" + "Type: Perfume" + "\n" + "Brand: " + this.brand + "\n" + "Manufacturer: "
        + this.manufacturer + "\n" + "Price: " + this.price + "\n" + "Weight: " + this.weight + "\n"
        + "Expiration Year: " + this.expirationYear + "\n" + "Is Organic: " + this.isOrganic + "\n"
        + "Lasting Duration: " + this.lastingDuration + "\n";
  }
}
