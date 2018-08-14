import java.util.*;

public class SequenceReconstruction {
    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs == null || seqs.size() == 0) return false;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for (int i = 0; i < org.length; i++) {
            map.put(i + 1, new HashSet<>());
            degree.put(i + 1, 0);
        }

        for (List<Integer> seq : seqs) {
            if (seq == null || seq.size() == 0) continue;
            for (int i = 0; i < seq.size(); i++) {
                int n = seq.get(i);
                if (i < seq.size() - 1) map.get(n).add(seq.get(i+1));
                if (i > 0) degree.put(n, degree.get(n) + 1);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < org.length; i++) {
            if (degree.get(i+1) == 0) {
                q.offer(i+1);
            }
        }

        int index = 0;
        while(!q.isEmpty()) {
            if (q.size() > 1) return false;
            int n = q.poll();
            if(index == org.length || n != org[index++]) return false;
            for (int m : map.get(n)) {
                degree.put(m, degree.get(m) - 1);
                if (degree.get(m) == 0) {
                    q.offer(m);
                }
            }
        }

        return index == org.length;
    }

    public static final void main(String[] args) {
        int[] org = new int[]{4,1,5,2,6,3};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(5);a.add(2);a.add(6);a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(4);b.add(1);b.add(5);b.add(2);
        list.add(a);
        list.add(b);

        sequenceReconstruction(org, list);
    }
}
