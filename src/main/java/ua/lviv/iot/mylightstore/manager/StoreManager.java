package ua.lviv.iot.mylightstore.manager;

import static ua.lviv.iot.mylightstore.model.SortDirection.ASC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.SortDirection;
import ua.lviv.iot.mylightstore.model.Store;
import ua.lviv.iot.mylightstore.model.item.impl.Item;

/**
 * My <b>StoreManager class</b>.
 * Management my store with items...
 */
public class StoreManager {

  private static final String OFFSET = "--";
  private final Store store;

  /**
   * Checks if the store is empty...
   *
   * @param newStore - create new store
   */

  public StoreManager(final Store newStore) {
    if (null == newStore) {
      throw new IllegalArgumentException("null store is not allowed");
    }
    this.store = new Store(newStore.items());
  }

  /**
   * Searches for an item by category...
   *
   * @param category - available categories for an item
   */

  public List<Item> findItemsByCategory(final Category category) {
    List<Category> categories = findAllCategories(category);
    return store.items().stream()
        .filter(item -> categories.contains(item.getCategory()))
        .toList();
  }

  public List<Item> findItemsByCategoryAndSortByPrice(final Category category,
      final SortDirection sortDirection) {
    return sortItemsByPrice(findItemsByCategory(category), sortDirection);
  }

  public List<Item> findItemsByCategoryAndSortByManufacturer(final Category category,
      final SortDirection sortDirection) {
    return sortItemsByManufacturer(findItemsByCategory(category),
        sortDirection);
  }

  public void drawHierarchy() {
    drawCategoryLevel(Category.ROOT, 0);
  }

  private List<Category> findAllCategories(final Category category) {
    return getFlatCategories().get(category);
  }

  private Map<Category, List<Category>> getFlatCategories() {
    Map<Category, List<Category>> mapCategories = new HashMap<>();
    Arrays.stream(Category.values()).forEach(category -> {
      List<Category> categories = new ArrayList<>();
      categories.add(category);
      category.getSubCategories()
          .forEach(subCategory -> categories.addAll(mapCategories.get(subCategory)));
      mapCategories.put(category, categories);
    });

    return mapCategories;
  }

  private List<Item> sortItemsByPrice(final List<Item> items,
      final SortDirection sortDirection) {
    var priceComparator = Comparator.comparing(Item::getPrice);
    return items.stream()
        .sorted(sortDirection == ASC ? priceComparator
            : priceComparator.reversed())
        .toList();
  }

  private List<Item> sortItemsByManufacturer(final List<Item> items,
      final SortDirection sortDirection) {
    var manufacturerComparator =
        Comparator.comparing(Item::getManufacturer);
    return items.stream()
        .sorted(sortDirection == ASC ? manufacturerComparator
            : manufacturerComparator.reversed())
        .toList();
  }

  private void drawCategoryLevel(final Category category, final int level) {
    System.out.println(OFFSET.repeat(level) + "Category: " + category);
    var subCategories = category.getSubCategories();

    int itemLevel = level;
    itemLevel++;
    store.items().stream()
        .filter(item -> category == item.getCategory())
        .forEach(item -> printItem(level, item));

    if (subCategories.isEmpty()) {
      return;
    }

    for (var subCategory : subCategories) {
      drawCategoryLevel(subCategory, itemLevel);
    }
  }

  private void printItem(final int itemLevel, final Item item) {
    System.out.println(OFFSET.repeat(itemLevel) + "Item: "
        + item.getName());
  }
}

