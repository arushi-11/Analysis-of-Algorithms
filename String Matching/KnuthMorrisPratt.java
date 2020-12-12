//Knuth Morris Pratt in String matching!
// Backtracking oin text was taking extra time in naive SMA, so we moved to KMP which uses
// pi table(to find prefix of all the digits in the pattern that to be search)
// = With the help of prefix i.e. going through text only once ( No backtracking from starting)
// Complexity = O(m+n)



package com.company;

class KMP_String_Matching {
    void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        int arr[] = new int[M];
        int j = 0; // for traversing through pattern

        compute_prefix(pat, M, arr);

        int i = 0; // for traversing through text
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at shift" + (i - j));
                j = arr[j - 1];
            }

            // mismatch occurs
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = arr[j - 1];
                else
                    i = i + 1;
            }
        }
    }
// to make a pi/prefix table for the pattern text
    void compute_prefix(String pat, int M, int arr[])
    {
        int len = 0;
        int i = 1;
        arr[0] = 0; // the first element will always get a value=0

        while (i < M) {
            //m= length of the pattern to be searched!
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                arr[i] = len;
                i++;
            }
            else // (pat[i] != pat[len]) 
            {
                if (len != 0) {
                    len = arr[len - 1];
                }
                else // if (len == 0) 
                {
                    arr[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String args[])
    {
        String txt = "This is Knuth Morris Pratt Progeam in Java, ofcourse!";
        String pat = "ofc";
        new KMP_String_Matching().KMPSearch(pat, txt);
    }
} 