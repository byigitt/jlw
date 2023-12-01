import java.util.Date;

public interface Rentable {
    void bookMe(Date startDate, Date endDate) throws SorryWeDontHaveThatOneException;
    void cancelMe(Date cancellationDate) throws NoCancellationYouMustPayException;
    void rentMe(Date startDate, Date endDate, String pickupLocation, String dropOffLocation) throws SorryWeDontHaveThatOneException;
    void dropMe();
}