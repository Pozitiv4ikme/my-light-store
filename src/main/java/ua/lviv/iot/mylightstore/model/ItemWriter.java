package ua.lviv.iot.mylightstore.model;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import ua.lviv.iot.mylightstore.model.item.impl.Item;

/**
 * My <b>ItemWriter class</b>.
 * Writes items to a .csv file...
 */
public class ItemWriter {

  private static final String DEFAULT_FILE_NAME = "data.csv";
  private String fileName;

  public ItemWriter() {
    this.fileName = DEFAULT_FILE_NAME;
  }

  /**
   * Checks if the file name is null...
   *
   * @param newFileName - name of the .csv file
   */
  public ItemWriter(final String newFileName) {
    this.fileName = Objects.requireNonNullElse(newFileName,
        DEFAULT_FILE_NAME);
  }

  /**
   * A method that writes list of items to a separate .csv file...
   *
   * @param items - list of items.
   */
  public void writeToFile(final List<Item> items) throws IOException {
    try (BufferedWriter writer =
        new BufferedWriter(new FileWriter(fileName, UTF_8))) {
      writer.write(Item.getHeaders());
      writer.newLine();
      for (Item item : items) {
        writer.write(item.toCsv());
        writer.newLine();
      }
    }
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(final String newFileName) {
    this.fileName = newFileName;
  }
}
