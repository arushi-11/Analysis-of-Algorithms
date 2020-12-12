// Rabin-Karp algorithm in String Matching!
// Complexity = O(n-m=1)

//Unlike Naive string matching algorithm, it does not travel through
// every character in the initial phase rather it filters the characters
// that do not match and then performs the comparison.
//        n = t.length // text length
//        m = p.length // pattern length
//        h = d^m-1 mod q // Used hash function to reduce complexity produced in naive SMA
//        p = 0
//        t0 = 0
//        for i = 1 to m // Pattern!
//             p = (dp + p[i]) mod q
//             t0 = (dt0 + t[i]) mod q
//        for s = 0 to n - m // s= shift, running n-m length in the text.
//               (n-m not n because the length of pattern is m, so we don't need to
//                search after n-m in the text)
//            if p = ts
//            if p[1.....m] = t[s + 1..... s + m]
//             print "pattern found at position" s
//        If s < n-m
//        ts + 1 = (d (ts - t[s + 1]h) + t[s + m + 1]) mod q



package com.company;

class RabinKarp {
    public final static int d = 10;

    static void search(String pattern, String txt, int q) {
        int m = pattern.length();
        int n = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        for (i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // Calculate hash value for pattern and text
        for (i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Find the match
        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                if (j == m)
                    System.out.println("Pattern is found at Shift: " + (i + 1));
            }

            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                if (t < 0)
                    t = (t + q);
            }
        }
    }

    public static void main(String[] args) {
        String txt = "Arushi Sharma";
        String pattern = "ar";
        int q = 13;
        search(pattern, txt, q);
    }
}