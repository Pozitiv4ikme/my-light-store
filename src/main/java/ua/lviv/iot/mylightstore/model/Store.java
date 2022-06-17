package ua.lviv.iot.mylightstore.model;

import java.util.ArrayList;
import java.util.List;
import ua.lviv.iot.mylightstore.model.item.impl.Item;

/**
 * My <b>Store record class</b>.
 * Store of items. Can add item|items...
 */
public record Store(List<Item> items) {

  public Store(final List<Item> items) {
    this.items = new ArrayList<>(items);
  }

  public List<Item> items() {
    return List.copyOf(items);
  }

  /**
   * Add item into my store...
   *
   * @param item - the item of the available options
   */
  public void addItem(final Item item) {
    this.items.add(item);
  }

  public void addItems(final List<Item> newItems) {
    this.items.addAll(newItems);
  }
}
