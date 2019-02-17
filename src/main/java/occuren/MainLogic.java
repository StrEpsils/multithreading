package occuren;

import input.GettingResources;
import input.GettingResourcesImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import output.SaveResultImpl;
import output.SaveResults;
import parse.ParserSentence;
import parse.ParserSentenceImpl;

import java.io.IOException;

public class MainLogic extends Thread {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainLogic.class);
    private String source;
    private String[] words;
    private volatile String path;

    MainLogic(String source, String[] words, String path) {
        this.source = source;
        this.words = words;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            LOGGER.debug("Запуск нити {}", currentThread().getName());
            GettingResources resources = new GettingResourcesImp(source);
            String sentence = resources.getResourceContext();
            ParserSentence parserSentence = new ParserSentenceImpl();
            String[] arraySentence = parserSentence.parseSentence(sentence);
            for (String arrSentence : arraySentence) {
                if (FindContainsService.isFind(parserSentence.parseWordsOneSentence(arrSentence), words)) {
                    SaveResults saveResults = new SaveResultImpl();
                    saveResults.save(arrSentence, path);
                }
            }
            LOGGER.debug("Завершение нити {}", currentThread().getName());
            interrupt();
        } catch (IOException e) {
            LOGGER.warn("Ошибка обработки в нити {}", currentThread().getName());
        }
    }
}
