package sample;

class MathExpressionValidator {
    public String validate(String expression, String character) {
        StringBuilder sb = new StringBuilder();
        int expressionMathLength = expression.length();

        if(expression.equals("0") && isNumber(character)){
            sb.append(character);
        }else if (isNumber(character)) {
            if (!isNumber(String.valueOf(expression.charAt(expressionMathLength - 1)))) {
                sb.append(expression);
                sb.append(" ");
                sb.append(character);
            }else{
                sb.append(expression);
                sb.append(character);
            }
        } else if (expressionMathLength > 0) {
            if (!isNumber(String.valueOf(expression.charAt(expressionMathLength - 2)))) {
                for (int i = 0; i < expressionMathLength - 2; i++) {
                    sb.append(expression.charAt(i));
                }
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

    private boolean isNumber(String stringOfNumber) {
        try {
            int number = Integer.parseInt(stringOfNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
