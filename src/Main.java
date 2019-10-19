import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ScriptException, IOException {
        BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Фаррух\\IdeaProjects\\SmallBasicFarrukh\\src\\program"));
        Interpreter interpreter = new Interpreter();
        while (true) {
            String line = file.readLine();
            if(line == null) break;
            interpreter.runprogramm(line);
        }
        interpreter.run();

        final String input1 = "2 + 2 * ( 3 + 4 ) / 7";
        final List<Token> tokens = new Line(input1).tokenize();
        for (Token token : tokens) {
            System.out.println(token);
        }

        final List<ExpressionPM> expressions = new Prover(tokens).parse();
        for (ExpressionPM expr : expressions) {
            System.out.println(expr + " = " + expr.evalexp());
        }
    }
}
