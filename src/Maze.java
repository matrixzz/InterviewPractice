import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static final void main(String[] args) {
        int[][] maze = new int[][] {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        System.out.println(findPath(maze));
    }

    static class Point {
        int x, y;
        int len;
        String path;

        public Point(int x, int y, int len, String path) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.path = path;
        }
    }

    static final int[][] DIR = new int[][] {{-1,0}, {1,0}, {0,1}, {0,-1}};
    static final Character[] DIR_CHAR = new Character[]{'u', 'd', 'r', 'l'};

    public static String findPath(int[][] maze) {
        if (maze.length == 0 || maze[0].length == 0) return "";
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        visited[0][0] = true;
        String path = "";
        q.offer(new Point(0, 0, 0, path));
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = p.x + DIR[i][0];
                int newY = p.y + DIR[i][1];
                int newLen = p.len + 1;
                String newPath = p.path + DIR_CHAR[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && maze[newX][newY] == 0 && !visited[newX][newY]) {
                    if (newX == n - 1 && newY == m - 1) {
                        if (newLen < min) {
                            min = newLen;
                            path = newPath;
                        }
                    }
                    visited[newX][newY] = true;
                    q.offer(new Point(newX, newY, newLen, newPath));
                }
            }
        }

        return path;
    }
}
