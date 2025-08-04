package linkedlist;

public class CustomLinkedList {
    int length = 0;
    private Node root;
    private Node current;
    public CustomLinkedList() {

    }
    public void changeHead(Node node) {
        root = node;
    }
    public int size() {
        return length;
    }
    private void resetPrevNodes() {
        Node temp = root;
        temp.prev = null;
        while (temp!= null) {
            if(temp.next != null) {
                temp.next.prev = temp;
            }
            current = temp;
            temp = temp.next;
        }
    }
    public void reverseLastKNodes(int k) {
        if(k >= length) {
            reverse();
            return;
        }
        int count = 1;
        Node temp = current;
        while (count < k) {
            temp = temp.prev;
            count++;
        }
        Node kthNode = temp;
        temp.prev.next = reverse(kthNode);;
        resetPrevNodes();
    }

    private void reverse() {
        root = reverse(root);
        resetPrevNodes();
    }

    public Node reverse(Node head) {
        Node current = null;
        while (head!=null) {
            Node temp = head.next;
            head.next = current;
            current = head;
            head = temp;
        }
        return current;
    }
    public void printReverse() {
        Node temp = current;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }
    public void add(Node node) {
        if(root == null) {
            root = node;
            current = node;
            length++;
        }else {
            current.next = node;
            node.prev = current;
            current = node;

            length++;
        }
    }
    public void print(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public void print() {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
