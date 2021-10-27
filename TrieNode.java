import java.util.HashMap;

public class TrieNode {
    HashMap<Character,TrieNode> map;
    boolean endNode;
    String word;
    public TrieNode() {
        this.map = new HashMap<>();
        endNode = false;
        word = "";
    }
}
