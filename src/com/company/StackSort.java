package com.company;


import java.util.Stack;

public class StackSort {

    static void stackSort(int[] table, int size) {

        Stack<Integer> ascStack = new Stack<>();
        Stack<Integer> descStack = new Stack<>();
        int i;

        //first element to ascending stack = start point
        ascStack.push(table[0]);

        for (i = 1; i < size; i++) {
            //check if descending stack contains
            if (!descStack.empty()) {
                while (table[i] > descStack.peek()) {
                    ascStack.push(descStack.pop());
                    if (descStack.empty()) {
                        break;
                    }
                }
            }

            while (table[i] < ascStack.peek()) {
                descStack.push(ascStack.pop());
                if (ascStack.empty()) {
                    break;
                }
            }
            ascStack.push(table[i]);
        }

        //move all elements to descending stack
        for (i = 0; i < size; i++) {
            while (!ascStack.empty()) {
                descStack.push(ascStack.pop());
            }

            //move all sorted elements to table
            table[i] = descStack.pop();
            if (descStack.empty()) {
                break;
            }
        }


    }

}



