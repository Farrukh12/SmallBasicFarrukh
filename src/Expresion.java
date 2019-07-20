import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

public class Expresion {

    public static Object eval(Map<String, Double> vars, String str) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        for (String strs : vars.keySet()) {
            str = str.replace(strs, vars.get(strs).toString());
        }

        str = str.replace("SQRT", "Math.sqrt");
        return engine.eval(str);
    }
}
