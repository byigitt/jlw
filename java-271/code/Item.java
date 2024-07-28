import java.util.ArrayList;

public class Item {
  private static int customID = 0;

  public int id;
  public float price;

  static ArrayList<TV> TVs = new ArrayList<TV>();
  static ArrayList<Book> books = new ArrayList<Book>();
  static ArrayList<CDDVD> CDDVDs = new ArrayList<CDDVD>();
  static ArrayList<Laptop> laptops = new ArrayList<Laptop>();
  static ArrayList<Tablet> tablets = new ArrayList<Tablet>();
  static ArrayList<Desktop> desktops = new ArrayList<Desktop>();
  static ArrayList<Perfume> perfumes = new ArrayList<Perfume>();
  static ArrayList<HairCare> hairCares = new ArrayList<HairCare>();
  static ArrayList<SkinCare> skinCares = new ArrayList<SkinCare>();
  static ArrayList<SmartPhone> smartPhones = new ArrayList<SmartPhone>();

  static ArrayList<Item> itemList = new ArrayList<Item>();

  public Item(float price) {
    this.id = customID++;
    this.price = price;
  }

  public static void addToList(Item item) {
    itemList.add(item);

    switch (item.getClass().getSimpleName()) {
      case "Book":
        books.add((Book) item);
        break;
      case "CDDVD":
        CDDVDs.add((CDDVD) item);
        break;
      case "Desktop":
        desktops.add((Desktop) item);
        break;
      case "Laptop":
        laptops.add((Laptop) item);
        break;
      case "Tablet":
        tablets.add((Tablet) item);
        break;
      case "TV":
        TVs.add((TV) item);
        break;
      case "SmartPhone":
        smartPhones.add((SmartPhone) item);
        break;
      case "HairCare":
        hairCares.add((HairCare) item);
        break;
      case "Perfume":
        perfumes.add((Perfume) item);
        break;
      case "SkinCare":
        skinCares.add((SkinCare) item);
        break;
    }
  }

  // getItem()
  // Returns the item with the given ID.
  public static Item getItem(int itemID) {
    for (Item item : Item.itemList) {
      if (item.id == itemID) {
        return item;
      }
    }
    return null;
  }

  // deleteFromLists()
  // Deletes the item with the given ID from all lists.
  public static void deleteFromLists(int itemID) {
    for (Item item : Item.itemList) {
      if (item.id == itemID) {
        switch (item.getClass().getSimpleName()) {
          case "Book":
            books.remove((Book) item);
            break;
          case "CDDVD":
            CDDVDs.remove((CDDVD) item);
            break;
          case "Desktop":
            desktops.remove((Desktop) item);
            break;
          case "Laptop":
            laptops.remove((Laptop) item);
            break;
          case "Tablet":
            tablets.remove((Tablet) item);
            break;
          case "TV":
            TVs.remove((TV) item);
            break;
          case "SmartPhone":
            smartPhones.remove((SmartPhone) item);
            break;
          case "HairCare":
            hairCares.remove((HairCare) item);
            break;
          case "Perfume":
            perfumes.remove((Perfume) item);
            break;
          case "SkinCare":
            skinCares.remove((SkinCare) item);
            break;
        }

        itemList.remove(item);
        return;
      }
    }
  }
}
