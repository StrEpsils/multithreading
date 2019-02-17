package parse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParserSentenceImpl implements ParserSentence {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParserSentenceImpl.class);
    /**
     * Parser Sentence
     * @param context input context
     * @return array Sentence
     */
    @Override
    public String[] parseSentence(String context) {
        LOGGER.debug("Получение контекста из потока.");
        return context.replace("\r\n|[\n\r]", " ").trim().split("\\s*[.!?]\\s*");
    }

    /**
     * Parse words on Sentence
     * @param context Sentence
     * @return array words
     */
    @Override
    public String[] parseWordsOneSentence(String context) {
        LOGGER.debug("Получение массива слов из контекста.");
        return context.replace("/W", " ").split(" ");
    }
}
