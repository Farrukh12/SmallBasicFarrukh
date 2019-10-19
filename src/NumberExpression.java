public class NumberExpression implements ExpressionPM{
    private final double value;

    public NumberExpression(double value) {
        this.value = value;
    }

    @Override
    public double evalexp() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
