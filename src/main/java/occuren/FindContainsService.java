package occuren;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public abstract class FindContainsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindContainsService.class);

    /**
     * Find words on Sentence
     * @param context Sentence
     * @param words array words
     * @return true if words contains sentence
     */
    static boolean isFind(String[] context, String[] words){
        Collection<String> setContext = new HashSet<>(Arrays.asList(context));
        Collection<String> setWords = new HashSet<>(Arrays.asList(words));
        return setContext.containsAll(setWords);
    }

}
