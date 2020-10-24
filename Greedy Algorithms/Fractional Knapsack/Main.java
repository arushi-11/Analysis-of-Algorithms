// Fractional Knapsack by Greedy Approach!!

package com.company;

import java.util.Scanner;

class FractionalKnapsack {

    double weight[];
    double price[];
    double ratio[];
    double W;

    FractionalKnapsack() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of items in the store. ");
        int nItems = scan.nextInt();
        System.out.println("Enter the (weight and price/value) of items. ");
        weight = new double[nItems];
        price = new double[nItems];
        ratio = new double[nItems];

        for (int i = 0; i < nItems; ++i) {
            weight[i] = scan.nextDouble();
            price[i] = scan.nextDouble();
            ratio[i] = price[i] / weight[i];
        }

        System.out.println("Enter the weight of the knapsack! ");
        W = scan.nextDouble();
    }

    int getNext() {
        double highest = 0;
        int index = -1;
        for (int i = 0; i < price.length; ++i) {
            if (ratio[i] > highest) {
                highest = ratio[i];
                index = i;
            }
        }
        return index;
    }

    void fill() {
        double cW = 0; //current weight!
        double cB = 0; //current benefit!

        System.out.print("\nItems considered: ");
        while (cW < W) {
            int item = getNext();        //next highest ratio.
            if (item == -1) {
                //No items left
                break;
            }

            System.out.print((item+1)+" ");
            if (cW + weight[item] <= W) {
                cW += weight[item];
                cB += price[item];
                //mark as used for the getNext() (ratio) function.
                ratio[item] = 0;
            } else {
                cB += (ratio[item] * (W - cW));
                cW += (W - cW);
                break;  //the knapsack is full! Han ab bas!
            }
        }
        System.out.println("\nMax Benefit = " + cB + ", Max Weight = " + cW);
    }

    public static void main(String[] args) {
        FractionalKnapsack fk = new FractionalKnapsack();
        fk.fill();
    }
}