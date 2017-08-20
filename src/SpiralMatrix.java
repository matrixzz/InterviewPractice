import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int i = 0;
        int j = 0;
        int n = matrix[0].length;
        int m = matrix.length;
        for (; res.size() < n * m; i++, j++) {
            for (int p = i; p < n - i; p++) {
                res.add(matrix[j][p]);
            }
            for (int q = j + 1; q < m - j; q++) {
                res.add(matrix[q][n - i - 1]);
            }
            for (int p = n - i - 2; p >= i; p--) {
                res.add(matrix[m - j - 1][p]);
            }
            for (int q = m - j - 2; q >= i + 1; q--) {
                res.add(matrix[q][i]);
            }
        }
        return res;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0, j = 0, count = 1;
        for (; count < n * n + 1; i++, j++) {
            for (int p = i; p < n - i; p++) {
                matrix[j][p] = count++;
            }
            for (int q = j + 1; q < n - j; q++) {
                matrix[q][n - i - 1] = count++;
            }
            for (int p = n - i - 2; p >= i; p--) {
                matrix[n - j - 1][p] = count++;
            }
            for (int q = n - j - 2; q >= i + 1; q--) {
                matrix[q][i] = count++;
            }
        }
        return matrix;
    }

    static public void main (String[] args) {
        SpiralMatrix problem = new SpiralMatrix();
        int[][] a = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(problem.spiralOrder(a));
        int[][] b = problem.generateMatrix(3);
    }
}
