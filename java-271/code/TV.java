public class TV extends Electronic {
  public float screenSize;

  public static int stock = 0;

  public TV(float price, String manufacturer, String brand, float maxVolt, float maxWatt, float screenSize) {
    super(brand, manufacturer, price, maxVolt, maxWatt);
    this.screenSize = screenSize;
    stock++;

    Item.addToList(this);
  }

  @Override
  public String toString() {
    return "ID: " + this.id + "\n" + "Type: TV" + "\n" + "Brand: " + this.brand + "\n" + "Manufacturer: "
        + this.manufacturer + "\n" + "Price: " + this.price + "\n" + "Max Input Voltage: " + getMaxInputVoltage() + "\n"
        + "Max Power Consumption: " + getMaxPowerConsumption() + "\n" + "Screen Size: " + this.screenSize + "\n";
  }
}
