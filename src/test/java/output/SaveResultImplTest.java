package output;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SaveResultImplTest {

    private SaveResults saveResults;
    private File temp;

    @BeforeEach
    void setUp() throws IOException {
        saveResults = new SaveResultImpl();
        temp = File.createTempFile("tempFileTest", ".txt");
    }

    @Test
    void save() throws IOException {
        byte[] testContext = ("LOLOLO" + "\r\n").getBytes();
        saveResults.save("LOLOLO", temp.getAbsolutePath());
        byte[] saveTempFile = Files.readAllBytes(Paths.get(temp.getAbsolutePath()));
        assertEquals(new String(testContext, StandardCharsets.UTF_8), new String(saveTempFile, StandardCharsets.UTF_8));
    }
}