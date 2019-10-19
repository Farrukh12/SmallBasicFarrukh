import java.util.ArrayList;
import java.util.List;

public class Prover {
    private static final Token EOF = new Token(TokenType.EQF, "");
    private final List<Token> tokens;
    private final int size;
    private int pos;

    public Prover(List<Token> tokens) {
        this.tokens = tokens;
        size = tokens.size();
    }

    public List<ExpressionPM> parse() {
        final List<ExpressionPM> result = new ArrayList<>();
        while (!match(TokenType.EQF)) {
            result.add(expression());
        }
        return result;
    }

    private ExpressionPM expression() {
        return additive();
    }

    private ExpressionPM additive() {
        ExpressionPM result = multiplicative();

        while (true) {
            if (match(TokenType.Plus)) {
                result = new BinExpressionPM('+', result, multiplicative());
                continue;
            }
            if (match(TokenType.Minus)) {
                result = new BinExpressionPM('-', result, multiplicative());
                continue;
            }
            break;
        }

        return result;
    }

    private ExpressionPM multiplicative() {
        ExpressionPM result = unary();

        while (true) {
            if (match(TokenType.Multiplication)) {
                result = new BinExpressionPM('*', result, unary());
                continue;
            }
            if (match(TokenType.Division)) {
                result = new BinExpressionPM('/', result, unary());
                continue;
            }
            break;
        }

        return result;
    }

    private ExpressionPM unary() {
        if (match(TokenType.Minus)) {
            return new UnExpressionPM('-', primary());
        }
        if (match(TokenType.Plus)) {
            return primary();
        }
        return primary();
    }

    private ExpressionPM primary() {
        final Token current = get(0);
        if (match(TokenType.Number)) {
            return new NumberExpression(Double.parseDouble(current.getText()));
        }

        if (match(TokenType.LPAREN)) {
            ExpressionPM result = expression();
            match(TokenType.RPAREN);
            return result;
        }
        throw new RuntimeException("Unknown expression");
    }

    private boolean match(TokenType type) {
        final Token current = get(0);
        if (type != current.getType()) return false;
        pos++;
        return true;
    }

    private Token get(int relativePosition) {
        final int position = pos + relativePosition;
        if (position >= size) return EOF;
        return tokens.get(position);
    }
}
