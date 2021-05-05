package com.company;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class BinaryHeap {
    static void sort(int[] table, int size) {
        int i;

        //run max binary heap
        for (i = size / 2 - 1; i >= 0; i--) {
            heapify(table, size, i);
        }

        int heapHeight = getHeight(size);
        double leftBranch = 0;
        double rightBranch = 0;
        System.out.println(table[0]);

        for (i = 0; i < heapHeight; i++) {
            leftBranch = leftBranch + Math.pow(2, i);
            rightBranch = rightBranch + Math.pow(2, i + 1);

            for (int j = (int) leftBranch; j <= rightBranch; j++) {
                if (j >= size) {
                    break;
                }

                System.out.print(table[j] + " ");

            }
            System.out.println("");
        }


        //print sorted table
//        // extract root from heap and shorten table
//        for (int i = size - 1; i > 0; i--) {
//            // more root to end of heap
//            int temp = table[0];
//            table[0] = table[i];
//            table[i] = temp;
//
//            // sort heap with reduced size
//            heapify(table, i, 0);
//        }


    }


    static void heapify(int[] table, int size, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        // check if left child is greater that parent
        if (left < size && table[left] > table[largest]) {
            largest = left;
        }

        // check if right child is greater that parent
        if (right < size && table[right] > table[largest]) {
            largest = right;
        }

        //check if largest is on parent place
        if (largest != i) {
            int temp = table[i];
            table[i] = table[largest];
            table[largest] = temp;

            //run again parent child check
            heapify(table, size, largest);
        }


    }

    static void insert(int[] table, int size, int element) {
        int newSize = size + 1;
        int[] newTable = new int[newSize];
        System.arraycopy(table, 0, newTable, 0, size);
        newTable[size] = element;
        for (int i = newSize / 2 - 1; i >= 0; i--) {
            heapify(newTable, newSize, i);
        }

        System.out.println(Arrays.toString(newTable));
    }

    static void delete(int[] table, int size, int element) {
        int newSize = size - 1;
        int[] newTable = new int[newSize];
        Optional<Integer> index = Arrays.stream(table).filter(i->i==element).mapToObj(i-> table[i]).findFirst();



        if (index.isPresent()) {
            int temp = table[index.get()];
            table[index.get()] = table[size - 1];
            table[size - 1] = temp;
        }


        System.arraycopy(table,0,newTable,0,newSize);

        for (int i = newSize / 2 - 1; i >= 0; i--) {
            heapify(newTable, newSize, i);
        }

        System.out.println(Arrays.toString(newTable));
    }

    static int getHeight(int size) {
        int i = 0;
        for (; i < size; i++) {
            if (Math.pow(2, i) > size) {
                break;
            }
        }
        return i;
    }


}
