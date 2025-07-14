package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeLeetCodeExample {

    public static void main(String[] args) {
        TreeNode treeNode =  new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(7);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        Solution solution = new Solution();
        List<Integer> integers = solution.inorderTraversal(treeNode);
        System.out.println(integers);

        TreeNode subTree = new TreeNode(2);
        subTree.left = new TreeNode(6);
        subTree.right = new TreeNode(7);
        System.out.println(isSubTree(treeNode, subTree));

    }

    private static boolean isSubTree(TreeNode mainTree, TreeNode subTree) {
        if(subTree == null) return true;
        if(mainTree == null) return false;

        if(isIdentical(mainTree, subTree)) return true;

        return isSubTree(mainTree.left,subTree) || isSubTree(mainTree.right, subTree);
    }

    private static boolean isIdentical(TreeNode mainTree, TreeNode subTree) {
        if(subTree == null && mainTree == null) return true;
        if(subTree == null || mainTree == null) return false;
        if(mainTree.val != subTree.val) return false;
        return isIdentical(mainTree.left, subTree.left) && isIdentical(mainTree.right, subTree.right);
    }

}
class Solution {
    private List<Integer> inorder(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        return inorder(root, list);
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }