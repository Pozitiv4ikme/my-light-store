package ua.lviv.iot.mylightstore.model.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.item.impl.Nightlight;

public class NightlightTest {

  private static final String NAME = "PeaceInUkraine";
  private static final String MANUFACTURER = "Logic";
  private static final double PRICE = 99.99;
  private static final double POWER = 5.4;
  private static final double WIDTH = 1.2;
  private static final double HEIGHT = 2.56;
  private static final double LENGTH = 5.1;
  private static final String expected = "name,manufacturer,price,power,category,width,height,length";
  private Nightlight nightlight;

  @BeforeEach
  void initNightlight() {
    nightlight = new Nightlight(NAME, MANUFACTURER, PRICE, POWER, WIDTH, HEIGHT, LENGTH);
  }

  @Test
  void basicConstructorWithGetters() {
    assertEquals(nightlight.getWidth(), WIDTH);
    assertEquals(nightlight.getHeight(), HEIGHT);
    assertEquals(nightlight.getLength(), LENGTH);
  }

  @Test
  void getHeaders() {
    //given
    //String expected

    //when
    String actual = Nightlight.getHeaders();

    //then
    assertEquals(expected, actual);
  }

  @Test
  void toCSV() {
    //given
    String expected =
        NAME + "," + MANUFACTURER + "," + PRICE + "," + POWER + "," + nightlight.getCategory() + ","
            + WIDTH + "," + HEIGHT + "," + LENGTH;

    //when
    String actual = nightlight.toCsv();

    //then
    assertEquals(expected, actual);
  }
}
