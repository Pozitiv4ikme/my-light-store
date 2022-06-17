package ua.lviv.iot.mylightstore.model.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.mylightstore.model.Category;
import ua.lviv.iot.mylightstore.model.ItemWriter;
import ua.lviv.iot.mylightstore.model.item.impl.Item;

public class ItemWriterTest {

  private static final String FILE_NAME = "data1.csv";
  private static final String DEFAULT_FILE_NAME = "data.csv";
  private static final Item CEILING = new Item("Bird Eye", "UkraineHelpCo", 150.00, 220,
      Category.CEILING);
  private static final Item LAMP = new Item("Blue Sea", "Coca-Cola", 20.01, 2.4, Category.LAMP);
  private static final Item FLOOR = new Item("Peace of sun", "DisneyCo", 1000.99, 500,
      Category.FLOOR);
  private static final Item TABLE = new Item("FunCloud", "CreateYourLife", 35.22, 10,
      Category.TABLE);
  private static final Item NIGHTLIGHT = new Item("Small Happy Elephant", "CoolBEReady", 68.45, 3.2,
      Category.NIGHTLIGHT);
  private static final Item CHANDELIER = new Item("Jack Pirate", "Pirates of the Caribbean", 199,
      1.2, Category.CHANDELIER);
  private ItemWriter itemWriter;

  @Test
  void basicConstructor() {
    itemWriter = new ItemWriter("data1.csv");
    assertEquals(itemWriter.getFileName(), FILE_NAME);
  }

  @Test
  void basicEmptyConstructor() {
    itemWriter = new ItemWriter();
    assertEquals(itemWriter.getFileName(), DEFAULT_FILE_NAME);
  }

  @Test
  void writeToFile() throws IOException {
    ItemWriter writer = new ItemWriter();
    String fileName = writer.getFileName();
    List<Item> items = List.of(CEILING, LAMP, FLOOR, TABLE, NIGHTLIGHT, CHANDELIER);
    writer.writeToFile(items);
    File fileOfExpectedItems = new File(fileName);

    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileOfExpectedItems));

    //given
    String expected = generateCSV(items);

    //when
    StringBuilder actual = new StringBuilder();
    int curr;
    while ((curr = bufferedReader.read()) != -1) {
      actual.append((char) curr);
    }

    //then
    bufferedReader.close();
    fileOfExpectedItems.delete();
    assertEquals(expected, actual.toString());
  }

  @Test
  void writeToFileWithSpecificName() throws IOException {
    ItemWriter writer = new ItemWriter();
    String fileName = "another-test.csv";
    writer.setFileName(fileName);
    List<Item> items = List.of(CEILING, LAMP, FLOOR, TABLE, NIGHTLIGHT, CHANDELIER);
    writer.writeToFile(items);
    File fileOfExpectedItems = new File(fileName);

    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileOfExpectedItems));

    //given
    String expected = generateCSV(items);

    //when
    StringBuilder actual = new StringBuilder();
    int curr;
    while ((curr = bufferedReader.read()) != -1) {
      actual.append((char) curr);
    }

    //then
    bufferedReader.close();
    fileOfExpectedItems.delete();
    assertEquals(expected, actual.toString());
  }

  private String generateCSV(List<Item> items) {
    String separator = System.getProperty("line.separator");
    StringBuilder builder = new StringBuilder(Item.getHeaders() + separator);
    items.forEach(item -> builder.append(item.toCsv()).append(separator));
    return builder.toString();
  }
}
