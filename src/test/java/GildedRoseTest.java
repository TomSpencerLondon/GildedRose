import static org.approvaltests.Approvals.verifyAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class GildedRoseTest {

	@Test
	public void acceptanceTest() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
		items.add(new Item("Elixir of the Mongoose", 1, -1));
		List<String> result = new ArrayList<>();
		GildedRose.updateQuality(items);
		for (Item item : items) {
			result.add(String.format("Name: %s, SellIn: %d, Quality: %d",
					item.getName(),
					item.getSellIn(),
					item.getQuality()));
		}

		verifyAll("", result);
	}
}
