package ua.lviv.iot.mylightstore;

import ua.lviv.iot.mylightstore.manager.StoreManager;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.Store;
import ua.lviv.iot.mylightstore.model.item.impl.Chandelier;
import ua.lviv.iot.mylightstore.model.item.impl.Item;
import ua.lviv.iot.mylightstore.model.item.impl.Lamp;
import ua.lviv.iot.mylightstore.model.item.impl.Nightlight;

import java.util.ArrayList;
import java.util.List;

import static ua.lviv.iot.mylightstore.model.SortDirection.ASC;
import static ua.lviv.iot.mylightstore.model.SortDirection.DESC;

public class StoreWarehouse {
    public static void main(String[] args) {
        StoreWarehouse storeWarehouse = new StoreWarehouse();
        storeWarehouse.presentSore();
    }

    private void presentSore() {
        Store store = new Store(new ArrayList<>());
        StoreManager storeManager = new StoreManager(store);

        System.out.println("-----Start store presentation-----");

        System.out.println("-----Add one item to store-----");
        store.addItem(new Item("Starry sky", "SmartHouse", 120.99, 20, Category.CEILING));

        System.out.println("-----Add basic items to store-----");
        store.addItems(generateItems());

        System.out.println("-----Add lamps to store-----");
        store.addItems(generateLamps());

        System.out.println("-----Add chandeliers to store-----");
        store.addItems(generateChandeliers());

        System.out.println("-----Add nightlights to store-----");
        store.addItems(generateNightlights());

        System.out.println("-----All items added-----");

        System.out.println("\n-----Show store hierarchy-----");
        storeManager.drawHierarchy();

        var lampCategory = Category.LAMP;
        System.out.printf("\n-----Let's find items by category: %s-----\n", lampCategory);
        var foundItems = storeManager.findItemsByCategory(lampCategory);
        System.out.printf("-----Found items by category: %s-----\n", lampCategory);
        foundItems.forEach(System.out::println);
        System.out.println("-----\n");

        var ceilingCategory = Category.CEILING;
        var ceilingSortDirection = ASC;
        System.out.printf("\n-----Let's find items by category: %s and sort by price: %s -----\n", ceilingCategory, ceilingSortDirection);
        List<Item> foundItemsAndSortByPrice = storeManager.findItemsByCategoryAndSortByPrice(ceilingCategory, ceilingSortDirection);
        System.out.printf("-----Found items by category: %s and sorted by price: %s-----\n", ceilingCategory, ceilingSortDirection);
        foundItemsAndSortByPrice.forEach(System.out::println);
        System.out.println("-----\n");

        var tableCategory = Category.TABLE;
        var tableSortDirection = DESC;
        System.out.printf("\n-----Let's find items by category: %s and sort by manufacturer: %s-----\n", tableCategory, tableSortDirection);
        List<Item> fouItemsAndSortByManufacturer = storeManager.findItemsByCategoryAndSortByManufacturer(tableCategory, tableSortDirection);
        System.out.printf("-----Found items by category: %s and sorted by manufacturer: %s-----\n", tableCategory, tableSortDirection);
        fouItemsAndSortByManufacturer.forEach(System.out::println);
        System.out.println("-----\n");

    }

    private List<Item> generateChandeliers() {
        return List.of(
                new Chandelier("Waterfall", "KitchenMade", 43.15, 220, "plastic")
        );
    }

    private List<Item> generateLamps() {
        return List.of(
                new Lamp("Old tree", "Label", 4.49, 2.5, "red")
        );
    }

    private List<Item> generateItems() {
        return List.of(
                new Item("Rose bush", "SmartHouse", 120.99, 20, Category.CEILING),
                new Item("Swan", "NewTime", 250.49, 50, Category.CEILING),
                new Item("Monochrome", "YourHelper", 38.90, 9, Category.CEILING),
                new Item("Ice sphere", "FlexCo", 20.99, 3.0, Category.FLOOR),
                new Item("Modern cube", "HandMade", 15.35, 220, Category.TABLE)
        );
    }

    private List<Item> generateNightlights() {
        return List.of(
                new Nightlight("Ladybug", "KidsHappier", 70.49, 3.8, 3.8, 7, 15),
                new Nightlight("Elephant", "FoundTrue", 10.25, 1.5, 1.5, 3, 5),
                new Nightlight("Bunny", "MakeFuture", 18.78, 2.5, 2.64, 1.25, 4.6)
        );
    }
}
