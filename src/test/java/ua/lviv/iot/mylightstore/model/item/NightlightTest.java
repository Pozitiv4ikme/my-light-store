package ua.lviv.iot.mylightstore.model.item;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.item.impl.Nightlight;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NightlightTest {
    private static final String NAME = "PeaceInUkraine";
    private static final String MANUFACTURER = "Logic";
    private static final double PRICE = 99.99;
    private static final double POWER = 5.4;
    private static final double WIDTH = 1.2;
    private static final double HEIGHT = 2.56;
    private static final double LENGTH = 5.1;

    @Test
    void basicConstructorWithGetters() {
        Nightlight nightlight = new Nightlight(NAME, MANUFACTURER, PRICE, POWER, WIDTH, HEIGHT, LENGTH);

        assertEquals(nightlight.getWidth(), WIDTH);
        assertEquals(nightlight.getHeight(), HEIGHT);
        assertEquals(nightlight.getLength(), LENGTH);
    }
}
