package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeExample {

    public static void main(String[] args) {
        int[] data = {1,2,3,-1,-1,2,-1,-1,4,5,-1,-1,6,1,9,-1,-1, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node node = tree.buildTree(data);
        preorder(node);
        System.out.println();
        postorder(node);
        System.out.println();
        inorder(node);
        System.out.println();
        levelorder(node);
        System.out.println();
        System.out.println("count of total nodes : " + countOfNodes(node));
        System.out.println("count of total nodes : " + countOfNodesUsingRecursion(node));
        System.out.println("height of tree : " + height(node));
        System.out.println("diameter of a tree : " + diameter(node).diameter);

    }

    private static NodeInfo diameter(Node node) {
        if(node == null) return new NodeInfo(0,0);
        NodeInfo leftNodeInfo = diameter(node.left);
        NodeInfo rightNodeInfo = diameter(node.right);
        int leftD = leftNodeInfo.diameter;
        int rightD = rightNodeInfo.diameter;
        int rootD = leftNodeInfo.height + rightNodeInfo.height + 1;
        NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.height = Math.max(leftNodeInfo.height, rightNodeInfo.height) + 1;
        nodeInfo.diameter = Math.max(rootD, Math.max(leftD, rightD));
        return nodeInfo;
    }
    static class NodeInfo {
        int height;
        int diameter;
        public NodeInfo(){}
        public NodeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    private static int height(Node node) {
        if(node == null) return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);
        return Math.max(lheight, rheight) + 1;
    }

    private static int countOfNodesUsingRecursion(Node node) {
        if(node == null) return 0;
        int lcount = countOfNodesUsingRecursion(node.left);
        int rcount = countOfNodesUsingRecursion(node.right);
        return lcount + rcount + 1;
    }
    private static int countOfNodes(Node node) {
        if(node == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int counter = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if(poll != null) {
                counter++;
                if(poll.right != null) queue.add(poll.right);
                if(poll.left != null) queue.add(poll.left);
            }
        }
        return counter;
    }

    private static void levelorder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if(poll == null){
                if(!queue.isEmpty()) queue.add(null);
                System.out.println();
                continue;
            }
            if(poll.left != null) {
                queue.add(poll.left);
            }
            if(poll.right != null) {
                queue.add(poll.right);
            }

            System.out.print(poll.data + " ");
        }
    }

    private static void inorder(Node node) {
        if(node == null)return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    private static void preorder(Node node) {
        if(node == null) return;
        System.out.print(node.data + " ");;
        preorder(node.left);
        preorder(node.right);
    }
}
class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class BinaryTree {
    private int idx = -1;
    public Node buildTree(int[] data) {
        idx++;
        if(data[idx] == -1) return null;
        Node node = new Node(data[idx]);
        node.left = buildTree(data);
        node.right = buildTree(data);
        return node;
    }
}