public class CarBeing implements Behavior {
    private String name;
    private int year;
    private int speed;
    private static int carPopulation = 0;

    public CarBeing(String name, int year, int speed) {
        this.name = name;
        this.year = year;
        this.speed = speed;
        carPopulation++;
    }

    public String tellName() {
        return name;
    }

    public int tellSpeed() {
        return speed;
    }

    public int tellCarAge() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year;
    }

    public static int getCarPopulation() {
        return carPopulation;
    }

    @Override
    public String toString() {
        return "Car Name : " + tellName() + ", Car Age : " + tellCarAge() + ", Car Speed : " + tellSpeed();
    }

    public int compareTo(CarBeing other) {
        if (this.name.equals(other.name) && this.year == other.year) {
            return 10;
        } else if (this.speed == other.speed) {
            return 0;
        } else if (this.speed < other.speed) {
            return -1;
        } else {
            return 1;
        }
    }

    public String compareCar(CarBeing other) {
        int result = this.compareTo(other);
        switch (result) {
            case 10:
                return this.tellName() + " and " + other.tellName() + " are same cars";
            case 0:
                return this.tellName() + " and " + other.tellName() + " have same speed";
            case -1:
                return this.tellName() + "\'s speed is smaller than " + other.tellName();
            case 1:
                return this.tellName() + "\'s speed is bigger than " + other.tellName();
            default:
                return "Unknown result.";
        }
    }
}