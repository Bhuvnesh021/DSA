package dsa;

import java.util.Stack;

public class StringEvalProblem {
    public static void main(String[] args) {
        String str = "3+300*60/2+3";
        StringEvalProblem stringEvalProblem = new StringEvalProblem();
        int calculate = stringEvalProblem.calculate(str);
        System.out.println(calculate);

    }
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char lastOp = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (lastOp == '+') {
                    stack.push(num);
                } else if (lastOp == '-') {
                    stack.push(-num);
                } else if (lastOp == '*') {
                    stack.push(stack.pop() * num);
                } else if (lastOp == '/') {
                    stack.push(stack.pop() / num);
                }
                lastOp = ch;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

}

