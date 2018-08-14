public class MedianOfTwoSortedArrays {
    public static double median(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n > m) return median(nums2, nums1);
        int iMin = 0, iMax = n;

        while (iMin <= iMax) {
            int p1 = (iMin + iMax) / 2;
            int p2 = (n + m) / 2 - p1;
            int left1 = p1 - 1 < 0 ? Integer.MIN_VALUE : nums1[p1 - 1];
            int right1 = p1 >= n ? Integer.MAX_VALUE : nums1[p1];
            int left2 = p2 - 1 < 0 ? Integer.MIN_VALUE : nums2[p2 - 1];
            int right2 = p2 >= m ? Integer.MAX_VALUE : nums2[p2];

            if (left1 > right2) {
                iMax = p1 - 1;
            } else if (left2 > right1) {
                iMin = p1 + 1;
            } else {
                if ((n + m) % 2 == 1) return Math.min(right1, right2);
                else return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2}, num2 = new int[]{3,4};
        System.out.println(median(num1, num2));
    }
}
