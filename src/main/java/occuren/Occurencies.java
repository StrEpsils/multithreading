package occuren;

import java.io.IOException;

@FunctionalInterface
public interface Occurencies {

    /**
     * To find all offers from the array of words
     * @param sources array (http;ftp;files)
     * @param words array;
     * @param path path for save file;
     */
    void getOccurencies(String[] sources, String[] words, String path) throws IOException;
}
