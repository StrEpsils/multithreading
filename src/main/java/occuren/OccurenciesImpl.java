package occuren;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OccurenciesImpl implements Occurencies {

    private ExecutorService executor = Executors.newFixedThreadPool(5);
    private static final Logger LOGGER = LoggerFactory.getLogger(OccurenciesImpl.class);
    /**
     * @param sources array (http;ftp;files)
     * @param words   array;
     * @param path     path for save file;
     */
    @Override
    public void getOccurencies(String[] sources, String[] words, String path) throws IOException {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            bufferedWriter.write("");
            LOGGER.info("Файл отчистен по пути {}", path);
        }
        List<Thread> threadList = new ArrayList<>();
        for (String source : sources) {
            threadList.add(new MainLogic(source, words, path));
        }
        LOGGER.info("В очереди на обработку: {}", threadList.size());
        for (Thread startThread : threadList) {
            executor.execute(startThread);
            LOGGER.info("Запуск задания для нити: {}", startThread.getName());
        }
        executor.shutdown();
        while (!executor.isTerminated()){
        }
        LOGGER.info("Все нити завершили работу!");
    }

}
