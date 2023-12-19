package ru.mirea.kabo0222.hashtab;

public class Node {
    final String value;
    Node next;
    public Node(String value)
    {
        this.value = value;
        next = null;
    }

    @Override
    public java.lang.String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
