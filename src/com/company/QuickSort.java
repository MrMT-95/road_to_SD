package com.company;

public class QuickSort {


    static void quickSort(int[] table, int left, int right) {
        //set left and right boundary
        int i = left;
        int j = right;

        //create middle point
        int pivot = table[(right + left) / 2];

        do {
            //looking for greater element than pivot
            while (table[i] < pivot) {
                i++;
            }
            //looking for smaller element than pivot
            while (table[j] > pivot) {
                j--;
            }

            //swapping greater and smaller elements
            // to have smaller elements on left side of pivot
            // and greater on right side of pivot
            if (i <= j) {
                int swap = table[i];
                table[i] = table[j];
                table[j] = swap;

                i++;
                j--;
            }

        } while (i <= j);

        //sorting left table side
        if (left<j){
            quickSort(table,left,j);
        }

        //sorting right table side
        if (right>i){
            quickSort(table,i,right);
        }

    }
}
