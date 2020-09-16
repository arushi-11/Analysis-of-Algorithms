package com.company;

import java.util.Scanner;

class OrderStats
{
    public static int partition(int[] array, int first, int last)
    {
        int pivot = array[first];
        int pivotPosition = first++;
        while (first <= last)
        {
            // scan for values less than the pivot!
            while ((first <= last) && (array[first] < pivot))
            {
                first++;
            }
            // scan for values greater than the pivot!
            while ((last >= first) && (array[last] >= pivot))
            {
                last--;
            }
            if (first > last)
            {
                // swap the last unconfirmed element with the pivot!
                swap(array, pivotPosition, last);
            }
            else
            {
                // swap unconfirmed elements!
                // first that was not lesser than the pivot and last that was not larger than the pivot!
                swap(array, first, last);
            }
        }
        return last;
    }

    private static void swap(int[] array, int first, int last)
    {
        int temp;
        temp = array[first];
        array[first] = array[last];
        array[last] = temp;
    }


    // iterative version!
    private static int Randomized_select(int[] array, int k, int first, int last)
    {
        int pivotPosition = partition(array, first, last);
        while (pivotPosition != k - 1)
        {
            if (k - 1 < pivotPosition)
            {
                last = pivotPosition - 1;
            }
            else
            {
                first = pivotPosition + 1;
            }
            pivotPosition = partition(array, first, last);
        }
        return array[k - 1];
    }

    public static int kthLargest(int[] array, int k)
    {
        return Randomized_select(array, array.length - k + 1, 0, array.length - 1);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        int[] sequence = new int[n];
        System.out.println("Enter the elements of the  sequence: ");
        for (int i = 0; i < sequence.length; i++)
        {
            sequence[i] = sc.nextInt();
        }
        System.out.println("Enter the kth index to be returned");
        int k = sc.nextInt();
        System.out.println("Kth largest:" + kthLargest(sequence, k));
        sc.close();
    }
}