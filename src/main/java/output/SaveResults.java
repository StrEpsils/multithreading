package output;

@FunctionalInterface
public interface SaveResults {
    /**
     * save context with path
     * @param context result context for save
     * @param path where want save file
     */
    void save(String context, String path);
}
