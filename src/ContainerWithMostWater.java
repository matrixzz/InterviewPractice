public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;

        while (i != j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > max) {
                max = area;
            }
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }

    public static final void main(String[] args) {
        ContainerWithMostWater problem = new ContainerWithMostWater();

        int[] height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(problem.maxArea(height));
    }
}
