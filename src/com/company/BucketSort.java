package com.company;

import java.util.*;


public class BucketSort {

    static void bucketSort(double[] table, int size) {

        if (size <= 1) {
            return;
        }

        int i;

        ArrayList<Double>[] bucket = new ArrayList[size];

        for (i = 0; i < size; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (i = 0; i < size; i++) {
            int bucketIndex = (int) (table[i] * size);
            bucket[bucketIndex].add(table[i]);
        }

        for (i = 0; i < size; i++) {
            bucket[i].sort(Comparator.naturalOrder());
        }

        int tableIndex=0;

        for (i = 0; i < size; i++) {
            if (!bucket[i].isEmpty()) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    table[tableIndex++] = bucket[i].get(j);
                }
            }

        }


    }
}
