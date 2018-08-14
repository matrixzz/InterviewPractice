import java.util.Set;

class Trie {

    private int[] letters;
    private int childrenCount;
    private Trie[] children;

    /** Initialize your data structure here. */
    public Trie() {
        this.letters = new int['z' - 'a' + 1];
        this.childrenCount = 0;
        this.children = new Trie['z' - 'a' + 1];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        int i = word.charAt(0) - 'a';
        this.letters[i]++;
        if (word.length() > 1) {
            int index = word.charAt(1) - 'a';
            this.children[index] = new Trie();
            this.children[index].insert(word.substring(1, word.length()));
            this.childrenCount++;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        int i = word.charAt(0) - 'a';
        if (this.letters[i] > 0) {
            if (word.length() == 1 && this.childrenCount == 0) return true;
            else if (word.length() == 1 && this.childrenCount > 0) return false;
            else {
                int index = word.charAt(1) - 'a';
                return this.children[index].search(word.substring(1, word.length()));
            }
        }

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        int i = prefix.charAt(0) - 'a';
        if (this.letters[i] > 0) {
            if (prefix.length() == 1) return true;
            else {
                int index = prefix.charAt(1) - 'a';
                return this.children[index].startsWith(prefix.substring(1, prefix.length()));
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        System.out.println(trie.search("a"));
        System.out.println(trie.search("ab"));
        Set<Integer>[] adj = new Set[123];

        System.out.println(trie.startsWith("a"));
        System.out.println(trie.startsWith("ab"));
    }
}