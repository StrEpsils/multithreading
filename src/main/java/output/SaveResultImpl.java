package output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class SaveResultImpl implements SaveResults {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveResultImpl.class);

    @Override
    public synchronized void save(String context, String path) {
        LOGGER.info("Запись в файл по пути: {}", path);
        try(OutputStream outputStream = new FileOutputStream(new File(path), true)){
            outputStream.write((context + "\r\n").getBytes());
            LOGGER.debug("Запись в файл завершена");
        } catch (IOException e){
            LOGGER.warn("Ошибка записи в файл! {}", e.fillInStackTrace());
        }
    }
}
