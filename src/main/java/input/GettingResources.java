package input;

import java.io.IOException;

@FunctionalInterface
public interface GettingResources {
    /**
     * Sources url(http://path; ftp://path)
     * or
     * file(file:path)
     * @return full context on URL
     */
    String getResourceContext() throws IOException;
}
