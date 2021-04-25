package com.company;

public class QuickSort {


    static void quickSort(int[] table, int left, int right) {
        int i = left;
        int j = right;

        int pivot = table[(right + left) / 2];

        do {
            while (table[i] < pivot) {
                i++;
            }

            while (table[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int swap = table[i];
                table[i] = table[j];
                table[j] = swap;

                i++;
                j--;
            }


        } while (i <= j);

        if (left<j){
            quickSort(table,left,j);
        }

        if (right>i){
            quickSort(table,i,right);
        }

    }
}
