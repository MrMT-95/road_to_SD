package com.company;

public class StackSort2 {
    public static void stackSort(int[] table, int size){
        Stack ascStack = new Stack(size);
        Stack descStack = new Stack(size);
        int i;

        ascStack.push(table[0]);

        for (i = 1; i < size; i++) {
            //check if descending stack contains
            if (!descStack.empty()) {
                while (table[i] > descStack.top()) {
                    ascStack.push(descStack.pop());
                    if (descStack.empty()) {
                        break;
                    }
                }
            }

            while (table[i] < ascStack.top()) {
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
