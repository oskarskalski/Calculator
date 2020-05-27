package sample;

import javax.script.ScriptException;

class FunctionBtnEventListener {
    private MathEvaluate evaluate = new MathEvaluate();
    private String saveNumberToMemory = "0";

    private String getSaveNumberToMemory() {
        return saveNumberToMemory;
    }

    private void setSaveNumberToMemory(String saveNumberToMemory) {
        this.saveNumberToMemory = String.valueOf(evaluate.evaluate(saveNumberToMemory));
    }

    public String functionBtnType(String type, String number) {
        switch (type) {
            case "M+":
                if (saveNumberToMemory.equals("0")) {
                    setSaveNumberToMemory(number);
                } else {
                    setSaveNumberToMemory(getSaveNumberToMemory() + " + " + number);
                }
                break;
            case "M-":
                if (saveNumberToMemory.equals("0")) {
                    setSaveNumberToMemory(number);
                } else {
                    setSaveNumberToMemory(getSaveNumberToMemory() + " - " + number);
                }
                break;
            case "MR":
                if (!saveNumberToMemory.equals("0"))
                    return getSaveNumberToMemory();
                break;
            case "MC":
                setSaveNumberToMemory("0");
                break;

        }
        return "";
    }
}
