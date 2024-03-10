import java.util.InputMismatchException;

public class MyScanner {
    private String str;
    private int position;

    public MyScanner(String str) {
        this.str = str;
        this.position = 0;
    }

    public String next() {
        if (position >= str.length()) {
            throw new InputMismatchException("No more tokens in the input string.");
        }

        int start = position;
        while (position < str.length() && !Character.isWhitespace(str.charAt(position))) {
            position++;
        }
        return str.substring(start, position);
    }

    public int nextInt() {
        try {
            return Integer.parseInt(next());
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Token cannot be converted to an integer.");
        }
    }

    public double nextDouble() {
        try {
            return Double.parseDouble(next());
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Token cannot be converted to a double.");
        }
    }

    public boolean nextBoolean() {
        String token = next().toLowerCase();
        if (token.equals("true")) {
            return true;
        } else if (token.equals("false")) {
            return false;
        } else {
            throw new InputMismatchException("Token cannot be converted to a boolean.");
        }
    }

    public String nextLine() {
        int start = position;
        while (position < str.length() && str.charAt(position) != '\n') {
            position++;
        }
        return str.substring(start, position);
    }
}
