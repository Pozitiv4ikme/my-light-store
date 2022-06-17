package ua.lviv.iot.mylightstore.model.item;

import ua.lviv.iot.mylightstore.model.Category;

public interface Itemable {
    String getName();

    String getManufacturer();

    double getPrice();

    double getPower();

    Category getCategory();
}
