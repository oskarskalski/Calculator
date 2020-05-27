package sample;

class BtnSettings {
    public String[] getBtnNames(int index){
        String[][] btnNames = {
                {"MC", "M+", "M-", "MR", "C"},
                {"1", "2", "3", "/", "<"},
                {"4", "5", "6", "*", "%"},
                {"7", "8", "9", "-", "x²"},
                {"0", ".", "=", "+", "√"},
                {"A", "B", "C", "D", "E"},
        };

        String[] getBtnRow = btnNames[index];

        return getBtnRow;
    }
}
