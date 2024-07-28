public class SmartPhone extends Electronic {
  public String screenType;

  public static int stock = 0;

  public SmartPhone(float price, String manufacturer, String brand, float maxVolt, float maxWatt,
      String screenType) {
    super(brand, manufacturer, price, maxVolt, maxWatt);
    this.screenType = screenType;
    stock++;

    Item.addToList(this);
  }

  @Override
  public String toString() {
    return "ID: " + this.id + "\n" + "Type: SmartPhone" + "\n" + "Brand: " + this.brand + "\n" + "Manufacturer: "
        + this.manufacturer + "\n" + "Price: " + this.price + "\n" + "Max Input Voltage: " + getMaxInputVoltage() + "\n"
        + "Max Power Consumption: " + getMaxPowerConsumption() + "\n" + "Screen Type: " + this.screenType + "\n";
  }
}
