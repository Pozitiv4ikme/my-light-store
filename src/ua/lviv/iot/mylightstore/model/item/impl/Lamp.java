package ua.lviv.iot.mylightstore.model.item.impl;

import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.Lampable;

public class Lamp extends Item implements Lampable {
    private final String color;

    public Lamp(String name, String manufacture, double price, double power, String color) {
        super(name, manufacture, price, power, Category.LAMP);
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "Lamp{" +
                "name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", price=" + getPrice() +
                ", power=" + getPower() +
                ", category=" + getCategory() +
                ", color='" + color + '\'' +
                '}';
    }
}
