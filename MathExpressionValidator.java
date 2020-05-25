package sample;

import javax.script.ScriptException;

class MathExpressionValidator {


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
            case "=":
                MathEvaluate result = new MathEvaluate();
                try {
                    sb.append(result.evaluate(expression));
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (!isNumber(String.valueOf(expression.charAt(expressionMathLength - 1)))) {
                    sb.append(deleteElementsFromString(expression));
                    sb.append(" ");
                    sb.append(expression);
                } else {
                    sb.append(expression);
                    sb.append(" ");
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

    private String deleteElementsFromString(String mathExpression) {
        StringBuilder sb = new StringBuilder();
        int mathExpressionLength = mathExpression.length() - 1;
        if (!isNumber(String.valueOf(mathExpression.charAt(mathExpressionLength)))
                && !String.valueOf(mathExpression.charAt(mathExpressionLength)).equals(".")) {
            mathExpressionLength = mathExpressionLength - 1;
        }

        for (int i = 0; i < mathExpressionLength; i++) {
            sb.append(mathExpression.charAt(i));
        }

        return sb.toString();
    }

    private boolean isNumber(String stringOfNumber) {
        try {
            int number = Integer.parseInt(stringOfNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
