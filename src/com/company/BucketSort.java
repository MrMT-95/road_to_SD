package com.company;

import java.util.*;


public class BucketSort {

    static void bucketSort(double[] table, int size) {

        //if worth check
        if (size <= 1) {
            return;
        }

        int i;

        //def bucket
        ArrayList<Double>[] bucket = new ArrayList[size];

        //create buckets
        for (i = 0; i < size; i++) {
            bucket[i] = new ArrayList<>();
        }

        //pop elements to buckets matching the range
        for (i = 0; i < size; i++) {
            int bucketIndex = (int) (table[i] * size);
            bucket[bucketIndex].add(table[i]);
        }

        //insertion sorting
        for (i = 0; i < size; i++) {
            bucket[i].sort(Comparator.naturalOrder());
        }

        int tableIndex=0;

        //transfer sorted elements from buckets to table
        for (i = 0; i < size; i++) {
            if (!bucket[i].isEmpty()) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    table[tableIndex++] = bucket[i].get(j);
                }
            }

        }


    }
}
