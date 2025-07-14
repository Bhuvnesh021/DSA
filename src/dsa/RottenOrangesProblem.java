package dsa;

import models.Node;
import utility.Utility;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesProblem {
    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) {
        int[][] bucket = Utility.getBinaryArray(4,4);
        System.out.println("bucket length : " + bucket.length);
        assignOrangesToBucket(bucket);
        Queue<Node> linkedList = new LinkedList<Node>();
        prepareListOfRottenOranges(linkedList, bucket, -1);
        System.out.println(linkedList);
        int timeTaken = 0;
        while (!linkedList.isEmpty()) {
            Node node = linkedList.poll();
            rotTheOranges(node, bucket, linkedList);
            timeTaken = node.time;
        }
        if(stillHasFreshOranges(bucket)){
            System.out.println("total time taken : -1");
        } else  {
            System.out.println("total time taken : " + timeTaken);
        }
    }

    private static boolean stillHasFreshOranges(int[][] bucket) {
        for (int[] ints : bucket) {
            for (int i1 = 0; i1 < bucket[0].length; i1++) {
                if (ints[i1] == 1) return true;
            }
        }
        return false;
    }

    private static boolean isValidRowColumn(int row, int column, int[][] bucket) {
        return (row >= 0 && row < bucket.length) && (column >= 0 && column < bucket[0].length);
    }
    private static void rotTheOranges(Node node, int[][] bucket, Queue<Node> linkedList) {
        for (int[] direction : DIRECTIONS) {
            if(isValidRowColumn(node.row + direction[0] , node.column + direction[1], bucket) && bucket[node.row + direction[0]][node.column + direction[1]] == 1) {
                bucket[node.row + direction[0]][node.column + direction[1]] = 2;
                linkedList.add(new Node(node.time + 1, node.row + direction[0], node.column + direction[1]));
            }
        }
    }

    private static boolean rotTheOrange(int row, int column, int[][] bucket) {
        try {
            if (bucket[row][column] == 1) {
                bucket[row][column] = 2;
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    private static void prepareListOfRottenOranges(Queue<Node> linkedList, int[][] bucket, int currentTime) {
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[0].length; j++) {
                if (bucket[i][j] == 2) {
                    linkedList.add(new Node(currentTime + 1, i, j));
                }
            }
        }
    }

    private static void assignOrangesToBucket(int[][] bucket) {
        bucket[0][0] = 2;
        bucket[0][1] = 1;
        bucket[0][2] = 1;
        bucket[1][0] = 1;
        bucket[1][1] = 0;
        bucket[1][2] = 0;
        bucket[2][0] = 1;
        bucket[2][1] = 1;
        bucket[2][2] = 2;
//        bucket[2][4] = 1;
    }

}
