import java.util.ArrayList;

public class Campaign {
  public String startDate;
  public String endDate;
  public String itemType;
  public float discountRate;

  static ArrayList<Campaign> campaignList = new ArrayList<Campaign>();

  public Campaign(String startDate, String endDate, String itemType, float discountRate) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.itemType = itemType;
    this.discountRate = discountRate;
  }

  public static void displayCampaigns() {
    for (Campaign campaign : Campaign.campaignList) {
      System.out.println(campaign.toString());
    }
  }

  public static void addToList(Campaign campaign) {
    campaignList.add(campaign);
  }

  public String toString() {
    return (int) (discountRate) + "% sale of " + itemType + " until " + endDate;
  }
}
