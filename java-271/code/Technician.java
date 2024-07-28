import java.util.ArrayList;

public class Technician extends Employee {
  public int isSenior;
  static ArrayList<Technician> technicianList = new ArrayList<Technician>();

  public Technician(String name, String email, String dateOfBirth, float salary, int isSenior) {
    super(name, email, dateOfBirth, salary);
    this.isSenior = isSenior;
  }

  public static boolean validTechnician(String technicianName) {
    for (Technician technician : Technician.technicianList) {
      if (technician.getName().equals(technicianName)) {
        return true;
      }
    }
    return false;
  }

  public static void displayAllOrders() {
    for (Technician technician : Technician.technicianList) {
      if (technician.isSenior == 1) {
        for (Order order : Order.orderList) {
          System.out.println(order.toString());
        }
      }
    }
  }

  public static void displayItemInfo(String technicianName, String[] itemTypeList) {
    if (validTechnician(technicianName) == false) {
      System.out.println("No technician person named " + technicianName + " exists!");
      return;
    }

    for (String itemType : itemTypeList) {
      if (itemType.equalsIgnoreCase("Book")) {
        for (Book book : Item.books) {
          System.out.print(book.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equalsIgnoreCase("CDDVD")) {
        for (CDDVD CDDVD : Item.CDDVDs) {
          System.out.print(CDDVD.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equalsIgnoreCase("Desktop")) {
        for (Desktop desktop : Item.desktops) {
          System.out.print(desktop.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equalsIgnoreCase("Laptop")) {
        for (Laptop laptop : Item.laptops) {
          System.out.print(laptop.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equalsIgnoreCase("Tablet")) {
        for (Tablet tablet : Item.tablets) {
          System.out.print(tablet.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equalsIgnoreCase("TV")) {
        for (TV TV : Item.TVs) {
          System.out.print(TV.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equalsIgnoreCase("SmartPhone")) {
        for (SmartPhone smartPhone : Item.smartPhones) {
          System.out.print(smartPhone.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equalsIgnoreCase("HairCare")) {
        for (HairCare hairCare : Item.hairCares) {
          System.out.print(hairCare.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equalsIgnoreCase("Perfume")) {
        for (Perfume perfume : Item.perfumes) {
          System.out.print(perfume.toString());
          System.out.println("-----------------------");
        }
      } else if (itemType.equalsIgnoreCase("SkinCare")) {
        for (SkinCare skinCare : Item.skinCares) {
          System.out.print(skinCare.toString());
          System.out.println("-----------------------");
        }
      }
    }
  }

  public static void displayItems(String technicianName) {
    if (validTechnician(technicianName) == false && Admin.validAdmin(technicianName) == false) {
      System.out.println("No admin or technician person named " + technicianName + " exists!");
      return;
    }

    for (Item item : Item.itemList) {
      switch (item.getClass().getSimpleName()) {
        case "Book":
          Book book = (Book) item;
          System.out.print(book.toString());
          break;
        case "CDDVD":
          CDDVD CDDVD = (CDDVD) item;
          System.out.print(CDDVD.toString());
          break;
        case "Desktop":
          Desktop desktop = (Desktop) item;
          System.out.print(desktop.toString());
          break;
        case "Laptop":
          Laptop laptop = (Laptop) item;
          System.out.print(laptop.toString());
          break;
        case "Tablet":
          Tablet tablet = (Tablet) item;
          System.out.print(tablet.toString());
          break;
        case "TV":
          TV TV = (TV) item;
          System.out.print(TV.toString());
          break;
        case "SmartPhone":
          SmartPhone smartPhone = (SmartPhone) item;
          System.out.print(smartPhone.toString());
          break;
        case "HairCare":
          HairCare hairCare = (HairCare) item;
          System.out.print(hairCare.toString());
          break;
        case "Perfume":
          Perfume perfume = (Perfume) item;
          System.out.print(perfume.toString());
          break;
        case "SkinCare":
          SkinCare skinCare = (SkinCare) item;
          System.out.print(skinCare.toString());
          break;
        default:
          System.out.print("Unknown item type");
          break;
      }
      System.out.println("-----------------------");
    }
  }

  // addToList
  public static void addToList(Technician technician) {
    Technician.technicianList.add(technician);
  }

  public static void showAllOrders(String technicianName) {
    if (validTechnician(technicianName) == false) {
      System.out.println("No technician person named " + technicianName + " exists!");
      return;
    }

    for (Order order : Order.orderList) {
      System.out.print(order.showOrder());
      System.out.println("-----------------------");
    }
  }

  public static void showOrders(String technicianName, String customerName) {
    if (validTechnician(technicianName) == false) {
      System.out.println("No technician person named " + technicianName + " exists!");
      return;
    }

    for (Order order : Order.orderList) {
      if (order.customerName == customerName) {
        System.out.print(order.showOrder());
        System.out.println("-----------------------");
      }
    }
  }

  // Add a new item
  public static void addNewItem(String technicianName, String[] props) {
    if (validTechnician(technicianName) == false && technicianName != "CONSOLE") {
      System.out.println("No technician person named " + technicianName + " exists!");
      return;
    }

    if (props[0].equalsIgnoreCase("BOOK")) {
      // BOOK<TAB>cost<TAB>releaseDate<TAB>coverTitle<TAB>publisherName<TAB>author1<,>author2<,>...<,>authorN<TAB>pageNumber
      System.out.println("[------ ITEM: BOOK ------]");
      // Check if parameters are valid type
      if (props.length != 7) {
        System.out.println("Invalid number of parameters!");
        return;
      }

      String[] authors = props[5].split(",");
      new Book(Float.parseFloat(props[1]), props[2], props[3], props[4], authors, Integer.parseInt(props[6]));
    } else if (props[0].equalsIgnoreCase("CDDVD")) {
      // CDDVD<TAB>cost<TAB>releaseDate<TAB>coverTitle<TAB>composerName<TAB>song1<,>song2<,>...<,>songN
      System.out.println("[------ ITEM: CDDVD ------]");
      if (props.length != 6) {
        System.out.println("Invalid number of parameters!");
        return;
      }

      String[] songs = props[5].split(",");
      new CDDVD(Float.parseFloat(props[1]), props[2], props[3], props[4], songs);
    } else if (props[0].equalsIgnoreCase("DESKTOP")) {
      // DESKTOP<TAB>cost<TAB>manufacturer<TAB>brand<TAB>maxVolt<TAB>maxWatt<TAB>operatingSystem<TAB>CPUType<TAB>ramCapacity<TAB>HDDCapacity<TAB>boxColor
      System.out.println("[------ ITEM: DESKTOP ------]");
      if (props.length != 11) {
        System.out.println("Invalid number of parameters!");
        return;
      }
      new Desktop(Float.parseFloat(props[1]), props[2], props[3], Float.parseFloat(props[4]),
          Float.parseFloat(props[5]),
          props[6], props[7], Integer.parseInt(props[8]), Float.parseFloat(props[9]), props[10]);
    } else if (props[0].equalsIgnoreCase("LAPTOP")) {
      // LAPTOP<TAB>cost<TAB>manufacturer<TAB>brand<TAB>maxVolt<TAB>maxWatt<TAB>operatingSystem<TAB>CPUType<TAB>ramCapacity<TAB>HDDCapacity<TAB>HDMISupport
      System.out.println("[------ ITEM: LAPTOP ------]");
      if (props.length != 11) {
        System.out.println("Invalid number of parameters!");
        return;
      }
      new Laptop(Float.parseFloat(props[1]), props[2], props[3], Float.parseFloat(props[4]),
          Float.parseFloat(props[5]),
          props[6], props[7], Integer.parseInt(props[8]), Float.parseFloat(props[9]), Integer.parseInt(props[10]));
    } else if (props[0].equalsIgnoreCase("TABLET")) {
      // TABLET<TAB>cost<TAB>manufacturer<TAB>brand<TAB>maxVolt<TAB>maxWatt<TAB>operatingSystem<TAB>CPUType<TAB>ramCapacity<TAB>HDDCapacity<TAB>dimension
      System.out.println("[------ ITEM: TABLET ------]");
      if (props.length != 11) {
        System.out.println("Invalid number of parameters!");
        return;
      }
      new Tablet(Float.parseFloat(props[1]), props[2], props[3], Float.parseFloat(props[4]),
          Float.parseFloat(props[5]),
          props[6], props[7], Integer.parseInt(props[8]), Float.parseFloat(props[9]), Float.parseFloat(props[10]));
    } else if (props[0].equalsIgnoreCase("TV")) {
      // TV<TAB>cost<TAB>manufacturer<TAB>brand<TAB>maxVolt<TAB>maxWatt<TAB>screenSize
      System.out.println("[------ ITEM: TV ------]");
      if (props.length != 7) {
        System.out.println("Invalid number of parameters!");
        return;
      }
      new TV(Float.parseFloat(props[1]), props[2], props[3], Float.parseFloat(props[4]), Float.parseFloat(props[5]),
          Float.parseFloat(props[6]));
    } else if (props[0].equalsIgnoreCase("SMARTPHONE")) {
      // SMARTPHONE<TAB>cost<TAB>manufacturer<TAB>brand<TAB>maxVolt<TAB>maxWatt<TAB>screenType
      System.out.println("[------ ITEM: SMARTPHONE ------]");
      if (props.length != 7) {
        System.out.println("Invalid number of parameters!");
        return;
      }
      new SmartPhone(Float.parseFloat(props[1]), props[2], props[3], Float.parseFloat(props[4]),
          Float.parseFloat(props[5]),
          props[6]);
    } else if (props[0].equalsIgnoreCase("HAIRCARE")) {
      // HAIRCARE<TAB>cost<TAB>manufacturer<TAB>brand<TAB>isOrganic<TAB>expirationYear<TAB>weight<TAB>isMedicated
      System.out.println("[------ ITEM: HAIRCARE ------]");
      if (props.length != 8) {
        System.out.println("Invalid number of parameters!");
        return;
      }
      new HairCare(Float.parseFloat(props[1]), props[2], props[3], Integer.parseInt(props[4]), props[5],
          Float.parseFloat(props[6]), Integer.parseInt(props[7]));
    } else if (props[0].equalsIgnoreCase("PERFUME")) {
      // PERFUME<TAB>cost<TAB>manufacturer<TAB>brand<TAB>isOrganic<TAB>expirationYear<TAB>weight<TAB>lastingDuration
      System.out.println("[------ ITEM: PERFUME ------]");
      if (props.length != 8) {
        System.out.println("Invalid number of parameters!");
        return;
      }
      new Perfume(Float.parseFloat(props[1]), props[2], props[3], Integer.parseInt(props[4]), props[5],
          Float.parseFloat(props[6]), Float.parseFloat(props[7]));
    } else if (props[0].equalsIgnoreCase("SKINCARE")) {
      // SKINCARE<TAB>cost<TAB>manufacturer<TAB>brand<TAB>isOrganic<TAB>expirationYear<TAB>weight<TAB>babySensitive
      System.out.println("[------ ITEM: SKINCARE ------]");
      if (props.length != 8) {
        System.out.println("Invalid number of parameters!");
        return;
      }
      new SkinCare(Float.parseFloat(props[1]), props[2], props[3], Integer.parseInt(props[4]), props[5],
          Float.parseFloat(props[6]), Integer.parseInt(props[7]));
    }
  }
}
