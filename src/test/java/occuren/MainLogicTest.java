package occuren;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MainLogicTest {

    private File path;
    private String source;
    private MainLogic mainLogic;
    private String[] words;

    @BeforeEach
    void setUp() throws IOException {
        words = new String[]{"war"};
        source = "file:src/test/resources/textFile.txt";
        path = File.createTempFile("tempFileTest", ".txt");
        mainLogic = new MainLogic(source, words, path.getAbsolutePath());
    }

    @Test
    void run() throws IOException {
        byte[] testContext = ("world war" + "\r\n").getBytes();
        mainLogic.run();
        byte[] saveTempFile = Files.readAllBytes(Paths.get(path.getAbsolutePath()));
        String text1 = new String(testContext, StandardCharsets.UTF_8);
        String text2 = new String(saveTempFile, StandardCharsets.UTF_8);
        assertEquals(text1, text2);
    }
}