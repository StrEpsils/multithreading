package parse;

public interface ParserSentence {
    /**
     * Parser Sentence
     * @param context input context
     * @return array Sentence
     */
    String[] parseSentence(String context);

    /**
     * Parse words on Sentence
     * @param context Sentence
     * @return array words
     */
    String[] parseWordsOneSentence(String context);
}
