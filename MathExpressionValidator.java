package sample;

import java.util.Stack;

class MathExpressionValidator {
    private StringBuilder buildNumber = new StringBuilder();
    private Stack<String> numbers = new Stack<>();
    private Stack<String> mathOperations = new Stack<>();
    private MathEvaluate result = new MathEvaluate();


    public String validate(String expression, String character) {
        StringBuilder sb = new StringBuilder();
        int expressionMathLength = expression.length();

        switch (character) {
            case "<":
                if (expression.length() == 1) {
                    sb.append(0);
                } else {
                    sb.append(deleteElementsFromString(expression));
                }
                break;
            case "C":
                sb.append("0");
                break;
            case "=":
                String resultString = String.valueOf(result.evaluate(expression));
                if (resultString.charAt(resultString.length() - 2) == '.' && resultString.charAt(resultString.length() - 1) == '0') {
                    sb.append(resultString, 0, resultString.length() - 2);
                } else {
                    sb.append(resultString);
                }
                break;
            case "x²":
                double powNumber = result.evaluate(expression);
                sb.append(powNumber * powNumber);
                break;
            case "√":
                double rootNumber = result.evaluate(expression);
                sb.append(nRoot(rootNumber, 2));
                System.out.println(expression);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                System.out.println(expression.charAt(expressionMathLength - 1));
                System.out.println(expression);
                if (isIntegerNumber(String.valueOf(expression.charAt(expressionMathLength - 1)))) {
                    sb.append(expression);
                    sb.append(" ");
                    sb.append(character);
                } else {
                    sb.append(deleteElementsFromString(expression));
                    sb.append(character);
                }
                sb.append(" ");
                break;
            default:
                if (expression.equals("0") && !character.equals(".")) {
                    sb.append(character);
                } else {
                    sb.append(expression + character);
                }
                break;
        }

        return sb.toString();
    }

    public double nRoot(double mathExpression, double root) {
        double rootResult = mathExpression;
        double tmp = Math.pow(rootResult, (root - 1));

        double calculationAccuracy = 0.000000000000001;

        while (Math.abs(mathExpression - tmp * rootResult) > calculationAccuracy) {
            rootResult = 1 / root * ((root - 1) * rootResult + (mathExpression / tmp));
            tmp = Math.pow(rootResult, root - 1);
        }

        return rootResult;
    }

    public String getSingleNumber(String character) {
        if (character.equals(".")) {
            if (isDoubleNumber(buildNumber.toString() + ".0")) {
                buildNumber.append(character);
            }
        } else {
            buildNumber.append(character);
        }
        return buildNumber.toString();
    }

    private String deleteElementsFromString(String mathExpression) {
        StringBuilder sb = new StringBuilder();
        int mathExpressionLength = mathExpression.length() - 1;
        if (!isIntegerNumber(String.valueOf(mathExpression.charAt(mathExpressionLength)))
                && !String.valueOf(mathExpression.charAt(mathExpressionLength)).equals(".")) {
            mathExpressionLength = mathExpressionLength - 1;
        }

        for (int i = 0; i < mathExpressionLength; i++) {
            sb.append(mathExpression.charAt(i));
        }

        return sb.toString();
    }

    private boolean isIntegerNumber(String stringOfNumber) {
        try {
            int number = Integer.parseInt(stringOfNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDoubleNumber(String stringOfNumber) {
        try {
            double number = Double.parseDouble(stringOfNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
