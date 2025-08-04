package linkedlist;

public class ReverseLastKNodes {
    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        Node node = new Node(10);
        customLinkedList.add(node);
        customLinkedList.add(new Node(20));
        customLinkedList.add(new Node(30));
        customLinkedList.add(new Node(40));
        customLinkedList.add(new Node(5));
        customLinkedList.add(new Node(6));
        customLinkedList.add(new Node(7));

        Node list2 = new Node(1);
        CustomLinkedList list = new CustomLinkedList();
        list.add(list2);
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(2));
        Node node1 = addTwoNumbers(node, list2);
        customLinkedList.print(node1);
    }

    private static Node addTwoNumbers(Node l1, Node l2) {
        Node templ1 = l1;
        Node templ2 = l2;
        int carry = 0;
        Node node  = null;
        Node lastNode  = null;
        while (templ2 != null || templ1 != null) {
            int num1 = 0;
            int num2 = 0;
            if(templ2 != null) {
                num2 = templ2.data;
                templ2 = templ2.next;
            }
            if(templ1 != null) {
                num1 = templ1.data;
                templ1 = templ1.next;
            }
            int total = num1 + num2 + carry;
            int numToAdd = total;
            if(total > 9) {
                int divider = 10;
                while ((total / divider) > 9) {
                    divider*=10;
                }
                carry= total / divider;
                numToAdd = total % divider;
            }
            if(node == null) {
                node = new Node(numToAdd);
                lastNode = node;
            }else {
                Node node1 = new Node(numToAdd);
                lastNode.next = node1;
                lastNode = node1;
            }
        }
        return node;
    }
}
