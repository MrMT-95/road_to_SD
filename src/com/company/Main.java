package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);

//        int size = Integer.parseInt(scanner.nextLine());
//        String[] stringTable = scanner.nextLine().split("\\s");
        int size = 10;

        String[] stringTable = ("7 546 9 1 3 10 6 4 8 2").split("\\s");
        int[] table = new int[size];
        for (int inc = 0; inc < size; inc++) {
            table[inc] = Integer.parseInt(stringTable[inc]);
        }

//        QuickSort.quickSort(table, 0, size - 1);

//        String[] stringTable = ("0.78 0.17 0.39 0.26 0.72 0.94 0.21 0.12 0.23 0.68").split("\\s");
//        double[] table = new double[size];
//        for (int inc = 0; inc < size; inc++) {
//            table[inc] = Double.parseDouble(stringTable[inc]);
//        }

//        BucketSort.bucketSort(table, size);

//        StackSort.stackSort(table,size);

//        StackSort2.stackSort(table, size);


        System.out.println("\n" + Arrays.toString(table));

    }


}
