package ua.lviv.iot.mylightstore.model.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.item.impl.Item;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    private static final String NAME = "Black Perl";
    private static final String MANUFACTURER = "SeaLife";
    private static final double PRICE = 89.79;
    private static final double POWER = 220;
    private static final Category CATEGORY = Category.CEILING;

    private Item item;

    @BeforeEach
    void setup() {
        item = new Item(NAME, MANUFACTURER, PRICE, POWER, CATEGORY);
    }

    @Test
    void basicConstructorWithGetters(){
        assertEquals(item.getName(), NAME);
        assertEquals(item.getManufacturer(), MANUFACTURER);
        assertEquals(item.getPrice(), PRICE);
        assertEquals(item.getPower(), POWER);
        assertEquals(item.getCategory(), CATEGORY);
    }

//    @Test
//    void testToString() {
//        assertEquals(item.toString(), "Item{name='Black Perl', manufacturer='SeaLife', price=89.79, power=220.0, category=CEILING}");
//    }

//    @Test
//    void testEquals() {
//        Item otherItem = new Item(NAME, MANUFACTURER, PRICE, POWER, CATEGORY);
//        assertEquals(item, otherItem);
//
//        Item modifiedItem = new Item(NAME, MANUFACTURER + "_", PRICE+1, POWER, CATEGORY);
//        assertNotEquals(item, mo);
//    }
}
