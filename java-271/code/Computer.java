public class Computer extends Electronic {
  public String operatingSystem, cpuType;
  public float ramCapacity, hddCapacity;

  public Computer(String brand, String manufacturer, float price, float maxInputVoltage, float maxPowerConsumption,
      String operatingSystem, String cpuType, float ramCapacity, float hddCapacity) {
    super(brand, manufacturer, price, maxInputVoltage, maxPowerConsumption);
    this.operatingSystem = operatingSystem;
    this.cpuType = cpuType;
    this.ramCapacity = ramCapacity;
    this.hddCapacity = hddCapacity;
  }
}
