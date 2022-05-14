package ua.lviv.iot.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ExclamatorySentencesTest {

  public static List<Arguments> testArgumentProvider() {
    return List.of(
        Arguments.of(" Why are you alone here! Hi, I would just like to know how you... He dreams "
                + "of only one thing - to be a programmer! That's how we will die, bro.",  //input
            " Hi, I would just like to know how you... He dreams "
                + "of only one thing - to be a programmer! That's how we will die, bro."), //expected
        // deleted - Why are you alone here!
        Arguments.of("Every leader must: keep the team together, keep the participants in the "
                + "mood and watch the tasks in time! This is a BASE! I need to pass the lab work until "
                + "7:25 pm, so sorry Bogdan You really love Python? I only dream of peace now!",
            "Every leader must: keep the team together, keep the participants in the "
                + "mood and watch the tasks in time! I need to pass the lab work until "
                + "7:25 pm, so sorry Bogdan You really love Python? I only dream of peace now!"),
        // deleted - This is a BASE!
        Arguments.of("You are my best friend at university!!! I love you! Please, Victoria, "
                + "let's meet after the war! Kill the putler! "
                + "Fuck off! I will never forget the time I spent with you!",
            "You are my best friend at university!!! Please, Victoria, "
                + "let's meet after the war! I will never forget the time I spent with you!"
        )
        // deleted - I love you! and Kill the putler! and Fuck off!
    );
  }

  @ParameterizedTest
  @MethodSource("testArgumentProvider")
  public void parseSentencesFirstCaseTest1(String input, String expectedResult) {
    //when
    var exclamatorySentences = new ExclamatorySentences();
    var actual = exclamatorySentences.parse(input, 5);

    //then
    assertEquals(expectedResult, actual);
  }

}
