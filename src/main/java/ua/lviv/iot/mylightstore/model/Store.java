package ua.lviv.iot.mylightstore.model;

import ua.lviv.iot.mylightstore.model.item.impl.Item;

import java.util.List;

public record Store(List<Item> items) {

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addItems(List<Item> items) {
        this.items.addAll(items);
    }
}
