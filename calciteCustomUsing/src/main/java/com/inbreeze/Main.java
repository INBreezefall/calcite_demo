package com.inbreeze;

import com.inbreeze.sql.parser.extend.SqlLoadExtendParserImpl;
import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

public class Main {
    public static void main(String[] args) throws SqlParseException {
        String sql = "LOAD hdfs:'/data/user/text' TO mysql:'db.t_user' (c1 c2, c3 c4)";

        SqlParser.Config config = SqlParser.config().withParserFactory(SqlLoadExtendParserImpl.FACTORY).withLex(Lex.MYSQL);
        SqlParser sqlParser = SqlParser.create(sql, config);
        SqlNode sqlNode = sqlParser.parseQuery();

        System.out.println(sqlNode);
    }

}
