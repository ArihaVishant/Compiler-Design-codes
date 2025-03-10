import java.util.*;

public class Calculator {

    // Basic arithmetic operations
    public static double calculate(double a, double b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    // Evaluates a postfix expression
    public static double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.matches("[-+*/]")) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(calculate(a, b, token.charAt(0)));
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

    // Evaluates a prefix expression
    public static double evaluatePrefix(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (token.matches("[-+*/]")) {
                double a = stack.pop();
                double b = stack.pop();
                stack.push(calculate(a, b, token.charAt(0)));
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple Calculator");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        System.out.println("Result: " + calculate(num1, num2, operator));

        scanner.nextLine(); // Consume newline

        System.out.print("Enter a postfix expression: ");
        String postfixExp = scanner.nextLine();
        System.out.println("Postfix Evaluation Result: " + evaluatePostfix(postfixExp));

        System.out.print("Enter a prefix expression: ");
        String prefixExp = scanner.nextLine();
        System.out.println("Prefix Evaluation Result: " + evaluatePrefix(prefixExp));

        scanner.close();
    }
}
