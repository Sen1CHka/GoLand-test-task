import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Indexer {
    private final NodeTree tree;
    private final Tokenizer tokenizer;
    private Set<String> indexedFiles;

    public Indexer(Tokenizer tokenizer) {
        this.tree = new NodeTree();
        this.tokenizer = tokenizer;
        this.indexedFiles = new HashSet<>();
    }

    public void indexFile(String filePath) throws IOException {
        if(!indexedFiles.contains(filePath)) {
            indexedFiles.add(String.valueOf(filePath));
            String content = Files.readString(Paths.get(filePath));
            for (String word : tokenizer.tokenize(content)) {
                tree.addWord(filePath, word);
            }
            System.out.println("Indexed file: " + filePath);
        }
        else {
            System.out.println(filePath + "is already indexed");
        }

    }

    public void indexDirectory(String directoryPath) throws IOException {
        Files.list(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".txt"))
                .forEach(path -> {
                    try {
                        indexFile(String.valueOf(path));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void indexAllDirectory(String directoryPath) throws IOException {

        Files.walk(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".txt"))
                .forEach(path -> {
                    try {
                        if(!indexedFiles.contains(path.toString())) {
                            indexFile(String.valueOf(path));
                            System.out.println("Indexed file: " + path);
                        }
                        else {
                            System.out.println(path + "is already indexed");
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

    }

    public Set<String> filesContainsWord(String word) {
        System.out.println("Files contain word: " + word);
        return tree.getFiles(word);
    }

    public String doesFileContainWord(String word) {
        return tree.isContained(word) ? "File contains word : " + word : "File does not contain word : " + word;
    }

}
