import java.util.Date;

public class StationWagon extends Car implements Loadable {
    private int loadingCapacity;
    private boolean isBooked;
    private int currentLoad;

    public StationWagon(String id, String plateNumber, int numberOfTires, double dailyFee, String color, int seatingCapacity, int numOfDoors, int loadingCapacity) {
        super(id, plateNumber, numberOfTires, dailyFee, color, seatingCapacity, numOfDoors);
        this.loadingCapacity = loadingCapacity;
        this.isBooked = false;
        this.currentLoad = 0;
    }

    @Override
    public void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
        // Check availability and book the station wagon
        if (isBooked) {
            throw new SorryWeDontHaveThatOneException("Station wagon with plate number " + getPlateNumber() + " is already booked.");
        }
        // Perform the booking process
        isBooked = true;
        System.out.println("Station wagon with plate number " + getPlateNumber() + " is successfully booked from " + startDate + " to " + endDate);
    }

    @Override
    public void cancelMe(Date cancellationDate) throws NoCancellationYouMustPayException {
        // Check cancellation date and cancel the booking if allowed
        if (isBooked && cancellationDate.before(new Date())) {
            throw new NoCancellationYouMustPayException("Cancellation after the starting date of rental is not allowed for the station wagon with plate number " + getPlateNumber());
        }
        // Perform the cancellation process
        isBooked = false;
        System.out.println("Booking for station wagon with plate number " + getPlateNumber() + " is successfully canceled.");
    }

    @Override
    public void rentMe(Date startDate, Date endDate, String pickupLocation, String dropOffLocation) throws SorryWeDontHaveThatOneException {
        // Check availability and rent the station wagon
        if (isBooked) {
            throw new SorryWeDontHaveThatOneException("Station wagon with plate number " + getPlateNumber() + " is already booked.");
        }
        // Perform the renting process
        isBooked = true;
        System.out.println("Station wagon with plate number " + getPlateNumber() + " is successfully rented from " + startDate + " to " + endDate);
    }

    @Override
    public void dropMe() {
        // Perform the drop-off process
        isBooked = false;
        System.out.println("Station wagon with plate number " + getPlateNumber() + " is successfully dropped off.");
    }

    @Override
    public void loadMe(int additionalLoad) throws OverWeightException {
        if (currentLoad + additionalLoad > loadingCapacity) {
            throw new OverWeightException("Loading capacity exceeded for station wagon with plate number " + getPlateNumber());
        }
        currentLoad += additionalLoad;
        System.out.println("Additional load of " + additionalLoad + " kg is successfully loaded onto station wagon with plate number " + getPlateNumber());
    }

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

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }
}
