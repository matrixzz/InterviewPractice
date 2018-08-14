import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    private static int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) return false;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        int n = maze.length, m = maze[0].length;
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int xx = p.x;
            int yy = p.y;
            for (int i = 0; i < 4; i++) {
                while (xx >= 0 && xx < n && yy >= 0 && yy < m && maze[xx][yy] == 0) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                }
                xx -= dir[i][0];
                yy -= dir[i][1];
                if (visited[xx][yy]) {
                    continue;
                }
                visited[xx][yy] = true;
                if (xx == destination[0] && yy == destination[1]) {
                    return true;
                }
                q.offer(new Point(xx, yy));
                System.out.println("xx = " + xx + " yy = " + yy);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        System.out.println(new TheMaze().hasPath(maze, new int[]{0,4}, new int[]{4,4}));
    }
}
