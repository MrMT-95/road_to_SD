package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);

//        int size = Integer.parseInt(scanner.nextLine());
//        String[] stringTable = scanner.nextLine().split("\\s");
        int size = 9;
        String[] stringTable = ("2 5 1 3 4 0 6 2 5").split("\\s");
        int[] table = new int[size];
        for (int inc = 0; inc < size; inc++) {
            table[inc] = Integer.parseInt(stringTable[inc]);
        }

        System.out.println(Arrays.toString(table));

        quickSort(table, 0, size - 1);

        System.out.println(Arrays.toString(table));

    }

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
