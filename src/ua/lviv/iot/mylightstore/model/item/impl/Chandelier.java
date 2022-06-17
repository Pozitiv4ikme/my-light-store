package ua.lviv.iot.mylightstore.model.item.impl;

import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.Chandelierable;

public class Chandelier extends Item implements Chandelierable {
    private final String material;

    public Chandelier(String name, String manufacture, double price, double power, Category category, String material) {
        super(name, manufacture, price, power, category);
        this.material = material;
        super.setCategory(Category.CHANDELIER);
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public void setCategory(Category category) {
        throw new IllegalArgumentException("you choose another category");
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
