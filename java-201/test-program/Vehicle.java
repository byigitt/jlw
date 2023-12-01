import java.io.Serializable;

public abstract class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String plateNumber;
    protected int numberOfTires;
    protected double dailyFee;

    public Vehicle(String id, String plateNumber, int numberOfTires, double dailyFee) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.numberOfTires = numberOfTires;
        this.dailyFee = dailyFee;
    }

    public abstract void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException;
    public abstract void cancelMe(Date cancellationDate) throws NoCancellationYouMustPayException;
    public abstract void rentMe(Date startDate, Date endDate, String pickupLocation, String dropOffLocation) throws SorryWeDontHaveThatOneException;
    public abstract void dropMe();

    public double getDailyFee(int numberOfDays) {
        return numberOfDays * dailyFee;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getPlateNumber() {
        return plateNumber;
    }
    
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    
    public int getNumberOfTires() {
        return numberOfTires;
    }
    
    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }
    
    public double getDailyFee() {
        return dailyFee;
    }
    
    public void setDailyFee(double dailyFee) {
        this.dailyFee = dailyFee;
    }
}
