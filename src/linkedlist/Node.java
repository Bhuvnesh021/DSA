package linkedlist;

public class Node {
    Node next;
    Node prev;
    int data;

    public Node(Node next, Node prev, int data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }

    public Node(int data) {
        this.data = data;
    }
    public Node() {
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
