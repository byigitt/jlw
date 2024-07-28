public class Cosmetic extends Item {
  public String brand, manufacturer;
  public float weight;

  public String expirationYear;
  public int isOrganic;

  public Cosmetic(String brand, String manufacturer, float price, float weight, String expirationYear,
      int isOrganic) {
    super(price);
    this.brand = brand;
    this.weight = weight;
    this.manufacturer = manufacturer;
    this.expirationYear = expirationYear;
    this.isOrganic = isOrganic;
  }
}
