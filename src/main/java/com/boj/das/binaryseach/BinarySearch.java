package com.boj.das.binaryseach;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,4,6,8,12,17,19,44,48,51,80};
        int result = BinarySearch.search(arr, 19);
        System.out.println(result);

        result = BinarySearch.search(arr, 6, 0, arr.length - 1);
        System.out.println(result);

        result = BinarySearch.search(arr, 18, 0, arr.length - 1);
        System.out.println(result);
    }

    /**
     * Performs a binary search using a loop.
     *
     * @param arr
     * @param target
     * @return the index at which target exists, or -1
     */
    public static int search(int[] arr, int target) {
        int begin = 0;
        int end = arr.length - 1;

        while (begin <= end) {

            int mid = begin + (end - begin) / 2;
            int v = arr[mid];

            if (v == target) {
                return mid;
            }

            if (v < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;
    }

    /**
     * Performs a binary search using recursion.
     *
     * @param arr
     * @param target
     * @param begin
     * @param end
     * @return the index at which target exists, or -1
     */
    public static int search(int[] arr, int target, int begin, int end) {
        if (end < begin) {
            return -1;
        }

        int mid = begin + (end - begin) / 2;
        int v= arr[mid];

        if (v == target) {
            return mid;
        }

        if (v < target) {
            return search(arr, target, mid + 1, end);
        } else {
            return search(arr, target, begin, mid - 1);
        }
    }

}
