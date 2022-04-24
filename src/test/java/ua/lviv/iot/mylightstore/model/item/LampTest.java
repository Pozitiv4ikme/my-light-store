package ua.lviv.iot.mylightstore.model.item;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.item.impl.Lamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LampTest {
    private static final String NAME = "PeaceInUkraine";
    private static final String MANUFACTURER = "Logic";
    private static final double PRICE = 99.99;
    private static final double POWER = 5.4;
    private static final String COLOR = "blue-yellow";

    @Test
    void basicConstructorWithGetters() {
        Lamp lamp = new Lamp(NAME, MANUFACTURER, PRICE, POWER, COLOR);

        assertEquals(lamp.getColor(), COLOR);
    }
}
