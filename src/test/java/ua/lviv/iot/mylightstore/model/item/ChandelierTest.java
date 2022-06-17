package ua.lviv.iot.mylightstore.model.item;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.item.impl.Chandelier;

public class ChandelierTest {

  private static final String NAME = "Matrix";
  private static final String MANUFACTURER = "New ModerLife";
  private static final double PRICE = 120.14;
  private static final double POWER = 300;
  private static final String MATERIAL = "plastic";
  private static final String expected = "name,manufacturer,price,power,category,material";
  private Chandelier chandelier;

  @BeforeEach
  void initChandelier() {
    chandelier = new Chandelier(NAME, MANUFACTURER, PRICE, POWER, MATERIAL);
  }

  @Test
  void basicConstructorsWithGetters() {
    assertThat(chandelier.getMaterial(), equalTo(MATERIAL));
  }

  @Test
  void getHeaders() {
    //given
    // String expected

    //when
    String actual = Chandelier.getHeaders();

    //then
    assertEquals(expected, actual);
  }

  @Test
  void toCSV() {
    //given
    String expected =
        NAME + "," + MANUFACTURER + "," + PRICE + "," + POWER + "," + chandelier.getCategory() + ","
            + MATERIAL;

    //when
    String actual = chandelier.toCsv();

    //then
    assertEquals(expected, actual);
  }
}
