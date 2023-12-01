import java.io.*;
import java.util.*;

public class VehiclePark {
    private List<Vehicle> vehicles;
    private List<Vehicle> bookedVehicles;
    private List<Vehicle> rentedVehicles;
    private List<Customer> registeredCustomers;

    public VehiclePark() {
        vehicles = new ArrayList<>();
        bookedVehicles = new ArrayList<>();
        rentedVehicles = new ArrayList<>();
        registeredCustomers = new ArrayList<>();
    }

    public void displayVehicles() {
        System.out.println("All Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    public void displayAvailableVehicles(Date startDate, Date endDate) {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            if (!isBooked(vehicle, startDate, endDate)) {
                System.out.println(vehicle.toString());
            }
        }
    }

    public void displayAvailableVehicles(Date startDate, Date endDate, Class<? extends Vehicle> vehicleType) {
        System.out.println("Available " + vehicleType.getSimpleName() + " Vehicles:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().equals(vehicleType) && !isBooked(vehicle, startDate, endDate)) {
                System.out.println(vehicle.toString());
            }
        }
    }

    private boolean isBooked(Vehicle vehicle, Date startDate, Date endDate) {
        for (Vehicle bookedVehicle : bookedVehicles) {
            if (bookedVehicle.equals(vehicle) && isOverlap(startDate, endDate, bookedVehicle.getStartDate(), bookedVehicle.getEndDate())) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverlap(Date startDate1, Date endDate1, Date startDate2, Date endDate2) {
        return startDate1.before(endDate2) && endDate1.after(startDate2);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void bookVehicle(Customer customer, Vehicle vehicle, Date startDate, Date endDate) throws SorryWeDontHaveThatOneException {
        if (!vehicles.contains(vehicle) || isBooked(vehicle, startDate, endDate)) {
            throw new SorryWeDontHaveThatOneException("Vehicle is not available for booking.");
        }
        vehicle.setStartDate(startDate);
        vehicle.setEndDate(endDate);
        bookedVehicles.add(vehicle);
        customer.addBookedVehicle(vehicle);
    }

    public void cancelBooking(Customer customer, Vehicle vehicle) throws NoCancellationYouMustPayException {
        if (!customer.getBookedVehicles().contains(vehicle)) {
            throw new NoCancellationYouMustPayException("No booking found for the given vehicle.");
        }
        if (vehicle.getStartDate().before(new Date())) {
            throw new NoCancellationYouMustPayException("Cancellation after the starting date of rental is not allowed.");
        }
        vehicle.setStartDate(null);
        vehicle.setEndDate(null);
        bookedVehicles.remove(vehicle);
        customer.removeBookedVehicle(vehicle);
    }

    public void rentVehicle(Customer customer, Vehicle vehicle, Date startDate, Date endDate, String pickupLocation, String dropOffLocation) throws SorryWeDontHaveThatOneException {
        if (!vehicles.contains(vehicle) || isBooked(vehicle, startDate, endDate)) {
            throw new SorryWeDontHaveThatOneException("Vehicle is not available for rental.");
        }
        vehicle.setStartDate(startDate);
        vehicle.setEndDate(endDate);
        rentedVehicles.add(vehicle);
        customer.addRentedVehicle(vehicle);
        vehicle.setPickupLocation(pickupLocation);
        vehicle.setDropOffLocation(dropOffLocation);
    }

    public void dropVehicle(Customer customer, Vehicle vehicle) {
        if (!customer.getRentedVehicles().contains(vehicle)) {
            System.out.println("Vehicle is not rented by the customer.");
            return;
        }
        vehicle.setStartDate(null);
        vehicle.setEndDate(null);
        rentedVehicles.remove(vehicle);
        customer.removeRentedVehicle(vehicle);
        vehicle.setPickupLocation(null);
        vehicle.setDropOffLocation(null);
        System.out.println("Vehicle is dropped off successfully.");
    }

    public void load(Customer customer, Loadable vehicle, int additionalLoad) throws OverWeightException {
        vehicle.loadMe(additionalLoad);
        customer.setLoad(customer.getLoad() + additionalLoad);
    }

    public void dailyReport(String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(vehicles);
            objectOutputStream.writeObject(bookedVehicles);
            objectOutputStream.writeObject(rentedVehicles);
            objectOutputStream.writeObject(registeredCustomers);
            System.out.println("Daily report is generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}