import javax.script.ScriptException;

public class Print extends Excute {

    public Print(String str) {
        super(str);
    }

    @Override
    public void evaluated(Interpreter interpreter) {
        Object answer = null;
        interpreter.next();
        String line = code.trim();
        if (line.startsWith("\"")) {
            if (line.endsWith(";")) {
                System.out.print(line.substring(1, line.length() - 1));
            } else {
                System.out.println(line.substring(1, line.length() - 1));
            }
            return;
        }
        try {
            answer = Expresion.eval(interpreter.getvars(), code);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(answer);
    }
}
