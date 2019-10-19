public class BinExpressionPM implements ExpressionPM {
    private final ExpressionPM expr1, expr2;
    private final char operation;
    public BinExpressionPM(char operation, ExpressionPM expr1, ExpressionPM expr2) {
        this.operation = operation;
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    @Override
    public String toString() {
        return String.format("%s %c %s", expr1, operation, expr2);
    }
    @Override
    public double evalexp() {
        switch (operation) {
            case '-': return expr1.evalexp() - expr2.evalexp();
            case '*': return expr1.evalexp() * expr2.evalexp();
            case '/': return expr1.evalexp() / expr2.evalexp();
            case '+':
            default:
                return expr1.evalexp() + expr2.evalexp();
        }
    }
}
