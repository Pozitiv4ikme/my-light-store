package ua.lviv.iot.mylightstore.model;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.item.impl.Item;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class StoreTest {

    private Store store;

    @BeforeEach
    void setup() {
        store = new Store(new ArrayList<>());
    }

    @Test
    void testAddItem() {
        // given
        Item item = new Item("Starry sky", "SmartHouse", 120.99, 20, Category.CEILING);

        // when
        store.addItem(item);

        // then
        assertIterableEquals(store.items(), List.of(item));
    }

    @Test
    void testAddItems() {
        // given
        Item item1 = new Item("Starry sky", "SmartHouse", 120.99, 20, Category.CEILING);
        Item item2 = new Item("Ice sphere", "FlexCo", 20.99, 3.0, Category.FLOOR);
        Item item3 = new Item("Modern cube", "HandMade", 15.35, 220, Category.TABLE);

        // when
        store.addItems(List.of(item1, item2, item3));

        // then
        assertThat(store.items(), hasItems(item1, item2, item3));
    }
}
