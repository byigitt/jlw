public class Tablet extends Computer {
  public float dimension;

  public static int stock = 0;

  public Tablet(float price, String manufacturer, String brand, float maxVolt, float maxWatt, String operatingSystem,
      String cpuType, int ramCapacity, float hddCapacity, float dimension) {
    super(brand, manufacturer, price, maxVolt, maxWatt, operatingSystem, cpuType, ramCapacity,
        hddCapacity);
    this.dimension = dimension;
    stock++;

    Item.addToList(this);
  }

  @Override
  public String toString() {
    return "ID: " + this.id + "\n" + "Type: Tablet" + "\n" + "Brand: " + this.brand + "\n" + "Manufacturer: "
        + this.manufacturer + "\n" + "Price: " + this.price + "\n" + "Max Input Voltage: " + getMaxInputVoltage() + "\n"
        + "Max Power Consumption: " + getMaxPowerConsumption() + "\n" + "Operating System: " + this.operatingSystem
        + "\n"
        + "CPU Type: " + this.cpuType + "\n" + "RAM Capacity: " + this.ramCapacity + "\n" + "HDD Capacity: "
        + this.hddCapacity + "\n"
        + "Dimension: " + this.dimension + "\n";
  }
}
