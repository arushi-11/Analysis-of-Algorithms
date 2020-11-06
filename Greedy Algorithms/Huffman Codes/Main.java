//Huffman coding is a lossless data compression greedy algorithm.
//Huffman's greedy algorithm uses a table of the frequencies of occurrences
// of each character to build up an optimal way of representing each
// character as a binary string

//Pseudo code

//Huffman(1)
//n <- length(c)  c= set of characters
//Q<- C
// for i <- 1 to n-1
//    do z = Allocate_node()
//       x = left(z) = Extract.Min(Q)
//       y = right(z) = Extract.Min(Q)
//  f(z) <- f(x) + f(y)
//  Insert(Q,z)
//return_Min(Q)

// time taken = n*(log n + log n + const)
//            = O(n log n)

package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode {
    int item;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

// For comparing the nodes
class ImplementComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.item - y.item;
    }
}

// IMplementing the huffman algorithm
class Huffman {
    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {

            System.out.println(root.c + "   |  " + s);

            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {

        int n = 4;
        char[] charArray = { 'A', 'B', 'C', 'D' };
        int[] charfreq = { 5, 1, 6, 3 };

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.item = charfreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = null;

        while (q.size() > 1) {

            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.item = x.item + y.item;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;

            q.add(f);
        }
        System.out.println(" Char | Huffman code ");
        printCode(root, "");
    }
}