package ua.lviv.iot.mylightstore;

import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.impl.Chandelier;
import ua.lviv.iot.mylightstore.model.item.impl.Item;
import ua.lviv.iot.mylightstore.model.item.impl.Lamp;
import ua.lviv.iot.mylightstore.model.Store;
import ua.lviv.iot.mylightstore.model.item.impl.Nightlight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Store.showCategoryHierarchy();
        var store = new Store(createItems());
        store.showItems();
    }

    private static List<Item> createItems() {
        Item item = new Item("test1", "FlexCo", 20.99, 3.0, Category.FLOOR);
        Item item1 = new Item("test2", "HandMade", 15.35, 220, Category.TABLE);
        Item item2 = new Item("test3", "SmartHouse", 120.99, 20, Category.CEILING);
        Lamp lamp = new Lamp("test4", "Label", 4.49, 2.5, Category.LAMP, "red");
        Nightlight nightlight = new Nightlight("test5", "KidsFuture", 10.25, 1.5, Category.NIGHTLIGHT, 1.5, 3, 5);
        Chandelier chandelier = new Chandelier("test6", "KitchenMade", 43.15, 220, Category.CHANDELIER, "plastic");
        return List.of(item, item1, item2, lamp, nightlight, chandelier);
    }

}
