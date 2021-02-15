import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Parser {

    Map result;

    public Parser() {
        this.result = new HashMap<String, Integer>();
    }

    static final int START = 0;
    static final int KEYWORD = 1;
    static final int DIVIDER = 2;
    static final int END = 3;

    int state = START;
    private HashSet<Character> symbols /*= new HashSet<Character>()*/;

    public HashSet<Character> getSymbols() {
        return symbols;
    }

    public void setSymbols(HashSet<Character> symbols) {
        this.symbols = symbols;
    }

    public void read(String file) throws IOException {
        int symbol = 0;
        StringBuilder word = new StringBuilder();
        FileReader reader = new FileReader(file);
        while (state != END) {
            symbol = reader.read();
            switch (state) {
                case START:
                    if (symbols.contains((char) symbol)) {
                        state = DIVIDER;
                    } else if (symbol == -1) {
                        state = END;
                    } else {
                        state = KEYWORD;
                        word.append((char) symbol);
                    }

                    break;
                case KEYWORD:
                    if (symbols.contains((char) symbol)) {
                        addWord(word);
                        //System.out.println(word);
                        word.delete(0, word.length());
                        state = DIVIDER;
                    } else if (symbol == -1) {
                        state = END;
                        addWord(word);
                        //System.out.println(word);
                    } else {
                        word.append((char) symbol);
                    }

                    break;
                case DIVIDER:
                    if (symbols.contains((char) symbol)) {
                    } else if (symbol == -1) {
                        state = END;
                    } else {
                        state = KEYWORD;
                        word.append((char) symbol);
                    }


            }
        }
        result.entrySet().stream()
                .forEach(System.out::println);
    }

    void addWord(StringBuilder word) {
        if (result.containsKey(word.toString())) {
            result.put(word.toString(), (Integer) result.get(word.toString()) + 1);
        } else {
            result.put(word.toString(), 1);
        }
    }
}