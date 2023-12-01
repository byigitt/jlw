import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private List<Vehicle> bookedVehicles;
    private List<Vehicle> rentedVehicles;
    private int load;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.bookedVehicles = new ArrayList<>();
        this.rentedVehicles = new ArrayList<>();
        this.load = 0;
    }

    public void addBookedVehicle(Vehicle vehicle) {
        bookedVehicles.add(vehicle);
    }

    public void removeBookedVehicle(Vehicle vehicle) {
        bookedVehicles.remove(vehicle);
    }

    public void addRentedVehicle(Vehicle vehicle) {
        rentedVehicles.add(vehicle);
    }

    public void removeRentedVehicle(Vehicle vehicle) {
        rentedVehicles.remove(vehicle);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getBookedVehicles() {
        return bookedVehicles;
    }

    public void setBookedVehicles(List<Vehicle> bookedVehicles) {
        this.bookedVehicles = bookedVehicles;
    }

    public List<Vehicle> getRentedVehicles() {
        return rentedVehicles;
    }

    public void setRentedVehicles(List<Vehicle> rentedVehicles) {
        this.rentedVehicles = rentedVehicles;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }
}