public class Sort {
    public void quickSort(int[] a) {
        qs(a, 0, a.length - 1);
    }

    private void qs(int[] a, int low, int high) {
        if (low < high) {
            int pivot = a[low];
            int p = high;
            for (int i = high; i > low; i--) {
                if (a[i] > pivot) {
                    swap(a, i, p);
                    p--;
                }
            }
            swap(a, low, p);

            qs(a, low, p - 1);
            qs(a, p + 1, high);
        }
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static final void main(String[] args) {
        Sort problem = new Sort();
        int[] toSort = new int[] {8, 10, 12, 999, 146, 268, 2, 7, 7};
        int[] a = new int[] {7, 8, 1, 2, 5};
        problem.quickSort(toSort);
        print(toSort);
    }

    public static void print(int[] a) {
        System.out.println("Sorted array:");
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                System.out.print("[");
                System.out.print(a[i]);
            } else if (i == a.length - 1)  {
                System.out.println(" " + a[i] + "]");
            } else {
                System.out.print(" " + a[i]);
            }
        }
    }

    public static void print(int[] a, int low, int high) {
        System.out.println("Sorted array:");
        for (int i = low; i <= high; i++) {
            if (i == low) {
                System.out.print("[");
                System.out.print(a[i]);
            } else if (i == high)  {
                System.out.println(" " + a[i] + "]");
            } else {
                System.out.print(" " + a[i]);
            }
        }
    }
}
