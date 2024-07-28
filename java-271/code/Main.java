import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    for (String filePath : args) {
      File file = new File(filePath);

      String[] splitFilePath = filePath.split("/");
      String fileName = splitFilePath[splitFilePath.length - 1];

      switch (fileName) {
        case "item.txt":
          try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
              String[] props = line.split("\t");
              System.out.println("[------ ITEM ADD ------]");
              Technician.addNewItem("CONSOLE", props);
              System.out.println(line);
            }
          } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
          }

          break;
        case "users.txt":
          try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
              String[] props = line.split("\t");
              switch (props[0]) {
                case "ADMIN":
                  System.out.println("[------ USER: ADMIN ------]");
                  // ADMIN<TAB>name<TAB>email<TAB>birthDate<TAB>salary<TAB>password
                  System.out.println(line);
                  Admin.addAdmin("CONSOLE", props[1], props[2], props[3], Float.parseFloat(props[4]), props[5]);
                  break;
                case "TECH":
                  System.out.println("[------ USER: TECHNICIAN ------]");
                  // TECH<TAB>name<TAB>email<TAB>birthDate<TAB>salary<TAB>isSeniorTechnician
                  System.out.println(line);
                  Admin.addTechnician("CONSOLE", props[1], props[2], props[3], Float.parseFloat(props[4]),
                      Integer.parseInt(props[5]));
                  break;
                case "CUSTOMER":
                  System.out.println("[------ USER: CUSTOMER ------]");
                  System.out.println(line);
                  // CUSTOMER<TAB>name<TAB>email<TAB>birthDate<TAB>balance<TAB>password
                  Admin.addNewCustomer("CONSOLE", props[1], props[2], props[3], Float.parseFloat(props[4]), props[5]);
                  break;
                default:
                  break;
              }
            }
          } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
          }
          break;
        case "commands.txt":
          try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            Customer customer;
            while ((line = reader.readLine()) != null) {
              String[] props = line.split("\t");
              switch (props[0]) {
                case "ORDER":
                  System.out.println("[------ COMMAND: ORDER ------]");
                  // ORDER<TAB>customerID<TAB>customerPassword
                  System.out.println(line);
                  customer = Customer.getCustomer(Integer.parseInt(props[1]));
                  if (customer == null) {
                    System.out.println("Customer with ID " + props[1] + " does not exist.");
                    break;
                  }
                  customer.placeOrder(props[2]);
                  break;
                case "EMPTYCART":
                  System.out.println("[------ COMMAND: EMPTYCART ------]");
                  // EMPTYCART<TAB>customerID
                  System.out.println(line);
                  customer = Customer.getCustomer(Integer.parseInt(props[1]));
                  if (customer == null) {
                    System.out.println("Customer with ID " + props[1] + " does not exist.");
                    break;
                  }
                  customer.clearShoppingCart();
                  break;
                case "ADDTOCART":
                  System.out.println("[------ COMMAND: ADDTOCART ------]");
                  // ADDTOCART<TAB>customerID<TAB>itemID
                  System.out.println(line);
                  customer = Customer.getCustomer(Integer.parseInt(props[1]));
                  if (customer == null) {
                    System.out.println("Customer with ID " + props[1] + " does not exist.");
                    break;
                  }
                  customer.addToShoppingCart(Integer.parseInt(props[2]));
                  break;
                case "SHOWCAMPAIGNS":
                  System.out.println("[------ COMMAND: SHOWCAMPAIGNS ------]");
                  // SHOWCAMPAIGNS<TAB>customerID
                  System.out.println(line);
                  customer = Customer.getCustomer(Integer.parseInt(props[1]));
                  if (customer == null) {
                    System.out.println("Customer with ID " + props[1] + " does not exist.");
                    break;
                  }
                  customer.viewCampaigns();
                  break;
                case "DEPOSITMONEY":
                  System.out.println("[------ COMMAND: DEPOSITMONEY ------]");
                  // DEPOSITMONEY<TAB>customerID<TAB>loadAmount
                  System.out.println(line);
                  customer = Customer.getCustomer(Integer.parseInt(props[1]));
                  if (customer == null) {
                    System.out.println("Customer with ID " + props[1] + " does not exist.");
                    break;
                  }
                  customer.depositMoney(Float.parseFloat(props[2]));
                  break;
                case "CHPASS":
                  System.out.println("[------ COMMAND: CHPASS ------]");
                  // CHPASS<TAB>customerID<TAB>oldPassword<TAB>newPassword
                  System.out.println(line);
                  customer = Customer.getCustomer(Integer.parseInt(props[1]));
                  if (customer == null) {
                    System.out.println("Customer with ID " + props[1] + " does not exist.");
                    break;
                  }
                  customer.changePassword(props[2], props[3]);
                  break;
                case "SHOWORDERS":
                  System.out.println("[------ COMMAND: SHOWORDERS ------]");
                  // SHOWORDERS<TAB>technicianName
                  System.out.println(line);
                  Technician.showAllOrders(props[1]);
                  break;
                case "ADDITEM":
                  System.out.println("[------ COMMAND: ADDITEM ------]");
                  // ADDITEM<TAB>technicianName<TAB>itemType<:>argument1<:>argument2<:>...<:>argumentN
                  System.out.println(line);
                  Technician.addNewItem(props[1], props[2].split(":"));
                  break;
                case "DISPITEMSOF":
                  System.out.println("[------ COMMAND: DISPITEMSOF ------]");
                  // DISPITEMSOF Kubilay BOOK:HAIRCARE:PERFUME
                  System.out.println(line);
                  String[] itemTypes = props[2].split(":");
                  Technician.displayItemInfo(props[1], itemTypes);
                  break;
                case "SHOWVIP":
                  System.out.println("[------ COMMAND: SHOWVIP ------]");
                  // SHOWVIP Alper
                  System.out.println(line);
                  Admin.displayVipCustomers(props[1]);
                  break;
                case "SHOWITEMSLOWONSTOCK":
                  System.out.println("[------ COMMAND: SHOWITEMSLOWONSTOCK ------]");
                  // SHOWITEMSLOWONSTOCK Enes 14
                  System.out.println(line);
                  if (props[2] != null) {
                    Admin.displayLowStockItems(props[1], Integer.parseInt(props[2]));
                  } else {
                    Admin.displayLowStockItems(props[1]);
                  }
                  break;
                case "LISTITEM":
                  System.out.println("[------ COMMAND: LISTITEM ------]");
                  // LISTITEM<TAB>[adminName|technicianName]
                  System.out.println(line);
                  Technician.displayItems(props[1]);
                  break;
                case "ADDADMIN":
                  System.out.println("[------ COMMAND: ADDADMIN ------]");
                  // ADDADMIN<TAB>adminName<TAB>newAdminName<TAB>newAdminMail<TAB>newAdminDateofBirth<TAB>newAdminSalary<TAB>newAdminPassword
                  System.out.println(line);
                  Admin.addAdmin(props[1], props[2], props[3], props[4], Float.parseFloat(props[5]), props[6]);
                  break;
                case "ADDTECH":
                  System.out.println("[------ COMMAND: ADDTECH ------]");
                  // ADDTECH<TAB>adminName<TAB>newTechName<TAB>newTechMail<TAB>newTechDateofBirth<TAB>newTechSalary<TAB>isSenior
                  System.out.println(line);
                  Admin.addTechnician(props[1], props[2], props[3], props[4], Float.parseFloat(props[5]),
                      Integer.parseInt(props[6]));
                  break;
                case "CREATECAMPAIGN":
                  System.out.println("[------ COMMAND: CREATECAMPAIGN ------]");
                  // CREATECAMPAIGN<TAB>Alper<TAB>23.03.2017<TAB>01.06.2017<TAB>BOOK<TAB>25
                  System.out.println(line);
                  Admin.launchCampaign(props[1], props[2], props[3], props[4], Float.parseFloat(props[5]));
                  break;
                case "SHOWADMININFO":
                  System.out.println("[------ COMMAND: SHOWADMININFO ------]");
                  // SHOWADMININFO Can
                  System.out.println(line);
                  Admin.displaySpecificAdmin(props[1]);
                  break;
                case "SHOWCUSTOMERS":
                  System.out.println("[------ COMMAND: SHOWCUSTOMERS ------]");
                  // SHOWCUSTOMERS Demet
                  System.out.println(line);
                  Admin.displayAllCustomers(props[1]);
                  break;
                case "SHOWCUSTOMER":
                  System.out.println("[------ COMMAND: SHOWCUSTOMER ------]");
                  // SHOWCUSTOMER Leyla 3
                  System.out.println(line);
                  Admin.displayPersonalData(props[1], Integer.parseInt(props[2]));
                  break;
                case "ADDCUSTOMER":
                  System.out.println("[------ COMMAND: ADDCUSTOMER ------]");
                  // ADDCUSTOMER Cemil Kerem kerem@yahoo.com 21.02.1993 100000 kerem1111
                  System.out.println(line);
                  Admin.addNewCustomer(props[1], props[2], props[3], props[4], Float.parseFloat(props[5]), props[6]);
                  break;
                default:
                  break;
              }
            }
          } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
          }

          break;
        default:
          break;
      }
    }
  }
}
