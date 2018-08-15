import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class AutocompleteSystem {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        int times;

        public TrieNode() {
            this.children = new TrieNode[27];
            this.isWord = false;
            this.times = 0;
        }
    }

    class SearchTerm implements Comparable<SearchTerm> {
        String str;
        int times;
        public SearchTerm(String str, int times) {
            this.str = str;
            this.times = times;
        }

        public int compareTo(SearchTerm s) {
            return times != s.times ? times - s.times : -str.compareTo(s.str);
        }
    }

    private TrieNode root;
    private String cur;
    private TrieNode now;
    private PriorityQueue<SearchTerm> heap;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        if (sentences.length == 0 || times.length == 0 || sentences.length != times.length) return;
        int n = sentences.length;
        for (int i = 0; i < n; i++) {
            if (sentences[i] == null || sentences[i] == "") continue;
            addWord(sentences[i], times[i]);
        }
    }

    private void addWord(String s, int times) {
        char[] chs = s.toCharArray();
        TrieNode node = root;
        for (int j = 0; j < chs.length; j++) {
            int index = getIndex(chs[j]);
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            if (j == chs.length - 1) {
                node.children[index].isWord = true;
                if (times == -1) {
                    node.children[index].times++;
                } else {
                    node.children[index].times = times;
                }
            } else {
                node = node.children[index];
            }
        }
    }

    public List<String> input(char c) {
        if ('#' == c) {
            addToTrieTree();
            return new ArrayList<String>();
        }
        int index = getIndex(c);
        if (cur == null) {
            cur = "" + c;
            now = root.children[index];
            if (now == null) return new ArrayList<String>();
        } else {
            cur = cur + c;
            if (now == null) return new ArrayList<String>();
            now = now.children[index];
        }

        heap = new PriorityQueue<SearchTerm>();
        searchAndBuildHeap(now);
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(0, heap.poll().str);
        }
        return res;
    }

    private void addToTrieTree() {
        if (cur == null || cur == "") return;
        addWord(cur, -1);
        this.cur = null;
        this.now = null;
        this.heap = null;
    }

    private void searchAndBuildHeap(TrieNode node) {
        if (node == null) return;
        for (int i = 0; i < 27; i++) {
            if (node.children[i] != null) {
                String str = cur + getChar(i);
                helper(node.children[i], str);
            }
        }
        if (node.isWord) {
            SearchTerm st = new SearchTerm(cur, node.times);
            heap.offer(st);
            while (heap.size() > 3) {
                heap.poll();
            }
        }
    }

    private void helper(TrieNode node, String str) {
        if (node.isWord) {
            SearchTerm st = new SearchTerm(str, node.times);
            heap.offer(st);
            while (heap.size() > 3) {
                heap.poll();
            }
        }
        for (int i = 0; i < 27; i++) {
            if (node.children[i] != null) {
                str = str + getChar(i);
                helper(node.children[i], str);
                str = str.substring(0, str.length() - 1);
            }
        }
    }

    private int getIndex(char c) {
        return (c == ' ' ? 26 : c - 'a');
    }

    private char getChar(int index) {
        return (index == 26 ? ' ' : (char)('a' + index));
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */

//Test case 1:
//["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input","input","input"]
//[[["abc","abbc","a"],[3,3,3]],["b"],["c"],["#"],["b"],["c"],["#"],["a"],["b"],["c"],["#"],["a"],["b"],["c"],["#"]]
//
//Test case 2:
//["AutocompleteSystem","input","input","input","input"]
//[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"]]