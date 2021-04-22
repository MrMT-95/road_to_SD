package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] stringTable = scanner.nextLine().split("\\s");
        int[] table = new int[size];
        for (int inc = 0; inc < size; inc++) {
            table[inc] = Integer.parseInt(stringTable[inc]);
        }

        System.out.println(Arrays.toString(table));

        quickSort(table, 0, size - 1);

        System.out.println(Arrays.toString(table));

    }

    static void quickSort(int[] table, int left, int right) {
        int i;
        int j;

        if (right <= left) {
            return;
        }

        int pivotPos = (right + 1) / 2;
        int pivot = table[pivotPos];


        while (true) {

            for (i = left; i < right; i++) {
                if (table[i] >= pivot) {
                    break;
                }
            }

            for (j = right; j > left; j--) {
                if (table[j] <= pivot) {
                    break;
                }
            }


            if (i < j) {
                int swap = table[i];
                table[i] = table[j];
                table[j] = swap;
            } else {
                break;
            }
        }

        if (j > left) {
            quickSort(table, left, j);
        }
        if (i < right) {
            quickSort(table, i, right);
        }


    }
}
