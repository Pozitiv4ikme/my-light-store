package ua.lviv.iot.mylightstore.model.item.impl;

import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.Chandelierable;

public class Chandelier extends Item implements Chandelierable {
    private final String material;

    public Chandelier(String name, String manufacture, double price, double power, String material) {
        super(name, manufacture, price, power, Category.CHANDELIER);
        this.material = material;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Chandelier{"
                + "name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", price=" + getPrice() +
                ", power=" + getPower() +
                ", category=" + getCategory() +
                ", material='" + material + '\'' +
                '}';
    }
}
