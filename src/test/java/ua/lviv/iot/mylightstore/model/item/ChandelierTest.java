package ua.lviv.iot.mylightstore.model.item;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.item.impl.Chandelier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ChandelierTest {
    private static final String NAME = "Matrix";
    private static final String MANUFACTURER = "New ModerLife";
    private static final double PRICE = 120.14;
    private static final double POWER = 300;
    private static final String MATERIAL = "plastic";

    @Test
    void basicConstructorsWithGetters(){
        Chandelier chandelier = new Chandelier(NAME, MANUFACTURER, PRICE, POWER, MATERIAL);

        assertThat(chandelier.getMaterial(), equalTo(MATERIAL));
    }
}
