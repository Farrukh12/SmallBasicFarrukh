import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String OPERATOR_CHARS = "+-*/()";
    private static final TokenType[] OPERATOR_TOKENS = {
            TokenType.Plus, TokenType.Minus,
            TokenType.Multiplication, TokenType.Division,
            TokenType.LPAREN, TokenType.RPAREN,
    };
    private  String input;
    private  int length;
    private List<Token> tokens;
    private int pos;
    public Line(String input) {
        this.input = input;
        length = input.length();
        tokens = new ArrayList<>();
    }
    public List<Token> tokenize() {
        while (pos < length) {
            final char current = peek(0);
            if (Character.isDigit(current)) tokenizeNumber();
            else if (current == '#') {
                next();
                tokenizeHexNumber();
            }
            else if (OPERATOR_CHARS.indexOf(current) != -1) {
                tokenizeOperator();
            } else {
                next();
            }
        }
        return tokens;
    }
    private void tokenizeNumber() {
        final StringBuilder buffer = new StringBuilder();
        char current = peek(0);
        while (Character.isDigit(current)) {
            buffer.append(current);
            current = next();
        }
        addToken(TokenType.Number, buffer.toString());
    }
    private void tokenizeHexNumber() {
        final StringBuilder buffer = new StringBuilder();
        char current = peek(0);
        while (Character.isDigit(current) || isHexNumber(current)) {
            buffer.append(current);
            current = next();
        }
        addToken(TokenType.Number, buffer.toString());
    }
    private static boolean isHexNumber(char current) {
        return "abcdef".indexOf(Character.toLowerCase(current)) != -1;
    }
    private void tokenizeOperator() {
        final int position = OPERATOR_CHARS.indexOf(peek(0));
        addToken(OPERATOR_TOKENS[position]);
        next();
    }
    private char next() {
        pos++;
        return peek(0);
    }
    private char peek(int relativePosition) {
        final int position = pos + relativePosition;
        if (position >= length) return '\0';
        return input.charAt(position);
    }
    private void addToken(TokenType type) {
        addToken(type, "");
    }
    private void addToken(TokenType type, String text) {
        tokens.add(new Token(type, text));
    }
}
