package sample;

class MathExpressionValidator {
    public String validate(String expression, String character) {
        StringBuilder sb = new StringBuilder();
        int expressionMathLength = expression.length();
        if (character.equals("<")) {
            if (expression.length() == 1) {
                sb.append(0);
            } else {
                sb.append(deleteElementsFromString(expression));
            }
        } else if (expression.equals("0") && isNumber(character)) {
            sb.append(character);
        } else if (isNumber(character)) {
            if (!isNumber(String.valueOf(expression.charAt(expressionMathLength - 1)))) {
                sb.append(expression);
                sb.append(" ");
                sb.append(character);
            } else {
                sb.append(expression);
                sb.append(character);
            }
        } else if (expressionMathLength > 0) {
            if (!isNumber(String.valueOf(expression.charAt(expressionMathLength - 2)))) {
                sb.append(deleteElementsFromString(expression));

                sb.append(" ");
                sb.append(character);
            } else {
                sb.append(expression);
                sb.append(" ");
                sb.append(character);
            }
        }

        return sb.toString();
    }

    private String deleteElementsFromString(String mathExpression) {
        StringBuilder sb = new StringBuilder();
        int mathExpressionLength = mathExpression.length() - 1;
        if (!isNumber(String.valueOf(mathExpression.charAt(mathExpressionLength)))) {
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
