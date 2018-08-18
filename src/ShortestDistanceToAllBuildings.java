import java.util.LinkedList;
import java.util.Queue;

class ShortestDistanceToAllBuildings {
    private static final int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    class Point {
        int x, y, len;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.len = 0;
        }
    }

    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length, m = grid[0].length;
        int buildings = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, bfs(i, j, buildings, grid));
                }
            }
        }

        return min != Integer.MAX_VALUE ? min : -1;
    }

    private int bfs(int r, int c, int buildings, int[][] grid) {
        int min = 0;
        int found = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Point> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new Point(r, c));
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (grid[p.x][p.y] == 1) {
                min += p.len;
                found++;
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int x = p.x + dir[i][0];
                int y = p.y + dir[i][1];
                int len = p.len + 1;
                if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || visited[x][y] || grid[x][y] == 2) {
                    continue;
                }
                visited[p.x][p.y] = true;
                Point np = new Point(x, y);
                np.len = len;
                q.offer(np);
            }
        }

        return found == buildings ? min : Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        ShortestDistanceToAllBuildings p = new ShortestDistanceToAllBuildings();
        System.out.println(p.shortestDistance(grid));
    }
}