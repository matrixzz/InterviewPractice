import java.util.*;

public class Skyline {
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0 || buildings[0].length != 3) return new ArrayList<>();
        int[][] points = new int[buildings.length * 2][3];
        for (int i = 0; i < buildings.length; i++) {
            points[i*2][0] = buildings[i][0];
            points[i*2][1] = buildings[i][2];
            points[i*2][2] = 0; // Left
            points[i*2+1][0] = buildings[i][1];
            points[i*2+1][1] = buildings[i][2];
            points[i*2+1][2] = 1; // Right
        }
        Arrays.sort(points, (a, b) -> {
            return a[0] - b[0];
        });
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        List<int[]> res = new LinkedList<>();
        int prevHeight = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][2] == 0)
                heap.add(points[i][1]);
            else
                heap.remove(points[i][1]);
            int height = heap.size() == 0 ? 0 : heap.peek();
            if (height != prevHeight) {
                int[] a = new int[2];
                a[0] = points[i][0];
                a[1] = height;
                prevHeight = a[1];
                res.add(a);
            }
        }
        String k = "ad";
        k.compareTo("ad");
        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][]{
                {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
        };
        Skyline cl = new Skyline();
        cl.getSkyline(buildings);
    }
}
