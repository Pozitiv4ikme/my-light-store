package ua.lviv.iot.texteditor;

import java.util.regex.Pattern;

/**
 * My <b>ExclamatorySentences class</b>. Contains the logic of working with regular expressions...
 */
public class ExclamatorySentences {

  private static final String PATTERN_REGEXP = "(?<=\\A|\\.{1,3}|\\?|!)(\\s?(\\w|-|,|')+(\\s-\\s|\\s)?){%d}!+";
  private static final String PLACEHOLDER = "";

  /**
   * Removes all exclamatory sentences that have less than the specified number of words...
   *
   * @param input             - input text
   * @param sentenceWordCount - the minimum number of words in a sentence
   */
  public String parse(String input, int sentenceWordCount) {
    if (input == null) {
      throw new IllegalArgumentException();
    }

    var stringBuilder = new StringBuilder(input);

    var pattern = Pattern.compile(String.format(PATTERN_REGEXP, sentenceWordCount));
    var matcher = pattern.matcher(input);
    int offset = 0;

    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      stringBuilder.replace(start - offset, end - offset, PLACEHOLDER);
      offset += matcher.end() - matcher.start();
    }
    return stringBuilder.toString();
  }
}

