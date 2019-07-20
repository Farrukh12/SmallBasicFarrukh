import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScriptException, IOException {
        BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\FarrukhProger\\Desktop\\stepic_java_webserver-master\\SmallBasic\\src\\program"));
        Interpreter interpreter = new Interpreter();
        while (true) {
            String line = file.readLine();
            if(line == null) break;
            interpreter.find(line);
        }
        interpreter.run();
    }
}
