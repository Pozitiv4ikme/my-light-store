package ua.lviv.iot.mylightstore.model.item.impl;

import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.Itemable;

public class Item implements Itemable {
    private final String name;
    private final String manufacturer;
    private final double price;
    private final double power;
    private final Category category;

    public Item(String name, String manufacturer, double price, double power, Category category) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.power = power;
        this.category = category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getPower() {
        return power;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", power=" + power +
                ", category=" + category +
                '}';
    }
}