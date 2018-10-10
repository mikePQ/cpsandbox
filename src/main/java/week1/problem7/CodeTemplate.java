package week1.problem7;

import mooc.EdxIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CodeTemplate {
    private static final String TEMPLATE_START = "%TEMPLATE-START%";
    private static final String TEMPLATE_END = "%TEMPLATE-END%";

    static int computeTotalTime(char[] text, Keyboard keyboard) {
        int time = 0;
        char lastChar = ' ';
        for (char character : text) {
            if (Character.isWhitespace(character)) {
                continue;
            }

            if (!Character.isWhitespace(lastChar)) {
                time += keyboard.distance(lastChar, character);
            }

            lastChar = character;
        }

        return time;
    }

    private static String readTemplate(EdxIO io) {
        StringBuilder sb = new StringBuilder();
        String current = null;
        while (!TEMPLATE_START.equals(current)) {
            current = io.next();
        }

        current = io.next();
        while (!TEMPLATE_END.equals(current)) {
            sb.append(current);
            current = io.next();
        }

        return sb.toString();
    }

    private static List<Symbol> readInput(EdxIO io, int x, int y) {
        List<Symbol> result = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Symbol symbol = new Symbol(i, j, io.nextChar());
                result.add(symbol);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            int width = io.nextInt();
            int height = io.nextInt();

            List<Symbol> symbols = readInput(io, width, height);
            Keyboard keyboard = new Keyboard(symbols);

            int minimalTime = Integer.MAX_VALUE;
            String languageWithMinimalTime = null;

            String language = io.next();
            while (language != null) {
                String template = readTemplate(io);
                int time = computeTotalTime(template.toCharArray(), keyboard);
                if (time < minimalTime) {
                    minimalTime = time;
                    languageWithMinimalTime = language;
                }

                language = io.next();
            }

            io.println(languageWithMinimalTime);
            io.println(minimalTime);
        }
    }

    static class Keyboard {
        private final Map<Character, Symbol> symbols;

        Keyboard(Iterable<Symbol> symbols) {
            this.symbols = StreamSupport
                    .stream(symbols.spliterator(), false)
                    .collect(Collectors.toMap(Symbol::getSymbol, Function.identity()));
        }

        int distance(char a, char b) {
            Symbol symbol1 = symbols.get(a);
            Symbol symbol2 = symbols.get(b);
            return symbol1.distance(symbol2);
        }
    }

    static class Symbol {
        private final int x;
        private final int y;
        private final char symbol;

        Symbol(int x, int y, char symbol) {
            this.x = x;
            this.y = y;
            this.symbol = symbol;
        }

        char getSymbol() {
            return symbol;
        }

        int distance(Symbol symbol) {
            return Math.max(Math.abs(x - symbol.x), Math.abs(y - symbol.y));
        }
    }
}
