package ua.lviv.iot.mylightstore.model.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.item.impl.Lamp;

public class LampTest {

  private static final String NAME = "PeaceInUkraine";
  private static final String MANUFACTURER = "Logic";
  private static final double PRICE = 99.99;
  private static final double POWER = 5.4;
  private static final String COLOR = "blue-yellow";
  private static final String expected = "name,manufacturer,price,power,category,color";
  private Lamp lamp;

  @BeforeEach
  void initLamp() {
    lamp = new Lamp(NAME, MANUFACTURER, PRICE, POWER, COLOR);
  }

  @Test
  void basicConstructorWithGetters() {
    assertEquals(lamp.getColor(), COLOR);
  }

  @Test
  void getHeaders() {
    //given
    //String expected

    //when
    String actual = Lamp.getHeaders();

    //then
    assertEquals(expected, actual);
  }

  @Test
  void toCSV() {
    //given
    String expected =
        NAME + "," + MANUFACTURER + "," + PRICE + "," + POWER + "," + lamp.getCategory() + ","
            + COLOR;

    //when
    String actual = lamp.toCsv();

    //then
    assertEquals(expected, actual);
  }
}
