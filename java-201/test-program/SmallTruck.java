import java.util.Date;

public class SmallTruck extends Truck {
    public SmallTruck(String id, String plateNumber, int numberOfTires, double dailyFee, int loadingCapacity) {
        super(id, plateNumber, numberOfTires, dailyFee, loadingCapacity);
    }

    @Override
    public void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
        // Check if the small truck can be booked at least 7 days before rental
        long bookingPeriod = endDate.getTime() - startDate.getTime();
        long daysBeforeRental = bookingPeriod / (1000 * 60 * 60 * 24);
        if (daysBeforeRental < 7) {
            throw new SorryWeDontHaveThatOneException("Small truck with plate number " + getPlateNumber() + " must be booked at least 7 days before rental.");
        }

        // Perform the booking process
        if (isBooked()) {
            throw new SorryWeDontHaveThatOneException("Small truck with plate number " + getPlateNumber() + " is already booked.");
        }
        setStartDate(startDate);
        setEndDate(endDate);
        setBooked(true);
        System.out.println("Small truck with plate number " + getPlateNumber() + " is successfully booked from " + startDate + " to " + endDate);
    }

    @Override
    public void cancelMe(Date cancellationDate) throws NoCancellationYouMustPayException {
        if (getStartDate() == null || getEndDate() == null) {
            throw new NoCancellationYouMustPayException("No booking found for SmallTruck with plate number " + getPlateNumber() + ".");
        }

        if (cancellationDate.after(getStartDate())) {
            throw new NoCancellationYouMustPayException("Cancellation after the starting date of rental is not allowed for SmallTruck with plate number " + getPlateNumber() + ".");
        }

        setStartDate(null);
        setEndDate(null);
        setBooked(false);
        System.out.println("Booking for SmallTruck with plate number " + getPlateNumber() + " has been cancelled.");
    }

    @Override
    public void rentMe(Date startDate, Date endDate, String pickupLocation, String dropOffLocation) throws SorryWeDontHaveThatOneException {
        if (getStartDate() != null || getEndDate() != null) {
            throw new SorryWeDontHaveThatOneException("SmallTruck with plate number " + getPlateNumber() + " is already rented.");
        }

        setStartDate(startDate);
        setEndDate(endDate);
        setPickupLocation(pickupLocation);
        setDropOffLocation(dropOffLocation);
        setBooked(false);
        System.out.println("SmallTruck with plate number " + getPlateNumber() + " is successfully rented from " + startDate + " to " + endDate + ".");
    }

    @Override
    public void dropMe() {
        if (getStartDate() == null || getEndDate() == null) {
            System.out.println("SmallTruck with plate number " + getPlateNumber() + " is not currently rented.");
            return;
        }

        setStartDate(null);
        setEndDate(null);
        setPickupLocation(null);
        setDropOffLocation(null);
        System.out.println("SmallTruck with plate number " + getPlateNumber() + " has been dropped off successfully.");
    }
}