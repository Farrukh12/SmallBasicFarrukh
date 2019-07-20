import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Excutecommand {
    private static Map<String,Class> commands = new HashMap<>();
    static {
        commands.put("PRINT",Print.class);
        commands.put("If",If.class);
        commands.put("Int",Int.class);
        commands.put("Goto",Goto.class);
    }
    public static Excute createExecute(String opName, String substring) {
        Class<?> opClass = commands.get(opName);
        try {
            return (Excute) (opClass.getConstructor(String.class).newInstance(substring));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException();
        }

    }
}
