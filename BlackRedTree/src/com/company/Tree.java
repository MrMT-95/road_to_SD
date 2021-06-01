package com.company;

import java.util.HashMap;

public class Tree {
    private static final String red = "Red";
    private static final String black = "Black";

    @Override
    public String toString() {
        return "Tree{" +
                "tree=" + tree +
                '}';
    }

    HashMap<Integer, Node> tree = new HashMap<>();

    public void add(int value) {
        if (tree.isEmpty()) {
            Node root = new Node(value, black, 0);
            tree.put(root.position, root);
        } else {
            addChild(value, 0);
        }

    }

    private void addChild(int value, int parentPosition) {
        if (value < tree.get(parentPosition).value) {
            int leftChild = 2 * parentPosition + 1;
            createNode(value, leftChild);
        } else {
            int rightChild = 2 * parentPosition + 2;
            createNode(value, rightChild);
        }
    }

    private void createNode(int value, int position) {
        if (tree.get(position) == null) {
            Node node = new Node(value, red, position);
            tree.put(position, node);
        } else {
            addChild(value, position);
        }
    }

    private void standardize(Node node) {
        //parent and uncle are red
        Node parent = getParent(node.position);
        Node uncle = getSibling(parent.position);
        if (parent.color.equals(red) && uncle.color.equals(red)) {
            parent.setColor(black);
            uncle.setColor(black);
            Node grandParent = getParent(parent.position);
            grandParent.setColor(red);
            standardize(grandParent);
        }

        if (parent.color.equals(red) && uncle.color.equals(black)) {
            if ((node.isLeft() && !parent.isLeft()) || (!node.isLeft() && parent.isLeft())) {

            }
        }
    }

    private Node getParent(int position) {
        if (isRoot(position)) {
            return tree.get(0);
        }

        if (position % 2 != 0) {
            return tree.get((position - 1) / 2);
        } else {
            return tree.get((position - 2) / 2);
        }
    }

    private Node getSibling(int position) {
        if (isRoot(position)) {
            return tree.get(0);
        }

        if (position % 2 != 0) {
            return tree.get(position + 1);
        } else {
            return tree.get(position - 1);
        }
    }

    private boolean isRoot(int position) {
        return position == 0;
    }

    private void llc() {

    }


}
