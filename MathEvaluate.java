package sample;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathEvaluate {
    ScriptEngineManager mgr;
    public String evaluate(String expressionString) throws ScriptException {
        mgr = new ScriptEngineManager();
        ScriptEngine jsEngine = mgr.getEngineByName("js");

        return String.valueOf(jsEngine.eval(expressionString));
    }
}

