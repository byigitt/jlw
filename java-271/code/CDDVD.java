public class CDDVD extends OfficeSupplies {
  public String composer;
  public String[] songs;

  public static int stock = 0;

  public CDDVD(float price, String coverTitle, String releaseDate, String composer, String[] songs) {
    super(coverTitle, releaseDate, price);
    this.songs = songs;
    this.composer = composer;
    stock++;

    Item.addToList(this);
  }

  @Override
  public String toString() {
    String songsString = "";
    for (String song : songs) {
      songsString += song + ", ";
    }
    songsString = songsString.substring(0, songsString.length() - 2);

    return "ID: " + this.id + "\n" + "Type: CD/DVD" + "\n" + "Title: " + this.coverTitle + "\n" + "Price: " + this.price
        + "\n" + "Release Date: " + this.releaseDate + "\n" + "Composer: " + this.composer + "\n" + "Songs: "
        + songsString + "\n";
  }
}