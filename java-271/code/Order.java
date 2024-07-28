import java.util.ArrayList;

public class Order {
  public float totalCost;
  public int customerID;
  public String orderDate;
  public String customerName;
  public Item[] purchasedItems;

  static ArrayList<Order> orderList = new ArrayList<Order>();

  public Order(String orderDate, float totalCost, Item[] purchasedItems, int customerID, String customerName) {
    this.orderDate = orderDate;
    this.totalCost = totalCost;
    this.purchasedItems = purchasedItems;
    this.customerID = customerID;
    this.customerName = customerName;
  }

  public static void displayCustomerOrders(int customerID) {
    for (Order order : Order.orderList) {
      if (order.customerID == customerID) {
        System.out.println(order.toString());
      }
    }
  }

  public static void displayAllOrders() {
    for (Order order : Order.orderList) {
      System.out.println(order.toString());
    }
  }

  // addToList()
  public static void addToList(Order order) {
    orderList.add(order);
  }

  // getCustomerName()
  public static String getCustomerName(int customerID) {
    for (Customer customer : Customer.customerList) {
      if (customer.id == customerID) {
        return customer.getName();
      }
    }
    return "No customer with ID " + customerID + " exists!";
  }

  public String showOrder() {
    String orderString = "Order date: " + this.orderDate + " Customer name: " + this.customerName + " Customer ID: "
        + this.customerID + " Total cost: " + this.totalCost + "\n";

    for (Item item : this.purchasedItems) {
      orderString += item.toString() + "\n";
    }

    return orderString;
  }
}
