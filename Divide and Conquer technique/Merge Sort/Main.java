package com.company;

import java.util.Arrays;
import java.util.Scanner;


class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // size of array, to b entered by the user!
        System.out.println("Enter the size of the Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // element of array, to be entered by the user!
        System.out.println("Enter Array Elements ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        arr = Merge_sort(arr, n);
        System.out.println("Array after Merge Sort is: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("\n");
    }

    static int[] Merge_sort(int[] arr, int size) {
        if (size > 1) {
            int mid = size / 2;
            int[] first = Arrays.copyOfRange(arr, 0, mid);

            // recursive call for first half array!
            first = Merge_sort(first, mid);
            int[] second = Arrays.copyOfRange(arr, mid, size);

            // recursive call for second half array!
            second = Merge_sort(second, size - mid);
            arr = Merge_arrays(first, second, mid, size - mid);
        }
        return arr;
    }

    // Merging the subaarays!
    static int[] Merge_arrays(int[] first, int[] second, int n, int m)
    {
        int[] arr = new int[n + m];
        int i = 0, f = 0, s = 0;
        while (f < n && s < m) {
            if (first[f] < second[s])
                arr[i++] = first[f++];
            else
                arr[i++] = second[s++];
        }
        while (f < n)
            arr[i++] = first[f++];
        while (s < m)
            arr[i++] = second[s++];
        return arr;
    }
}