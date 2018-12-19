package com.dongshujin.leetcode;

import java.util.Stack;

public class Code20 {

    public static boolean isValid(String s) {
        if (null == s || s.length() == 1)
            return false;
        if (s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != '{')
                        return false;
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "[{]}";
        System.out.println(isValid(s1));

        String s2 = "]{]}";
        System.out.println(isValid(s2));

        String s3 = "(){}";
        System.out.println(isValid(s3));

        String s4 = "";
        System.out.println(isValid(s4));
    }

}
