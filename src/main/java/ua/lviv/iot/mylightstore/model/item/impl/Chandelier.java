package ua.lviv.iot.mylightstore.model.item.impl;

import java.util.StringJoiner;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.Chandelierable;

/**
 * My <b>Chandelier class</b>.
 * Class for a particular type of store item - chandeliers...
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Chandelier extends Item implements Chandelierable {

  private static final String FIELDS_CSV = ",material";
  private final String material;

  public Chandelier(final String name, final String manufacture,
      final double price,
      final double power, final String newMaterial) {
    super(name, manufacture, price, power, Category.CHANDELIER);
    this.material = newMaterial;
  }

  public static String getHeaders() {
    return Item.getHeaders() + FIELDS_CSV;
  }

  @Override
  public String toCsv() {
    StringJoiner stringJoiner = new StringJoiner(",");
    return stringJoiner
        .add(super.toCsv())
        .add(material)
        .toString();
  }
}
