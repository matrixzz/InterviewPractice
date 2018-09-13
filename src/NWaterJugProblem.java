import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NWaterJugProblem {
    public static void main(String[] args) {

    }

    public static boolean bfs(int[] jugs, int target) {
        int sum = 0;
        for (int i : jugs) {
            sum += i;
        }
        if (sum < target) return false;

        int n = jugs.length;
        Queue<int[]> q = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();
        q.offer(new int[n]);

        return false;
    }
}
