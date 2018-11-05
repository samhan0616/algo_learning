package leetcode;

import java.util.Stack;

/**
 * @author create by Xiao Han 10/20/18
 * @version 1.0
 * @since jdk 1.8
 */
public class ReversePolish {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
      if (token.matches("\\d*")) {
        stack.push(Integer.parseInt(token));
      } else {
        int b = stack.pop();
        int a = stack.pop();
        stack.push(operation(token, a, b));
      }
    }
    return stack.pop();
  }

  private int operation(String x, int a, int b) {
    switch(x) {
      case "+":
        return a + b;
      case "-":
        return a - b;
      case "*":
        return a * b;
      case "/":
        return a / b;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println("13".matches("\\d*"));
    String[] rpn = new String[]{"4","13","5","/","+"};
    new ReversePolish().evalRPN(rpn);
  }
}
