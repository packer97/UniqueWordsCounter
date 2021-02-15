import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://www.simbirsoft.com/";

        Downloader.DownloadWebPage(url);
        LocalDateTime t1 = LocalDateTime.now();
        Parser parser = new Parser();
        HashSet<Character> symbols = new HashSet<Character>();
        symbols.add('`');
        symbols.add('~');
        symbols.add('!');
        symbols.add('@');
        symbols.add('#');
        symbols.add('$');
        symbols.add('%');
        symbols.add('^');
        symbols.add('<');
        symbols.add('>');
        symbols.add(' ');
        symbols.add('&');
        symbols.add('*');
        symbols.add('(');
        symbols.add(')');
        symbols.add('-');
        symbols.add('_');
        symbols.add('–');
        symbols.add('—');
        symbols.add('/');
        symbols.add('|');
        symbols.add('\\');
        symbols.add('"');
        symbols.add('\'');
        symbols.add('+');
        symbols.add(',');
        symbols.add('.');
        symbols.add('[');
        symbols.add(']');
        symbols.add('{');
        symbols.add('}');
        symbols.add(':');
        symbols.add(';');
        symbols.add('?');
        symbols.add('\n');
        symbols.add('\r');
        symbols.add('\t');


        parser.setSymbols(symbols);
        parser.read("Download.html");
        LocalDateTime t2 = LocalDateTime.now();
        System.out.println(t1);
        System.out.println(t2);
    }
}
