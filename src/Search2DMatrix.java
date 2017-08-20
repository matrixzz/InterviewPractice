public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix[0].length;
        int size = matrix.length * n;

        return binarySearch(matrix, 0, size - 1, n, target);
    }

    private boolean binarySearch(int[][] matrix, int start, int end, int n, int target) {
        int a = start + (end - start) / 2;
        int i = a / n;
        int j = a % n;
        System.out.println("Checking [" + i + ", " + j + "]");
        if (end < start || i < 0 || i >= matrix.length || j < 0 || j >= n) {
            return false;
        } else if (matrix[i][j] == target) {
            return true;
        } else if (matrix[i][j] > target) {
            return binarySearch(matrix, start, i * n + j - 1, n, target);
        } else {
            return binarySearch(matrix, i * n + j + 1, end, n, target);
        }
    }

    public static void main (String[] args) {
        int[][] matrix = new int[][] {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        Search2DMatrix problem = new Search2DMatrix();
        System.out.println(problem.searchMatrix(matrix, 3));
    }
}
