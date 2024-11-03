import java.util.*;

public class Node {

    private Node[] child;
    private Node parent;
    private char letter;
    private Set<String> files;
    // key is a path to file without file name
    // value is set of files


    public Node(Node parent, char letter) {
        this.child = new Node[26];
        this.parent = parent;
        this.letter = letter;
        files = new HashSet<>();
    }

    public Node[] getChild() {
        return child;
    }

    public Node getParent() {
        return parent;
    }

    public char getLetter() {
        return letter;
    }

    public Set<String> getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return "Node{" +
                "child=" + Arrays.toString(child) +
                ", parent=" + parent +
                ", letter='" + letter + '\'' +
                ", files=" + Arrays.toString(files.toArray()) +
                '}';
    }
}
