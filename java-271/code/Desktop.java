public class Desktop extends Computer {
  public String boxColor;

  public static int stock = 0;

  public Desktop(float price, String manufacturer, String brand, float maxVolt, float maxWatt, String operatingSystem,
      String cpuType, int ramCapacity, float hddCapacity, String boxColor) {
    super(brand, manufacturer, price, maxVolt, maxWatt, operatingSystem, cpuType, ramCapacity,
        hddCapacity);
    this.boxColor = boxColor;
    stock++;

    Item.addToList(this);
  }

  @Override
  public String toString() {
    return "ID: " + this.id + "\n" + "Type: Desktop" + "\n" + "Brand: " + this.brand + "\n" + "Manufacturer: "
        + this.manufacturer + "\n" + "Price: " + this.price + "\n" + "Max Input Voltage: " + getMaxInputVoltage() + "\n"
        + "Max Power Consumption: " + getMaxPowerConsumption() + "\n" + "Operating System: " + this.operatingSystem
        + "\n"
        + "CPU Type: " + this.cpuType + "\n" + "RAM Capacity: " + this.ramCapacity + "\n" + "HDD Capacity: "
        + this.hddCapacity + "\n"
        + "Box Color: " + this.boxColor + "\n";
  }
}
