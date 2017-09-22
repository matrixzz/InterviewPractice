import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

public class BuildingOutline {
    private class Point {
        int x;
        int y;
        boolean start;
        Point(int x, int y, boolean start) {
            this.x = x;
            this.y = y;
            this.start = start;
        }
    }

    public List<List<Integer>> buildingOutline(int[][] buildings) {
        List<List<Integer>> ret = new ArrayList<>();
        if(buildings == null || buildings.length == 0 || buildings[0].length != 3) {
            return ret;
        }

        List<Point> points = new ArrayList<>();
        for(int i = 0; i < buildings.length; i++) {
            points.add(new Point(buildings[i][0], buildings[i][2], true));
            points.add(new Point(buildings[i][1], buildings[i][2], false));
        }
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x != o2.x) {
                    return o1.x - o2.x;
                } else {
                    if(o1.start && o2.start) {
                        return o2.y - o1.y;
                    } else if (!(o1.start && o2.start)) {
                        return o1.start ? -1 : 1;
                    } else {
                        return o1.y - o2.y;
                    }
                }
            }
        });

        List<int[]> results = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0);
        int prevMax = 0;
        for(Point p : points) {
            if(p.start) {
                maxHeap.offer(p.y);
            } else {
                maxHeap.remove(p.y);
            }
            int currentMax = maxHeap.peek();
            if (currentMax != prevMax) {
                results.add(new int[]{p.x, currentMax});
                prevMax = currentMax;
            }
        }

        // Build edges
        for(int i = 0; i < results.size() - 1; i++) {
            int[] p1 = results.get(i);
            int[] p2 = results.get(i+1);
            if (p1[1] == 0 || p1[0] == p2[0]) {
                continue;
            } else {
                ret.add(new ArrayList<>(Arrays.asList(p1[0], p2[0], p1[1])));
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][]{
                {1, 3, 3},
                {2, 4, 4},
                {5, 6, 1}
        };

        BuildingOutline problem = new BuildingOutline();
        List<List<Integer>> ret = problem.buildingOutline(buildings);
        System.out.println("finished.");
    }
}
