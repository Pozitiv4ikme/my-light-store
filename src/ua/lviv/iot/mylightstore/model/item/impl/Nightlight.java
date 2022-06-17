package ua.lviv.iot.mylightstore.model.item.impl;

import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.Nightlightable;

public class Nightlight extends Item implements Nightlightable {
    private final double width;
    private final double height;
    private final double length;

    public Nightlight(String name, String manufacture, double price, double power, Category category,
                      double width, double height, double length) {
        super(name, manufacture, price, power, category);
        this.height = height;
        this.length = length;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public void setCategory(Category category) {
        throw new IllegalArgumentException("you choose another category");
    }

    @Override
    public String toString() {
        return "Nightlight{" +
                "name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", price=" + getPrice() +
                ", power=" + getPower() +
                ", category=" + getCategory() +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}
