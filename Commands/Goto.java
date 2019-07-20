
public class Goto extends Excute {
    public Goto(String code) {
        super(code);
    }

    @Override
    public void evaluated(Interpreter interpreter){
     interpreter.goTo(Integer.parseInt(code));
    }
}
