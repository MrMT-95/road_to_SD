package com.company;

import java.util.EmptyStackException;

public class Stack {

    int size;
    int check = 0;
    int[] table;


    public Stack(int size) {
        this.size = size;
        table = new int[size];
    }

    boolean empty() {
        return check == 0;
    }

    int top() {
        if (check == 0) {
            throw new EmptyStackException();
        }
        return table[check - 1];

    }

    void push(int element) {
        if (check != size) {
            table[check] = element;
            check++;
        }
    }

    int pop() {
        int obj = top();
        int index = check -1;

        System.arraycopy(table,0,table,0,index);
        check--;
        return obj;
    }


}
