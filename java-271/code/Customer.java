import java.util.ArrayList;
import java.time.LocalDate;

public class Customer extends Person {
  // For incremental customId
  private static int customId = 1;

  // Status limits and discount rates, hardcoded
  private static final int SILVER_STATUS_LIMIT = 1000;
  private static final int GOLD_STATUS_LIMIT = 5000;
  private static final double SILVER_DISCOUNT_RATE = 0.10;
  private static final double GOLD_DISCOUNT_RATE = 0.15;

  public int id;
  public float balance;
  private String password;
  public String status = "CLASSIC";

  private float totalSpent = 0;

  public static ArrayList<Item> shoppingCart = new ArrayList<Item>();
  public static ArrayList<Order> orderHistory = new ArrayList<Order>();
  public static ArrayList<Customer> customerList = new ArrayList<Customer>();

  public Customer(String name, String email, String dateOfBirth, float balance, String password) {
    super(name, email, dateOfBirth);
    this.balance = balance;
    this.password = password;
    this.id = customId++;
  }

  // Change password
  public void changePassword(String oldPassword, String newPassword) {
    if (this.password.equals(oldPassword)) {
      this.password = newPassword;
      System.out.println("The password has been successfully changed.");
    } else {
      System.out.println("The given password does not match the current password. Please try again.");
    }
  }

  // Deposit money
  public void depositMoney(float amount) {
    this.balance += amount;
  }

  public void viewCampaigns() {
    System.out.println("Active campaigns:");
    for (Campaign campaign : Campaign.campaignList) {
      System.out.println(campaign.toString());
    }
  }

  // Add items to their shopping cart, if item is available and in stock
  public void addToShoppingCart(int id) {
    Item foundItem = Item.getItem(id);
    if (foundItem != null) {
      shoppingCart.add(foundItem);
      System.out
          .println("The item " + foundItem.getClass().getSimpleName() + " has been successfully added to your cart.");
    } else {
      System.out.println("Invalid item ID");
    }
  }

  // Clear shoppingCart
  public void clearShoppingCart() {
    shoppingCart.clear();
  }

  // Place orders for items in the shopping cart by providing password
  // If password is correct, create an order for each item in the shopping cart
  // add them into orderHistory, decrease balance and update totalSpent and status
  // and clear the shopping cart and print the order details
  public void placeOrder(String password) {
    if (shoppingCart.size() == 0) {
      System.out.println("Shopping cart is empty!");
      return;
    }

    System.out.println(password + " " + this.password);

    if (this.password.equals(password)) {
      float total = 0;
      for (Item item : shoppingCart) {
        total += item.price;
      }

      if (total > this.balance) {
        System.out.println("Not enough balance!");
        return;
      }

      System.out.println("Order details:");

      for (Item item : shoppingCart) {
        if (this.status.equals("SILVER")) {
          item.price -= item.price * SILVER_DISCOUNT_RATE;
        } else if (this.status.equals("GOLDEN")) {
          item.price -= item.price * GOLD_DISCOUNT_RATE;
        }

        for (Campaign campaign : Campaign.campaignList) {
          if (campaign.itemType == item.getClass().getSimpleName()) {
            if (campaign.endDate.compareTo(LocalDate.now().toString()) < 0) {
              continue;
            }

            item.price -= item.price * (campaign.discountRate * 0.01);
          }
        }

        this.balance -= item.price;
        this.totalSpent += item.price;

        Item.deleteFromLists(item.id);
        System.out.println(item.toString());
      }

      Item[] items = new Item[shoppingCart.size()];
      items = shoppingCart.toArray(items);

      Order customerOrder = new Order(LocalDate.now().toString(), total, items, this.id, this.name);
      Order.addToList(customerOrder);
      orderHistory.add(customerOrder);

      updateStatus();
      clearShoppingCart();
    } else {
      System.out.println("The given password does not match the current password. Please try again.");
    }
  }

  public String getStatus() {
    if (this.totalSpent >= GOLD_STATUS_LIMIT) {
      return "GOLDEN";
    } else if (this.totalSpent >= SILVER_STATUS_LIMIT) {
      return "SILVER";
    } else {
      return "CLASSIC";
    }
  }

  public void updateStatus() {
    String status = getStatus();
    this.status = status;
  }

  public static Customer getCustomer(int id) {
    for (Customer customer : customerList) {
      if (customer.id == id) {
        return customer;
      }
    }

    return null;
  }

  public static void addToList(Customer c) {
    customerList.add(c);
  }

  @Override
  public String toString() {
    return "Customer name: " + this.name + " ID: " + this.id + " e-mail: " + this.email + " Date of Birth: "
        + this.dateOfBirth + " Status: " + this.status;
  }
}
