public class Snap_RotatedArray {
    private static int search(int[] arr, int v) {
        if (arr.length == 0) return -1;
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == v) {
                return mid;
            }
            boolean isLeftSorted = isSorted(arr, low, mid);
            boolean isRightSorted = isSorted(arr, mid, high);
            if (isLeftSorted && v >= arr[low] && v < arr[mid]) {
                high = mid - 1;
            } else if (isRightSorted && v > arr[mid] && v <= arr[high]) {
                low = mid + 1;
            } else {
                if (isLeftSorted) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private static boolean isSorted(int[] arr, int l, int r) {
        return arr[r] > arr[l] || l == r; // the range is sorted, so we can do normal binary search.
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {4,7,8,11,15,1,3};
        int[] arr2 = new int[] {11,15,1,3,4,7,8};

        System.out.println(search(arr1, 11));
        System.out.println(search(arr1, 3));
        System.out.println(search(arr1, 1));
        System.out.println(search(arr1, 4));

        System.out.println("=========");

        System.out.println(search(arr2, 1));
        System.out.println(search(arr2, 3));
        System.out.println(search(arr2, 15));
        System.out.println(search(arr2, 4));
    }
}
