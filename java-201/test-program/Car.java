import java.util.Date;

public abstract class Car extends Vehicle implements Rentable {
    protected String color;
    protected int seatingCapacity;
    protected int numOfDoors;

    public Car(String id, String plateNumber, int numberOfTires, double dailyFee, String color, int seatingCapacity, int numOfDoors) {
        super(id, plateNumber, numberOfTires, dailyFee);
        this.color = color;
        this.seatingCapacity = seatingCapacity;
        this.numOfDoors = numOfDoors;
    }

    // Implement Rentable methods
    public abstract void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException;
    public abstract void cancelMe(Date cancellationDate) throws NoCancellationYouMustPayException;
    public abstract void rentMe(Date startDate, Date endDate, String pickupLocation, String dropOffLocation) throws SorryWeDontHaveThatOneException;
    public abstract void dropMe();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }
}
