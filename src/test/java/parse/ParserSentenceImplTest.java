package parse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserSentenceImplTest {

    private ParserSentence parserSentence;

    @BeforeEach
    void setUp() {
        parserSentence = new ParserSentenceImpl();
    }

    @Test
    void parseSentence() {
        String[] context = parserSentence.parseSentence("OLOLO IM DRIVING UFO. YOUA TRUST ME?");
        String[] testContext = new String[]{"OLOLO IM DRIVING UFO", "YOUA TRUST ME"};
        assertArrayEquals(context, testContext);
    }

    @Test
    void parseWordsOneSentence() {
        String[] context = parserSentence.parseWordsOneSentence("OLOLO IM DRIVING UFO");
        assertArrayEquals(context, new String[]{"OLOLO", "IM", "DRIVING", "UFO"});
    }
}