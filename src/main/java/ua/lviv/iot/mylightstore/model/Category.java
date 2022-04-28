package ua.lviv.iot.mylightstore.model;

import java.util.List;

/**
 * My <b>Category enum</b>.
 * List all available categories...
 */
public enum Category {
  CHANDELIER,
  FLOOR,
  NIGHTLIGHT,
  LAMP,
  CEILING(List.of(CHANDELIER)),
  TABLE(List.of(LAMP, NIGHTLIGHT)),
  ROOT(List.of(CEILING, TABLE, FLOOR));

  private final List<Category> subCategories;

  Category(final List<Category> newSubCategories) {
    this.subCategories = newSubCategories;
  }

  Category() {
    this.subCategories = List.of();
  }

  public List<Category> getSubCategories() {
    return List.copyOf(subCategories);
  }
}
