package sample;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

public class MathEvaluate {
    ScriptEngineManager mgr;
    private int number;
    public String evaluate(String expressionString) throws ScriptException {
        mgr = new ScriptEngineManager();
        ScriptEngine jsEngine = mgr.getEngineByName("js");
        System.out.println(convertNumberFrom10to2System(String.valueOf(jsEngine.eval(expressionString))));
        return String.valueOf(jsEngine.eval(expressionString));
    }

    public String convertNumberFrom10to2System(String number){
        ArrayList<String> al = new ArrayList<>();
        this.number = Integer.parseInt(number);
        while(this.number>=1){

            al.add(0, String.valueOf(this.number%2));
            this.number = this.number/2;

        }
        StringBuilder sb = new StringBuilder();

        for(String i: al)
            sb.append(i);

        return sb.toString();
    }
}

