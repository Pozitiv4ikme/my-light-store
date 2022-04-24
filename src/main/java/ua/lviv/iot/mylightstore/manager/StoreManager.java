package ua.lviv.iot.mylightstore.manager;

import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.SortDirection;
import ua.lviv.iot.mylightstore.model.Store;
import ua.lviv.iot.mylightstore.model.item.impl.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.lviv.iot.mylightstore.model.SortDirection.ASC;

public class StoreManager {
    private static final String OFFSET = "--";
    private final Store store;

    public StoreManager(Store store) {
        if (null == store) {
            throw new IllegalArgumentException("null store is not allowed");
        }
        this.store = store;
    }

    public List<Item> findItemsByCategory(Category category) {
        List<Category> categories = findAllCategories(category);
        return store.items().stream()
                .filter(item -> categories.contains(item.getCategory())).toList();
    }

    public List<Item> findItemsByCategoryAndSortByPrice(Category category, SortDirection sortDirection) {
        return sortItemsByPrice(findItemsByCategory(category), sortDirection);
    }

    public List<Item> findItemsByCategoryAndSortByManufacturer(Category category, SortDirection sortDirection) {
        return sortItemsByManufacturer(findItemsByCategory(category), sortDirection);
    }

    public void drawHierarchy() {
        drawCategoryLevel(Category.ROOT, 0);
    }

    private List<Category> findAllCategories(Category category) {
        return getFlatCategories().get(category);
    }

    private Map<Category, List<Category>> getFlatCategories() {
        Map<Category, List<Category>> mapCategories = new HashMap<>();
        Arrays.stream(Category.values())
                .forEach(category -> {
                    List<Category> categories = new ArrayList<>();
                    categories.add(category);
                    category.getSubCategories()
                            .forEach(subCategory -> categories.addAll(mapCategories.get(subCategory)));
                    mapCategories.put(category, categories);
                });

        return mapCategories;
    }

    private List<Item> sortItemsByPrice(List<Item> items, SortDirection sortDirection) {
        var priceComparator = Comparator.comparing(Item::getPrice);
        return items.stream()
                .sorted(sortDirection == ASC ? priceComparator : priceComparator.reversed())
                .toList();
    }

    private List<Item> sortItemsByManufacturer(List<Item> items, SortDirection sortDirection) {
        var manufacturerComparator = Comparator.comparing(Item::getManufacturer);
        return items.stream()
                .sorted(sortDirection == ASC ? manufacturerComparator : manufacturerComparator.reversed())
                .toList();
    }

    private void drawCategoryLevel(Category category, int level) {
        System.out.println(OFFSET.repeat(level) + "Category: " + category);
        var subCategories = category.getSubCategories();

        level++;
        int itemLevel = level;
        store.items().stream()
                .filter(item -> category == item.getCategory())
                .forEach(item -> System.out.println(OFFSET.repeat(itemLevel) + "Item: " + item.getName()));

        if (subCategories.isEmpty()) {
            return;
        }

        for (var subCategory : subCategories) {
            drawCategoryLevel(subCategory, level);
        }
    }
}

