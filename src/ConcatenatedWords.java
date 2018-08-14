import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
    class TrieNode {
        int key;
        boolean isWord;
        TrieNode[] next;

        public TrieNode() {
            this.next = new TrieNode[26];
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        TrieNode root = new TrieNode();
        for (String s : words) {
            addWord(root, s);
        }

        for (String s : words) {
            if (searchWord(root, s, 0)) {
                res.add(s);
            }
        }

        return res;
    }

    private void addWord(TrieNode root, String s) {
        if (s == null || s.length() == 0) return;
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int key = c - 'a';
            if (node.next[key] == null) {
                node.next[key] = new TrieNode();
            }
            node = node.next[key];
        }
        node.isWord = true;
    }

    private boolean searchWord(TrieNode root, String s, int count) {
        if (s.length() == 0 && count > 1) return true;
        TrieNode node = root;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int key = chs[i] - 'a';
            if (node.next[key] == null) return false;
            if (node.next[key].isWord) {
                count++;
                if (i == chs.length - 1) return count > 1;
                if (searchWord(root, s.substring(i+1), count)) return true;
            }
            node = node.next[key];
        }

        return false;
    }

    public static void main(String[] args) {
        ConcatenatedWords p = new ConcatenatedWords();
        String[] words = new String[]{"cat", "cats"};
        p.findAllConcatenatedWordsInADict(words);
    }
}
