import java.util.HashMap;
import java.util.Map;

public class SentenceSimilar {
    public static void main(String[] args) {
        SentenceSimilar prb = new SentenceSimilar();
        String[] words1 = new String[]{"great","acting","skills"};
        String[] words2 = new String[]{"fine","painting","talent"};
        String[][] pairs = new String[][]{
                {"great","fine"},
                {"drama","acting"},
                {"skills","talent"},
        };
        prb.areSentencesSimilarTwo(words1,words2,pairs);
    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        if (words1.length == 0) return true;
        Map<String, Integer> idMap = new HashMap<>();
        UF uf = new UF(pairs.length * 2);
        int id = 0;
        for (String[] p : pairs) {
            if (!idMap.containsKey(p[0])) {
                idMap.put(p[0], id++);
            }
            if (!idMap.containsKey(p[1])) {
                idMap.put(p[1], id++);
            }
            int id1 = idMap.get(p[0]);
            int id2 = idMap.get(p[1]);
            uf.union(id1, id2);
        }

        for (int i = 0; i < words1.length; i++) {
            if (!idMap.containsKey(words1[i]) || !idMap.containsKey(words2[i])) return false;
            int id1 = idMap.get(words1[i]);
            int id2 = idMap.get(words2[i]);
            if (!uf.connected(id1, id2)) {
                return false;
            }
        }

        return true;
    }

    class UF {
        private int[] id;

        public UF(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        public boolean connected(int i, int j) {
            return id[i] == id[j];
        }

        public void union(int i, int j) {
            int pi = id[i];
            int pj = id[j];
            for (int k = 0; k < id.length; k++) {
                if (id[k] == pi) {
                    id[k] = pj;
                }
            }
        }
    }
}
