public class MergeSort {
    // Merge Sort
    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int p = l, q = m + 1, k = 0;
        int[] sort = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            if (p > m) {
                sort[k++] = arr[q++];
            } else if (q > r) {
                sort[k++] = arr[p++];
            } else if (arr[p] < arr[q]) {
                sort[k++] = arr[p++];
            } else {
                sort[k++] = arr[q++];
            }
        }
        for (int i = 0; i < k; i++) {
            arr[l++] = sort[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 9, 12, 2317, 41};
        MergeSort sort = new MergeSort();
        sort.mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
