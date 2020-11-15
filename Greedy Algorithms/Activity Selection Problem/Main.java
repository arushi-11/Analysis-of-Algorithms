//ACTIVITY-SELECTION(a, s, f)
//        A = [a[1]]
//        k = 1
//
//        for i in 2 to a.length
//        if s[i] >= f[k]
//        A.append(a[i])
//        k=i
//        return A

package com.company;

class Activity {
    public static int[] activitySelection(int a[], int s[], int f[], int n) {
        int[] A = new int[n]; // array A of size n
        A[0] = 0; //array will start from index 1. So, fake item at index 0
        A[1] = a[1];

        int k=1;
        int iter = 1;

        for(int i=2; i<=n; i++) {
            if(s[i] >= f[k]) {
                //appending array A
                iter++;
                A[iter] = a[i];
                k=i;
            }
        }

    /*
      Making first element of the array A (index 0) equal to iter
      just to know the length of the array when used in different function!
    */
        A[0] = iter;
        return A;
    }

    public static void main(String[] args) {
        //Arrays staring from 1. Elements at index 0 are fake
        int a[] = {0, 2, 3, 5, 1, 4};
        int s[] = {0, 0, 1, 3, 4, 1};
        int f[] = {0, 2, 3, 4, 6, 6};
        int[] p = activitySelection(a, s, f, 5);

        //p[0] is the length upto which activities are stored
        for(int i=1; i<=p[0]; i++) {
            System.out.println(p[i]);
        }
    }
}