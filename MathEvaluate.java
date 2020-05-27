package sample;

import java.util.Stack;

public class MathEvaluate {
    public double evaluate(String expressionString) {
        char[] tokens = expressionString.toCharArray();

        Stack<Double> numbers = new Stack<>();
        Stack<Character> mathOperations = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;

            if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.'))
                    sb.append(tokens[i++]);

                numbers.push(Double.parseDouble(sb.toString()));
            } else if (tokens[i] == '(')
                mathOperations.push(tokens[i]);
            else if (tokens[i] == ')') {
                while (mathOperations.peek() != '(')
                    numbers.push(applyOp(mathOperations.pop(), numbers.pop(), numbers.pop()));
                mathOperations.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '%') {
                while (!mathOperations.empty() && hasPrecedence(tokens[i], mathOperations.peek()))
                    numbers.push(applyOp(mathOperations.pop(), numbers.pop(), numbers.pop()));

                mathOperations.push(tokens[i]);
            }
        }
        while (!mathOperations.empty())
            numbers.push(applyOp(mathOperations.pop(), numbers.pop(), numbers.pop()));

        return numbers.pop();

    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-' || op2 == '%'))
            return false;
        else
            return true;
    }

    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '%':
                return a % b;
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}

