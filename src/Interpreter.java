import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Interpreter {
    private TreeMap<Integer, Excute> result = new TreeMap<>();
    private Map<String, Double> vars = new HashMap<>();
    private Integer numberofLine;

    public void runprogramm(String line) throws ScriptException {
        if (line.equalsIgnoreCase("RUN")) {
            this.run();
            return;
        }
        try {
            String[] lineofparts = line.split(" ");
            int numberofline = Integer.parseInt(lineofparts[0]);
            String exname = lineofparts[1];
            Excute excute=Excutecommand.createExecute(exname,line.substring(lineofparts[0].length()+lineofparts[1].length()+2));
            result.put(numberofline, excute);
        } catch (RuntimeException e) {
            System.err.println("Please write right expression!");
        }

    }

    public void run() throws ScriptException {
        numberofLine = result.firstKey();
        while (numberofLine != null) {
            Excute operator = result.get(numberofLine);
            operator.evaluated(this);
        }
    }
    public void next() {
        numberofLine = result.higherKey(numberofLine);
    }
    public void goTo(int line) { numberofLine = line; }
    public Map<String, Double> getvars() { return vars; }

}
