//Optimal Binary Search Tree using Dynamic Programming.
// Similar to Matrix Chain Multiplication Algo!
package com.company;

//key with max freq will become root!
class Optimal_BST2 {

    /* A Dynamic Programming based function that calculates 
        minimum cost of a Binary Search Tree.  */
    static int optimalSearchTree(int keys[], int freq[], int n) { 
  
       // 2D matrix to store the results of all teh subproblem as we use BOTTOM-UP Approach in DP! :)
        int cost[][] = new int[n + 1][n + 1]; 
  
        //cost[i][j] = Optimal cost of binary search tree
        // For a single key, cost is equal to frequency of the key!
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];

        // Now we need to consider chains of length 2, 3,and so on.
        // L is chain length!
        for (int L = 2; L <= n; L++) {


            for (int i = 0; i <= n - L + 1; i++) {

                // Get column number j from row number i and  
                // chain length L 
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;

                for (int r = i; r <= j; r++) {

                    // c = cost when keys[r] becomes root of this subtree!
                    int c = ((r > i) ? cost[i][r - 1] : 0)
                            + ((r < j) ? cost[r + 1][j] : 0) + sum(freq, i, j);
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[0][n - 1];
    }

    // A function to get sum of array elements freq[i] to freq[j].
    static int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            if (k >= freq.length)
                continue;
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args) {

        int keys[] = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };
        int n = keys.length;
        System.out.println("Cost of Optimal BST is "
                + optimalSearchTree(keys, freq, n));
    }

} 