import java.util.ArrayList;

public class Admin extends Employee {
  private String password;
  static ArrayList<Admin> adminList = new ArrayList<Admin>();

  public Admin(String name, String email, String dateOfBirth, float salary, String password) {
    super(name, email, dateOfBirth, salary);
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public static void addNewCustomer(String adminName, String customerName, String customerMail,
      String customerDateOfBirth, float balance, String customerPassword) {

    if (validAdmin(adminName) == false && adminName != "CONSOLE") {
      System.out.println("No admin person named " + adminName + " exists!");
      return;
    }

    Customer.addToList(new Customer(customerName, customerMail, customerDateOfBirth, balance, customerPassword));
  }

  public static boolean validAdmin(String adminName) {
    for (Admin admin : Admin.adminList) {
      if (admin.getName().equals(adminName)) {
        return true;
      }
    }
    return false;
  }

  public static void addTechnician(String adminName, String technicianName, String technicianMail,
      String technicianDateOfBirth, float technicianSalary, int isSenior) {

    if (validAdmin(adminName) == false && adminName != "CONSOLE") {
      System.out.println("No admin person named " + adminName + " exists!");
      return;
    }

    if (Technician.validTechnician(technicianName)) {
      System.out.println("Technician person named " + technicianName + " already exists!");
      return;
    }

    Technician.addToList(new Technician(technicianName, technicianMail, technicianDateOfBirth, technicianSalary,
        isSenior));
  }

  public static void addAdmin(String adminName, String newAdminName, String newAdminMail,
      String newAdminDateOfBirth, float newAdminSalary, String newAdminPassword) {

    if (validAdmin(adminName) == false && adminName != "CONSOLE") {
      System.out.println("No admin person named " + adminName + " exists!");
      return;
    }

    if (validAdmin(newAdminName)) {
      System.out.println("Admin person named " + newAdminName + " already exists!");
      return;
    }

    Admin.addToList(new Admin(newAdminName, newAdminMail, newAdminDateOfBirth, newAdminSalary, newAdminPassword));
  }

  public static void addToList(Admin a) {
    adminList.add(a);
  }

  public static void displayPersonalData(String adminName, int id) {
    if (validAdmin(adminName) == false) {
      System.out.println("No admin person named " + adminName + " exists!");
      return;
    }

    Customer customer = Customer.getCustomer(id);

    if (customer == null) {
      System.out.println("No customer with id " + id + " exists!");
      return;
    }

    System.out.println(customer.toString());
  }

  public static void displayAllCustomers(String adminName) {
    if (validAdmin(adminName) == false) {
      System.out.println("No admin person named " + adminName + " exists!");
      return;
    }

    for (Customer customer : Customer.customerList) {
      System.out.println(customer.toString());
    }
  }

  public static void displaySpecificAdmin(String adminName) {
    if (validAdmin(adminName) == false) {
      System.out.println("No admin person named " + adminName + " exists!");
      return;
    }

    for (Admin admin : Admin.adminList) {
      if (admin.getName().equals(adminName)) {
        System.out.println(admin.toString());
        return;
      }
    }

    System.out.println("No admin person named " + adminName + " exists!");
  }

  public static void launchCampaign(String adminName, String startDate, String endDate, String itemType,
      float campaignDiscountRate) {

    if (validAdmin(adminName) == false) {
      System.out.println("No admin person named " + adminName + " exists!");
      return;
    }

    for (Campaign campaign : Campaign.campaignList) {
      if (campaign.itemType.equals(itemType)) {
        System.out.println("Campaign for " + itemType + " is already launched!");
        return;
      }
    }

    if (campaignDiscountRate > 50) {
      System.out.println("Discount rate cannot be more than 50!");
      return;
    }

    Campaign.addToList(new Campaign(startDate, endDate, itemType, campaignDiscountRate));
  }

  // Show vip customers
  public static void displayVipCustomers(String adminName) {
    if (validAdmin(adminName) == false && Technician.validTechnician(adminName) == false) {
      System.out.println("No admin or technician person named " + adminName + " exists!");
      return;
    }

    if (Customer.customerList.size() == 0) {
      System.out.println("No VIP customer exists!");
      return;
    }

    for (Customer customer : Customer.customerList) {
      if (customer.status == "GOLDEN" || customer.status == "SILVER") {
        System.out.println(customer.toString());
      }
    }
  }

  public static void displayLowStockItems(String adminName) {
    if (validAdmin(adminName) == false && Technician.validTechnician(adminName) == false) {
      System.out.println("No admin or technician person named " + adminName + " exists!");
      return;
    }

    System.out.println("Book: " + Book.stock);
    System.out.println("CDDVD: " + CDDVD.stock);
    System.out.println("Desktop: " + Desktop.stock);
    System.out.println("Laptop: " + Laptop.stock);
    System.out.println("Tablet: " + Tablet.stock);
    System.out.println("TV: " + TV.stock);
    System.out.println("SmartPhone: " + SmartPhone.stock);
    System.out.println("HairCare: " + HairCare.stock);
    System.out.println("Perfume: " + Perfume.stock);
    System.out.println("SkinCare: " + SkinCare.stock);
  }

  public static void displayLowStockItems(String adminName, int threshold) {
    if (validAdmin(adminName) == false && Technician.validTechnician(adminName) == false) {
      System.out.println("No admin or technician person named " + adminName + " exists!");
      return;
    }

    if (Book.stock < threshold) {
      System.out.println("Book: " + Book.stock);
    }
    if (CDDVD.stock < threshold) {
      System.out.println("CDDVD: " + CDDVD.stock);
    }
    if (Desktop.stock < threshold) {
      System.out.println("Desktop: " + Desktop.stock);
    }
    if (Laptop.stock < threshold) {
      System.out.println("Laptop: " + Laptop.stock);
    }
    if (Tablet.stock < threshold) {
      System.out.println("Tablet: " + Tablet.stock);
    }
    if (TV.stock < threshold) {
      System.out.println("TV: " + TV.stock);
    }
    if (SmartPhone.stock < threshold) {
      System.out.println("SmartPhone: " + SmartPhone.stock);
    }
    if (HairCare.stock < threshold) {
      System.out.println("HairCare: " + HairCare.stock);
    }
    if (Perfume.stock < threshold) {
      System.out.println("Perfume: " + Perfume.stock);
    }
    if (SkinCare.stock < threshold) {
      System.out.println("SkinCare: " + SkinCare.stock);
    }
  }

  // Display specific items
  public static void displayItems(String adminName, String[] itemTypes) {
    if (validAdmin(adminName) == false && Technician.validTechnician(adminName) == false) {
      System.out.println("No admin or technician person named " + adminName + " exists!");
      return;
    }

    // if itemTypes has book
    for (String itemType : itemTypes) {
      if (itemType.equals("Book")) {
        for (Book book : Book.books) {
          System.out.println(book.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equals("CDDVD")) {
        for (CDDVD CDDVD : CDDVD.CDDVDs) {
          System.out.println(CDDVD.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equals("Desktop")) {
        for (Desktop desktop : Desktop.desktops) {
          System.out.println(desktop.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equals("Laptop")) {
        for (Laptop laptop : Laptop.laptops) {
          System.out.println(laptop.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equals("Tablet")) {
        for (Tablet tablet : Tablet.tablets) {
          System.out.println(tablet.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equals("TV")) {
        for (TV TV : TV.TVs) {
          System.out.println(TV.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equals("SmartPhone")) {
        for (SmartPhone smartPhone : SmartPhone.smartPhones) {
          System.out.println(smartPhone.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equals("HairCare")) {
        for (HairCare hairCare : HairCare.hairCares) {
          System.out.println(hairCare.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equals("Perfume")) {
        for (Perfume perfume : Perfume.perfumes) {
          System.out.println(perfume.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equals("SkinCare")) {
        for (SkinCare skinCare : SkinCare.skinCares) {
          System.out.println(skinCare.toString());
          System.out.println("-----------------------");
        }
      }
    }
  }

  @Override
  public String toString() {
    return "----------- Admin info -----------" + "\nAdmin name: " + this.getName() +
        "\nAdmin email: " + this.getEmail() + "\nAdmin date of birth: " + this.getDateOfBirth();
  }
}
