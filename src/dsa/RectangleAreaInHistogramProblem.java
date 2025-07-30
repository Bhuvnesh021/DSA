package dsa;

import java.util.Stack;

public class RectangleAreaInHistogramProblem {
    public static void main(String[] args) {
        int[] arr = {0,0};
//        Stack<Integer> stack = new Stack<>();
        int[] stack = new int[arr.length + 1];
        int top = -1;
        int area = 0;
        for (int i = 0; i <= arr.length; i++) {
            int currentHeight = i == arr.length ? 0 : arr[i];
//            int currentHeight = arr[i];

            while (top > -1 && currentHeight < arr[stack[top]]) {
                int height = arr[stack[top--]];
                int width ;
                if(top < 0) {
                    width = i;
                }else {
                    width = i - stack[top] - 1;
                }
                area = Math.max(area, height * width);
            }
            stack[++top] = i;
        }
        System.out.println(area);
    }

}
