import java.util.ArrayList;
import java.util.List;


public class GildedRose {

  private static final int MAXIMUM_QUALITY = 50;
  private static List<Item> items = null;

  /**
   * @param args
   */
  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    items = new ArrayList<Item>();
    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));

    updateQuality(items);

    System.out.println(items);
  }

  public static void updateQuality(List<Item> items) {
    for (Item item : items) {
      updateItem(item);
    }
  }

  private static void updateItem(Item item) {
    if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
      return;
    }

    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
      updateBackstagePass(item);
    } else {
      if ("Aged Brie".equals(item.getName())) {
        if (item.getQuality() < MAXIMUM_QUALITY) {
          incrementQuality(item);
        }

        decrementSellin(item);

        if (item.getSellIn() < 0) {
          if (item.getQuality() < MAXIMUM_QUALITY) {
            incrementQuality(item);
          }
        }
      } else {
        if (item.getQuality() > 0) {
          item.setQuality(item.getQuality() - 1);
        }

        decrementSellin(item);

        if (item.getSellIn() < 0) {
          if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
          }
        }
      }
    }
  }

  private static void updateBackstagePass(Item item) {
    if (item.getSellIn() < 0) {
      item.setQuality(0);
    } else if (item.getQuality() < MAXIMUM_QUALITY) {
      incrementQuality(item);

      if (item.getSellIn() <= 10) {
        if (item.getQuality() < MAXIMUM_QUALITY) {
          incrementQuality(item);
        }
      }

      if (item.getSellIn() <= 5) {
        if (item.getQuality() < MAXIMUM_QUALITY) {
          incrementQuality(item);
        }
      }
    }

    decrementSellin(item);
  }

  private static void decrementSellin(Item item) {
    item.setSellIn(item.getSellIn() - 1);
  }

  private static void incrementQuality(Item item) {
    item.setQuality(item.getQuality() + 1);
  }

}