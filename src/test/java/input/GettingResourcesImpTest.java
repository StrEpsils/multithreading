package input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

class GettingResourcesImpTest {

    private GettingResources gr;

    @Test
    void getContextResource() throws IOException {
        String source = "file:src/test/resources/textFile.txt";
        gr = new GettingResourcesImp(source);
        assertEquals("world war", gr.getResourceContext());
    }

    @Test
    void getNotFoundFileResource() throws IOException {
        String sourceNull = "file:null";
        gr = new GettingResourcesImp(sourceNull);
        assertThrows(FileNotFoundException.class,() -> gr.getResourceContext());
        String sourceEmpty = "";
        gr = new GettingResourcesImp(sourceEmpty);
        assertThrows(MalformedURLException.class,() -> gr.getResourceContext());
    }
}