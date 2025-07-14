package dsa;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    int total(Node node) {
        if(node == null) return 0;
        int sumL = total(node.left);
        int sumR = total(node.right);
        return sumL + sumR + node.data;
    }
    // Function to calculate height
    int height(Node node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Creating the tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.left = new Node(5);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.left.left = new Node(5);
        tree.root.left.right.left.right = new Node(5);
        tree.root.left.right.left.right.left = new Node(5);

        System.out.println("Height of tree is : " + tree.height(tree.root));
        System.out.println("Total of tree is : " + tree.total(tree.root));
    }
}
