//Dynamic Programming implementation of 0-1 Knapsack problem!

package com.company;

import java.util.*;
public class Main
{
    // Function to find maximum of two integers.
    static int max(int a, int b) {
        return (a > b)? a : b; }

    //Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int weight[], int value[], int n)
    {
        int i, w;
        int[][] K = new int[n+1][W+1];

        // Building ma matrix K[][] in bottom up manner because DP works BOTTOM-UP Approach!
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (weight[i-1] <= w)
                    K[i][w] = max(value[i-1] + K[i-1][w-weight[i-1]], K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }

    //Main function!
    public static void main (String args[])
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of items :");
        n = sc.nextInt();
        int[] value = new int[n];
        int[] weight = new int[n];
        int i;

        System.out.print("Enter the items weight" );
        for(i = 0; i < n; i++)
        {
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter the items value" );
        for(i = 0; i < n; i++)
        {
            value[i] = sc.nextInt();
        }
        
        int W;
        System.out.print("Enter the capacity of the knapsack :" );
        W = sc.nextInt();
        System.out.print(" Maximum value in a 0-1 knapsack :" + knapSack(W, weight, value, n));
    }
}