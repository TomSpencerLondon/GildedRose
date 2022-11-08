import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ConjuredItemTest {

  @Test
  void givenUpdateDecrementsQualityByTwoAndDecrementsSellinByOne() {
    Item conjured = new Item("Conjured", 2, 4);

    GildedRose.updateConjured(conjured);

    assertThat(conjured.getSellIn())
        .isEqualTo(1);
    assertThat(conjured.getQuality())
        .isEqualTo(2);
  }

  @Test
  void givenSellinUnderZeroUpdateDecrementsQualityByFourAndDecrementsSellinByOne() {
    Item conjured = new Item("Conjured", -1, 8);

    GildedRose.updateConjured(conjured);

    assertThat(conjured.getSellIn())
        .isEqualTo(-2);
    assertThat(conjured.getQuality())
        .isEqualTo(4);
  }
}
