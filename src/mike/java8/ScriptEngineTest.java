package mike.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by Devin on 8/17/2016.
 */
public class ScriptEngineTest {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        System.out.println(scriptEngine.getClass().getName());
        System.out.println("Result:" + scriptEngine.eval("function f(){return 1;} f()+1;"));
    }
}
