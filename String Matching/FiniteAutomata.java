//Searching string in the text given using Finite Automata!
//Finite Automata is machine i.e. going to take decision in evety stage.
//Two parts of algo:
//1. To find Transition table of the pattern i.e to be searched! Also, depending upon the pattern CTF change.
//2. Finite State Machine- Text: to search that pattern in FSM with the help of Transition table!
// Complexity: O(n) in all the cases.



package com.company;

import java.util.Scanner;

class FindingStringUsingFM
{
    public static final int no_of_char = 256;

    public static int NextStage(char[] pat, int M, int state, int x)
    {
        /*
         * If the character c is same as next character in pattern,
         * then simply increment state
         */
        if (state < M && x == pat[state])
            return state + 1;
        int ns, i;
        /*
         * ns stores the result which is next stage.
         * ns finally contains the longest prefix which is also suffix
         * in "pat[0..state-1]c"
         * Start from the largest possible value and stop when you find
         * a prefix which is also suffix
         */
        for (ns = state; ns > 0; ns--)
        {
            if (pat[ns - 1] == x)
            {
                for (i = 0; i < ns - 1; i++)
                {
                    if (pat[i] != pat[state - ns + 1 + i])
                        break;
                }
                if (i == ns - 1)
                    return ns;
            }
        }
        return 0;
    }

   //This function builds the Transition table which represents Finite Automata for a given pattern!!
   // CTF= Compute the Transition table!
    // CTF change according to question!
    public static void CTF(char[] pat, int M, int[][] TF)
    {
        int state, x;
        for (state = 0; state <= M; ++state)
            for (x = 0; x < no_of_char; ++x)
                TF[state][x] = NextStage(pat, M, state, x);
    }

    /*
     * Prints all occurrences of pat in txt...
     */
    public static void search(char[] pat, char[] txt)
    {
        int M = pat.length;
        int N = txt.length;
        int[][] TF = new int[M + 1][no_of_char];
        CTF(pat, M, TF);
        // Process txt over FA!
        int i, state = 0;
        for (i = 0; i < N; i++)
        {
            state = TF[state][txt[i]];
            if (state == M)
            {
                System.out.print(pat);
                System.out.print(" found at " + (i - M + 1));
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main string: ");
        String main = sc.nextLine();
        System.out.println("Enter the pattern string: ");
        String pattern = sc.nextLine();
        search(pattern.toCharArray(), main.toCharArray());
        sc.close();
    }
}