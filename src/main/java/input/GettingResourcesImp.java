package input;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

public class GettingResourcesImp implements GettingResources {

    private static final Logger LOGGER = LoggerFactory.getLogger(GettingResourcesImp.class);
    private String source;

    /**
     * Constructor get context resource
     *
     * @param source url or file
     */
    public GettingResourcesImp(String source) {
        this.source = source;
    }

    /**
     * Get context resource
     *
     * @return context
     * @throws IOException
     */
    @Override
    public String getResourceContext() throws IOException {
        try (InputStream in = new URL(source).openStream()) {
            LOGGER.info("Get context from {}", source);
            return IOUtils.toString(in, Charset.defaultCharset());
        }
    }
}
