public class Electronic extends Item {
  public String brand, manufacturer;
  public float maxInputVoltage, maxPowerConsumption;

  public Electronic(String brand, String manufacturer, float price, float maxInputVoltage, float maxPowerConsumption) {
    super(price);
    this.brand = brand;
    this.manufacturer = manufacturer;
    this.maxInputVoltage = maxInputVoltage;
    this.maxPowerConsumption = maxPowerConsumption;
  }

  public float getMaxInputVoltage() {
    return maxInputVoltage;
  }

  public float getMaxPowerConsumption() {
    return maxPowerConsumption;
  }
}
