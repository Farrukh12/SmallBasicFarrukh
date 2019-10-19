public class UnExpressionPM implements ExpressionPM{
    private final ExpressionPM expr1;
    private final char operation;

    public UnExpressionPM(char operation, ExpressionPM expr1) {
        this.operation = operation;
        this.expr1 = expr1;
    }

    @Override
    public double evalexp() {
        switch (operation) {
            case '-': return -expr1.evalexp();
            case '+':
            default:
                return expr1.evalexp();
        }
    }

    @Override
    public String toString() {
        return String.format("%c %s", operation, expr1);
    }
}
