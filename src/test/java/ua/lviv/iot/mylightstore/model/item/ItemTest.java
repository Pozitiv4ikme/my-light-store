package ua.lviv.iot.mylightstore.model.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.impl.Item;

public class ItemTest {

  private static final String NAME = "Black Perl";
  private static final String MANUFACTURER = "SeaLife";
  private static final double PRICE = 89.79;
  private static final double POWER = 220;
  private static final Category CATEGORY = Category.CEILING;
  private static final String expected = "name,manufacturer,price,power,category";

  private Item item;

  @BeforeEach
  void setup() {
    item = new Item(NAME, MANUFACTURER, PRICE, POWER, CATEGORY);
  }

  @Test
  void basicConstructorWithGetters() {
    assertEquals(item.getName(), NAME);
    assertEquals(item.getManufacturer(), MANUFACTURER);
    assertEquals(item.getPrice(), PRICE);
    assertEquals(item.getPower(), POWER);
    assertEquals(item.getCategory(), CATEGORY);
  }

  @Test
  void getHeaders() {
    //given
    // String expected;

    //when
    String actual = Item.getHeaders();

    //then
    assertEquals(expected, actual);
  }

  @Test
  void toCSV() {
    //given
    String expected = NAME + "," + MANUFACTURER + "," + PRICE + "," + POWER + "," + CATEGORY;

    //when
    String actual = item.toCsv();

    //then
    assertEquals(expected, actual);
  }
}
