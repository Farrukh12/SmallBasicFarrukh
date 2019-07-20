import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class If extends  Excute{
    public If(String code) {
        super(code);
    }
    @Override
    public void evaluated(Interpreter interpreter) {
        Pattern pattern = Pattern.compile("(.*) THEN GOTO (.*)");
        Matcher matcher = pattern.matcher(code);
        interpreter.next();
        String commandafterThen = matcher.group(1);
        int line = Integer.parseInt(matcher.group(2));
        try {
            Object res = Expresion.eval(interpreter.getvars(), commandafterThen.replace("=", "=="));
            if (res instanceof Boolean && res.equals(true))
                interpreter.goTo(line);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
