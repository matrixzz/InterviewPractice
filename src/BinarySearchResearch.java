public class BinarySearchResearch {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,1,1,1,1,1,1,1,1,1};
        int[] nums2 = new int[]{1,2,3,4,5,6,7,8,9};
        int[] nums3 = new int[]{1,1,1,1,1,1,1,1,1,3};
        int[] nums4 = new int[]{1,2,2,2,2,2,2,2,2,3};

//        print(search1(nums1, 1));
//        print(search1(nums2, 5));
//        print(search1(nums3, 1));
//        print(search1(nums4, 2));
//
//        print(-100000);
//        print(search_optimized(nums1, 1));
//        print(search_optimized(nums2, 6));
//        print(search_optimized(nums3, 3));
//        print(search_optimized(nums4, 2));
//
//        print(-100000);
//        print(search0(nums1, 1));
//        print(search0(nums2, 6));
//        print(search0(nums3, 3));
//        print(search0(nums4, 0));

        print(-10000);
        print(search_double(16, 10e-5));
    }

    private static void print(double i) {
        System.out.println("Result is " + i);
    }

    private static int search1(int[] nums, int v) {
        int l = 0, r = nums.length - 1, mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] < v) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (nums[r] == v)
            return r;

        return -1;
    }

    private static int search_optimized(int[] nums, int v) {
        int l = -1, r = nums.length, mid;
        while (l + 1 != r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] < v) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (r >= nums.length || nums[r] != v) {
            return -1;
        }

        return r;
    }

    private static int search0(int[] nums, int v) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] < v) {
                l = mid + 1;
            } else if (nums[mid] > v) {
                r = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private static double search_double(int n, double precision) {
        double l = 0, r = n, mid;
        while (r - l > precision) {
            mid = l + (r - l) / 2;
            if (mid * mid < n) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return r;
    }
}
