import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

public class CalciteDirectUsingMain {
    public static void main(String[] args) throws SqlParseException {
        String sql = "select * from test where id = 1";
        SqlParser.Config config = SqlParser.config().withLex(Lex.MYSQL);
        SqlParser parser = SqlParser.create(sql, config);
        SqlNode sqlNode = parser.parseQuery();
        System.out.println(sqlNode);
    }
}
