package ua.lviv.iot.mylightstore.model.item;

import ua.lviv.iot.mylightstore.model.Category;

/**
 * My <b>Itemable interface</b>.
 * Interface for getters method to class Item...
 */
public interface Itemable {

  String getName();

  String getManufacturer();

  double getPrice();

  double getPower();

  Category getCategory();
}
