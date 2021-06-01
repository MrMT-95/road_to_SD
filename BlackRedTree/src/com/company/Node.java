package com.company;

public class Node {
    int value;
    String color;
    int position;

    public Node(int value, String color, int position) {
        this.value = value;
        this.color = color;
        this.position = position;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", color='" + color + '\'' +
                ", position=" + position +
                '}';
    }

    public boolean isLeft() {
        return position % 2 != 0;
    }
}
