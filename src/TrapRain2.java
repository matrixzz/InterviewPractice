import java.util.PriorityQueue;
import java.util.Stack;

public class TrapRain2 {
    class Cell {
        int x;
        int y;
        int h;

        Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int rain = 0;
        PriorityQueue<Cell> heap = new PriorityQueue<>((o1, o2) -> {
            return o1.h - o2.h;
        });

        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            heap.add(new Cell(i, 0, heightMap[i][0]));
            heap.add(new Cell(i, m - 1, heightMap[i][m-1]));
            visited[i][0] = true;
            visited[i][m-1] = true;
        }
        for (int i = 0; i < m; i++) {
            heap.add(new Cell(0, i, heightMap[0][i]));
            heap.add(new Cell(n - 1, i, heightMap[n-1][i]));
            visited[0][i] = true;
            visited[n-1][i] = true;
        }

        while(!heap.isEmpty()) {
            Cell c = heap.poll();
            int[] xs = new int[]{1, -1, 0, 0};
            int[] ys = new int[]{0, 0, 1, -1};
            for (int i = 0; i < 4; i++) {
                int x = c.x + xs[i];
                int y = c.y + ys[i];
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    if (c.h - heightMap[x][y] > 0) System.out.println("Add rain: " + (c.h - heightMap[x][y]));
                    rain += Math.max(0, c.h - heightMap[x][y]);
                    heap.add(new Cell(x, y, Math.max(c.h, heightMap[x][y])));
                    visited[x][y] = true;
                }
            }
        }

        return rain;
    }

    public static final void main(String[] args) {
        TrapRain2 problem = new TrapRain2();
        int[][] height = new int[][]{
                {12, 13, 0, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}};
        int rain = problem.trapRainWater(height);

        System.out.println(rain);
    }
}
