import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileIndexerApp {

    private final Indexer indexer;

    public FileIndexerApp(Tokenizer tokenizer) {
        this.indexer = new Indexer(tokenizer);
    }

    public void startConsole() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File Indexer App");
        System.out.println(Files.readString(Paths.get("commands/commands.txt")));
        while (true) {
            System.out.println("Enter command : ");
            String command = scanner.nextLine();
            if (command.matches("file\\s+\\S+\\s*")) {

                    var parts = command.split("\\s+", 3);
                    var filePath = parts[1];

                    Path path = Paths.get(filePath);
                    if(!Files.exists(path)) {
                        System.out.println("File does not exist");
                    }
                    indexer.indexFile(filePath);

                    if(parts.length>2)
                    {
                        var word = parts[2].toLowerCase();
                        System.out.println(indexer.doesFileContainWord(word));
                    }
            }
            else if (command.matches("dir\\s+\\S+\\s*")) {
                var parts = command.split("\\s+", 3);
                var dirPath = parts[1];

                Path path = Paths.get(dirPath);
                if (!Files.exists(path) || !Files.isDirectory(path)) {
                    System.out.println("Directory does not exist or is not a directory.");
                }
                else {
                    indexer.indexDirectory(String.valueOf(path));
                }
                if (parts.length > 2) {
                    var word = parts[2];
                    System.out.println(indexer.filesContainsWord(word));
                }

            } else if(command.matches("allDir\\s+\\S+\\s*")) {
                var parts = command.split("\\s+", 3);
                var dirPath = parts[1];

                Path path = Paths.get(dirPath);
                if (!Files.exists(path) || !Files.isDirectory(path)) {
                    System.out.println("Directory does not exist or is not a directory.");
                }
                else {
                    indexer.indexAllDirectory(String.valueOf(path));
                }
                if(parts.length > 2) {
                    var word = parts[2].toLowerCase();
                    System.out.println(indexer.filesContainsWord(word));
                }

            } else if(command.matches("word\\s+\\S+")) {
                var parts = command.split("\\s+", 2);
                var word = parts[1].toLowerCase();

                System.out.println(indexer.filesContainsWord(word));

            } else if (command.equals("exit")) {
                break;
            } else if(command.equals("commands")) {
                System.out.println(Files.readString(Paths.get("commands/commands.txt")));
            } else {
                System.out.println("Invalid command.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        FileIndexerApp app = new FileIndexerApp(new Tokenizer());
        app.startConsole();
    }
}
