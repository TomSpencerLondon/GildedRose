import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.approvaltests.Approvals.verifyAll;

class GildedRoseTest {

    @Test
    void acceptanceTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        items.add(new Item("Elixir of the Mongoose", 1, -1));
        items.add(new Item("Aged Brie", 1, 51));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47));
        items.add(new Item("+5 Dexterity Vest", -1, 1));
        items.add(new Item("+5 Dexterity Vest", -1, 3));
        items.add(new Item("Aged Brie", -1, 3));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 3));
        items.add(new Item("Sulfuras, Hand of Ragnaros", -1, 3));
        items.add(new Item("Aged Brie", -1, 51));

        GildedRose.updateQuality(items);

        verifyAll("Items", items, item -> String.format("Name: %s, SellIn: %d, Quality: %d",
                item.getName(), item.getSellIn(), item.getQuality()));
    }
}
