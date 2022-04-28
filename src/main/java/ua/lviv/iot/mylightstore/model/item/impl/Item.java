package ua.lviv.iot.mylightstore.model.item.impl;

import java.util.StringJoiner;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.Itemable;

/**
 * My <b>Item class</b>.
 * Item of the all store...
 */
@Getter
@ToString
@EqualsAndHashCode
public class Item implements Itemable {

  private static final String FIELDS_CSV = "name,manufacturer,price,power,"
      + "category";
  private final String name;
  private final String manufacturer;
  private final double price;
  private final double power;
  private final Category category;

  /**
   * Constructor with all parameters...
   *
   * @param newName - name of new item
   */
  public Item(final String newName, final String newManufacturer, final double newPrice,
      final double newPower, final Category newCategory) {
    this.name = newName;
    this.manufacturer = newManufacturer;
    this.price = newPrice;
    this.power = newPower;
    this.category = newCategory;
  }

  public static String getHeaders() {
    return FIELDS_CSV;
  }

  /**
   * Make new field string separated by commas with all available field of item object...
   */
  public String toCsv() {
    StringJoiner stringJoiner = new StringJoiner(",");
    return stringJoiner
        .add(name)
        .add(manufacturer)
        .add(String.valueOf(price))
        .add(String.valueOf(power))
        .add(String.valueOf(category))
        .toString();
  }
}
