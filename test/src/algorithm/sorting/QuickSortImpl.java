package algorithm.sorting;

public class QuickSortImpl {
    static int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void main(String[] args) {
        sort(0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void sort(int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot]) {
                left += 1;
            }
            while (right > start && arr[right] >= arr[pivot]) {
                right -= 1;
            }

            if (left > right) {
                swap(right, pivot);
            }
            else {
                swap(left, right);
            }
            sort(start, right - 1);
            sort(right + 1, end);
        }
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
