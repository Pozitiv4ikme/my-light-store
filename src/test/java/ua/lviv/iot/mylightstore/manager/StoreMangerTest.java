package ua.lviv.iot.mylightstore.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.SortDirection;
import ua.lviv.iot.mylightstore.model.Store;
import ua.lviv.iot.mylightstore.model.item.impl.Chandelier;
import ua.lviv.iot.mylightstore.model.item.impl.Item;
import ua.lviv.iot.mylightstore.model.item.impl.Lamp;
import ua.lviv.iot.mylightstore.model.item.impl.Nightlight;

public class StoreMangerTest {

  private static final Item CELLING = new Item("Test1", "TestManufacturerCelling", 10.4, 3,
      Category.CEILING);
  private static final Item TABLE = new Item("Test2", "TestManufacturerTable", 4.3, 5,
      Category.TABLE);
  private static final Item FLOOR = new Item("Test3", "TestManufacturerFloor", 6.2, 2.4,
      Category.FLOOR);
  private static final Lamp LAMP = new Lamp("Test4", "TestManufacturerLamp", 9.1, 10, "red");
  private static final Nightlight NIGHTLIGHT = new Nightlight("Test5", "TestManufacturerNightlight",
      100.123, 220, 2.2, 1.2, 5.78);
  private static final Chandelier CHANDELIER = new Chandelier("Test6", "TestManufacturerChandelier",
      120.23, 280, "plastic");

  private StoreManager storeManager;

  @BeforeEach
  void setup() {
    storeManager = new StoreManager(
        new Store(List.of(CELLING, TABLE, FLOOR, LAMP, NIGHTLIGHT, CHANDELIER)));
  }

  @Test
  void nullConstructorTest() {
    assertThrows(IllegalArgumentException.class, () -> new StoreManager(null));
  }

  @Test
  void findItemsBySimpleCategoryTest() {
    //given
    Category requiredCategory = Category.LAMP;

    List<Item> expectedItems = List.of(LAMP);

    //when
    List<Item> receivedItems = storeManager.findItemsByCategory(requiredCategory);

    //then
    assertIterableEquals(receivedItems, expectedItems);
  }

  @Test
  void findItemsByCategoryWithHierarchyTest() {
    //given
    Category requiredCategory = Category.TABLE;

    List<Item> expectedItems = List.of(TABLE, LAMP, NIGHTLIGHT);

    //when
    List<Item> receivedItems = storeManager.findItemsByCategory(requiredCategory);

    //then
    assertIterableEquals(receivedItems, expectedItems);
  }

  @Test
  void findItemsByCategoryAndSortAscByPriceTest() {
    //given
    Category requiredCategory = Category.CEILING;

    List<Item> expectedItems = List.of(CELLING, CHANDELIER);

    //when
    List<Item> receivedItems = storeManager.findItemsByCategoryAndSortByPrice(requiredCategory,
        SortDirection.ASC);

    //then
    assertEquals(receivedItems, expectedItems);
  }

  @Test
  void findItemsByCategoryAndSortDescByPriceTest() {
    //given
    Category requiredCategory = Category.CEILING;

    List<Item> expectedItems = List.of(CHANDELIER, CELLING);

    //when
    List<Item> receivedItems = storeManager.findItemsByCategoryAndSortByPrice(requiredCategory,
        SortDirection.DESC);

    //then
    assertEquals(receivedItems, expectedItems);
  }

  @Test
  void findItemsByCategoryAndSortAscByManufacturerTest() {
    //given
    Category requiredCategory = Category.TABLE;

    List<Item> expectedItems = List.of(LAMP, NIGHTLIGHT, TABLE);

    //when
    List<Item> receivedItems = storeManager.findItemsByCategoryAndSortByManufacturer(
        requiredCategory, SortDirection.ASC);

    //then
    assertEquals(receivedItems, expectedItems);
  }

  @Test
  void findItemsByCategoryAndSortDescByManufacturerTest() {
    //given
    Category requiredCategory = Category.TABLE;

    List<Item> expectedItems = List.of(TABLE, NIGHTLIGHT, LAMP);

    //when
    List<Item> receivedItems = storeManager.findItemsByCategoryAndSortByManufacturer(
        requiredCategory, SortDirection.DESC);

    //then
    assertEquals(receivedItems, expectedItems);
  }

  @Test
  void drawHierarchyTest() {
    storeManager.drawHierarchy();
    // no idea how to test System.out.println
  }

}
