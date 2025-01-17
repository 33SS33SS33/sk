package TopInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;


class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evaluateReversePolishNotation(tokens));
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }

    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();

    // Ensure this only gets done once for ALL test cases.
    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!OPERATIONS.containsKey(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int number2 = stack.pop();
            int number1 = stack.pop();
            BiFunction<Integer, Integer, Integer> operation;
            operation = OPERATIONS.get(token);
            int result = operation.apply(number1, number2);
            stack.push(result);
        }
        return stack.pop();

    }

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * Note: Division between two integers should truncate toward zero.The given RPN expression is always valid.
     * That means the expression would always evaluate to a result and there won't be any divide by zero operation.
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     * Tags: Stack
     * 用堆栈处理  碰见数字就入栈 碰见符号就把栈里的元素弹出计算 然后结果入栈
     * 用字典表示了各种符号的操作 很巧妙
     * 对于除法的计算 要注意python会对1/-100这种除法返回-1 只有用1/int(float(-100))这样才行
     */
    public static int evaluateReversePolishNotation(String[] tokens) {
        int a, b;
        Stack<Integer> S = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    S.add(S.pop() + S.pop());
                    break;
                case "/":
                    b = S.pop();
                    a = S.pop();
                    S.add(a / b);
                    break;
                case "*":
                    S.add(S.pop() * S.pop());
                    break;
                case "-":
                    b = S.pop();
                    a = S.pop();
                    S.add(a - b);
                    break;
                default:
                    S.add(Integer.parseInt(s));
                    break;
            }
        }
        return S.pop();
    }
}
