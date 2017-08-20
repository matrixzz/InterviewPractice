public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a, b;
        a = nums1.length >= nums2.length ? nums2 : nums1;
        b = nums1.length >= nums2.length ? nums1 : nums2;
        int imin = -1;
        int imax = a.length - 1;
        int i, j, max_of_left, min_of_right;
        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = (a.length + b.length + 1) / 2 - i - 2;
            System.out.println("i = " + i + " j = " + j);
            if (i < a.length - 1 && b[j] > a[i+1]) {
                imin = i + 1;
            } else if (i > -1 && a[i] > b[j+1]) {
                imax = i - 1;
            } else {
                if (i == -1) max_of_left = b[j];
                else if (j == -1) max_of_left = a[i];
                else max_of_left = Math.max(a[i], b[j]);
                if ((a.length + b.length) % 2 == 1)
                    return max_of_left;

                if (i == a.length - 1) min_of_right = b[j+1];
                else if (j == b.length - 1) min_of_right = a[i+1];
                else min_of_right = Math.min(a[i+1], b[j+1]);
                return (max_of_left + min_of_right) / 2.0;
            }
        }
        return -1;
    }

    public static final void main (String[] args) {
        MedianOfTwoSortedArrays c = new MedianOfTwoSortedArrays();
        int[] a = new int[] {1, 2, 3};
        int[] b = new int[] {5, 6, 7, 8, 9};
        int[] e = new int[] {7, 8, 9};
        int[] f = new int[] {1, 2, 3, 4, 5};
        int[] k = new int[] {1, 2};
        int[] j = new int[] {3, 4};
        System.out.println(c.findMedianSortedArrays(a, b));
        System.out.println(c.findMedianSortedArrays(e, f));
        System.out.println(c.findMedianSortedArrays(k, j));
    }
}
