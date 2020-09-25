package com.company;

class Main
{
    // Function to find the most efficient way to multiply given sequence of matrices
    public static int matrixChainMultiplication(int[] dim)
    {
        int n = dim.length;

        // c[i,j] = minimum number of scalar multiplications (i.e., cost) needed to compute the matrix M[i]M[i+1]...M[j] = M[i..j]
        // The cost is zero when multiplying one matrix i.e A1*A1= 0
        int[][] c = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) // Subsequence lengths
        {
            for (int i = 1; i <= n - len + 1; i++)
            {
                int j = i + len - 1;
                c[i][j] = Integer.MAX_VALUE;

                for (int k = i; j < n && k <= j - 1; k++)
                {
                    int cost = c[i][k] + c[k + 1][j]
                            + dim[i - 1] * dim[k] * dim[j];

                    if (cost < c[i][j]) {
                        c[i][j] = cost;
                    }
                }
            }
        }
        return c[1][n - 1];
    }

    public static void main(String[] args)
    {
        // Matrix M[i] has dimension dims[i-1] x dims[i] for i = 1..n
        // input is 10 x 30 matrix, 30 x 5 matrix, 5 x 60 matrix
        int[] dim = { 8, 9, 15, 75 };

        System.out.print("Minimum cost is "
                + matrixChainMultiplication(dim));
    }
}