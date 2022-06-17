package ua.lviv.iot.mylightstore.model;

import ua.lviv.iot.mylightstore.model.item.impl.Item;

import java.util.List;

public record Store(List<Item> items) {

    public static void showCategoryHierarchy() {
        System.out.println("---Category hierarchy----");
        Category.draw(Category.ROOT, 0);
        System.out.println("-----\n");
    }

    public void showItems() {
        System.out.println("----Store items-----");
        items().forEach(System.out::println);
        System.out.println("-----\n");
    }
}
