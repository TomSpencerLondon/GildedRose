import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ConjuredItemTest {

  @Test
  void givenOneUpdateQualityDecrementsByTwoSellinByOne() {
    Item conjured = new Item("Conjured", 2, 4);

    GildedRose.updateConjured(conjured);

    assertThat(conjured.getSellIn())
        .isEqualTo(1);
    assertThat(conjured.getQuality())
        .isEqualTo(2);
  }
}
