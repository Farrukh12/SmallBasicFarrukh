import javax.script.ScriptException;

public class Int extends Excute {
    public Int(String code) {
        super(code);
    }

    @Override
    public void evaluated(Interpreter interpreter) throws ScriptException {
        String[] split = code.split("=");
        Object val = Expresion.eval(interpreter.getvars(),split[1]);
        interpreter.getvars().put(split[0].trim(),Double.parseDouble(val.toString()));
        interpreter.next();
        }
}
