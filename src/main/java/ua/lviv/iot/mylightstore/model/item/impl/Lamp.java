package ua.lviv.iot.mylightstore.model.item.impl;

import java.util.StringJoiner;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.Lampable;

/**
 * My <b>Lamp class</b>.
 * Class for a particular type of store item - lamp...
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Lamp extends Item implements Lampable {

  private static final String FIELDS_CSV = ",color";
  private final String color;

  public Lamp(final String name, final String manufacture, final double price,
      final double power,
      final String newColor) {
    super(name, manufacture, price, power, Category.LAMP);
    this.color = newColor;
  }

  public static String getHeaders() {
    return Item.getHeaders() + FIELDS_CSV;
  }

  @Override
  public String toCsv() {
    StringJoiner stringJoiner = new StringJoiner(",");
    return stringJoiner
        .add(super.toCsv())
        .add(color)
        .toString();
  }
}
