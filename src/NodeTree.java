
import java.util.Set;

public class NodeTree {

    private Node root;

    public NodeTree() {
        root = new Node(null, ' ');
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int charIndex(char letter) {
        return (int) letter - 'a';
    }

    public void addWord(String file, String word) {

        char[] stringToChar = word.toLowerCase().toCharArray();
        Node current = root;
        for (char c : stringToChar) {
            if (current.getChild()[charIndex(c)] == null) {
                current.getChild()[charIndex(c)] = new Node(current, c);
                current = current.getChild()[charIndex(c)];
            } else {
                current = current.getChild()[charIndex(c)];
            }
        }
        current.getFiles().add(file);

    }

    public Node findWord(String word) {
        char[] stringToChar = word.toLowerCase().toCharArray();
        Node current = root;
        for (char c : stringToChar) {

            if (current.getChild()[charIndex(c)] == null) return null;
            current = current.getChild()[charIndex(c)];
        }
        return current;
    }

    public Set<String> getFiles(String word) {
        if(findWord(word) == null) return null;
        return findWord(word).getFiles();
    }
    public boolean isContained(String word) {
        return findWord(word)!=null;
    }
}
