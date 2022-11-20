import com.inbreeze.sql.parser.ParseException;
import com.inbreeze.sql.parser.SimpleSelectParser;

public class SimpleSelectMain {
    public static void main(String[] args) throws ParseException {
        SimpleSelectParser parser = new SimpleSelectParser("select 1 + 2 + 3 + 4");
        parser.parse();
    }
}
