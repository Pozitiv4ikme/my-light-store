package ua.lviv.iot.mylightstore.model.item.impl;

import java.util.StringJoiner;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.Nightlightable;

/**
 * My <b>Nightlight class</b>.
 * Class for a particular type of store item - nightlight...
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Nightlight extends Item implements Nightlightable {

  private static final String FIELDS_CSV = ",width,height,length";
  private final double width;
  private final double height;
  private final double length;

  /**
   * Constructor with all parameters...
   *
   * @param name - name of item
   */
  public Nightlight(final String name, final String manufacture,
      final double price,
      final double power,
      final double newWidth,
      final double newHeight, final double newLength) {
    super(name, manufacture, price, power, Category.NIGHTLIGHT);
    this.height = newHeight;
    this.length = newLength;
    this.width = newWidth;
  }

  public static String getHeaders() {
    return Item.getHeaders() + FIELDS_CSV;
  }

  @Override
  public String toCsv() {
    StringJoiner stringJoiner = new StringJoiner(",");
    return stringJoiner
        .add(super.toCsv())
        .add(String.valueOf(width))
        .add(String.valueOf(height))
        .add(String.valueOf(length))
        .toString();
  }
}
