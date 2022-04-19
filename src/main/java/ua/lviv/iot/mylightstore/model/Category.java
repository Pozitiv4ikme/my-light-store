package ua.lviv.iot.mylightstore.model;

import java.util.List;

public enum Category {
    CHANDELIER,
    FLOOR,
    NIGHTLIGHT,
    LAMP,
    CEILING(List.of(CHANDELIER)),
    TABLE(List.of(LAMP, NIGHTLIGHT)),
    ROOT(List.of(CEILING, TABLE, FLOOR));

    private final List<Category> subCategories;

    Category(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    Category() {
        this.subCategories = List.of();
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }
}
