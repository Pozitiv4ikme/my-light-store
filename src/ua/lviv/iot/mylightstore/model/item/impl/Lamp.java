package ua.lviv.iot.mylightstore.model.item.impl;

import ua.lviv.iot.mylightstore.exception.CategoryModifyException;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.Lampable;

public class Lamp extends Item implements Lampable {
    private final String color;

    public Lamp(String name, String manufacture, double price, double power, Category category, String color) {
        super(name, manufacture, price, power, category);
        this.color = color;
        super.setCategory(Category.LAMP);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void setCategory(Category category) {
        throw new CategoryModifyException("you cannot modify category for Lamp");
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
