import java.util.Date;

public class SportsCar extends Car {
    private int horsepower;
    private boolean isBooked;

    public SportsCar(String id, String plateNumber, int numberOfTires, double dailyFee, String color, int seatingCapacity, int numOfDoors, int horsepower) {
        super(id, plateNumber, numberOfTires, dailyFee, color, seatingCapacity, numOfDoors);
        this.horsepower = horsepower;
        this.isBooked = false;
    }

    @Override
    public void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
        // Check availability and book the sports car
        if (isBooked) {
            throw new SorryWeDontHaveThatOneException("Sports car with plate number " + getPlateNumber() + " is already booked.");
        }
        // Perform the booking process
        isBooked = true;
        System.out.println("Sports car with plate number " + getPlateNumber() + " is successfully booked from " + startDate + " to " + endDate);
    }

    @Override
    public void cancelMe(Date cancellationDate) throws NoCancellationYouMustPayException {
        // Check cancellation date and cancel the booking if allowed
        if (isBooked && cancellationDate.before(new Date())) {
            throw new NoCancellationYouMustPayException("Cancellation after the starting date of rental is not allowed for the sports car with plate number " + getPlateNumber());
        }
        // Perform the cancellation process
        isBooked = false;
        System.out.println("Booking for sports car with plate number " + getPlateNumber() + " is successfully canceled.");
    }

    @Override
    public void rentMe(Date startDate, Date endDate, String pickupLocation, String dropOffLocation) throws SorryWeDontHaveThatOneException {
        // Check availability and rent the sports car
        if (isBooked) {
            throw new SorryWeDontHaveThatOneException("Sports car with plate number " + getPlateNumber() + " is already booked.");
        }
        // Perform the renting process
        isBooked = true;
        System.out.println("Sports car with plate number " + getPlateNumber() + " is successfully rented from " + startDate + " to " + endDate);
    }

    @Override
    public void dropMe() {
        // Perform the drop-off process
        isBooked = false;
        System.out.println("Sports car with plate number " + getPlateNumber() + " is successfully dropped off.");
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
