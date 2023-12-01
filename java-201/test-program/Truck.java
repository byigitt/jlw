import java.util.Date;

public abstract class Truck extends Vehicle implements Rentable {
    private int loadingCapacity;
    private boolean isBooked;
    private Date startDate;
    private Date endDate;
    private String pickupLocation;
    private String dropOffLocation;

    public Truck(String id, String plateNumber, int numberOfTires, double dailyFee, int loadingCapacity) {
        super(id, plateNumber, numberOfTires, dailyFee);
        this.loadingCapacity = loadingCapacity;
        this.isBooked = false;
    }

    // Implement Rentable methods
    public abstract void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException;
    public abstract void cancelMe(Date cancellationDate) throws NoCancellationYouMustPayException;
    public abstract void rentMe(Date startDate, Date endDate, String pickupLocation, String dropOffLocation) throws SorryWeDontHaveThatOneException;
    public abstract void dropMe();

    public int getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(int loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }
}
