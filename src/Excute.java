import javax.script.ScriptException;

public abstract class Excute {
    String code;

    public Excute(String code){
        this.code = code;
    }

    public abstract void evaluated(Interpreter interpreter) throws ScriptException;

    @Override
    public String toString(){
    return getClass().getSimpleName().toUpperCase() + " " + code;
    }
}
