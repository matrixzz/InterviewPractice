import java.util.PriorityQueue;

public class TrappingRainWaterII {
    public static int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        int n = heightMap.length, m = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        boolean[][] visited = new boolean[n][m];
        int water = 0;
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Add boundries
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, m-1, heightMap[i][m-1]});
            visited[i][0] = visited[i][m-1] = true;
        }
        for (int j = 1; j < m-1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{n-1, j, heightMap[n-1][j]});
            visited[0][j] = visited[n-1][j] = true;
        }

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            for (int i = 0; i < direction.length; i++) {
                int x = cell[0] + direction[i][0];
                int y = cell[1] + direction[i][1];
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    water += Math.max(cell[2] - heightMap[x][y], 0);
                    pq.offer(new int[]{x, y, Math.max(heightMap[x][y], cell[2])});
                    visited[x][y] = true;
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        int ans = TrappingRainWaterII.trapRainWater(input);
        System.out.println(ans);
    }
}
