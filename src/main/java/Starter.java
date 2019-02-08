import occuren.Occurencies;
import occuren.OccurenciesImpl;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {
        String[] urls = {
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
//                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt",
                "http://www.gutenberg.org/cache/epub/58838/pg58838.txt"
        };
        Occurencies occurencies = new OccurenciesImpl();
        occurencies.getOccurencies(urls,
                new String[]{"you"},
                "C:\\Workspace\\Projects\\multithreading\\src\\main\\resources\\test.txt");
    }
}
