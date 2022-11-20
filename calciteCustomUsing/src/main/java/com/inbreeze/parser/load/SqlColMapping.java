package com.inbreeze.parser.load;

import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParserPos;

import java.util.List;

@SuppressWarnings("unused")
public class SqlColMapping extends SqlCall {
    // 1.成员变量
    protected static final SqlOperator OPERATOR = new SqlSpecialOperator("SqlColMapping", SqlKind.OTHER);
    private SqlIdentifier fromCol;
    private SqlIdentifier toCol;

    // 2.构造器
    protected SqlColMapping(SqlParserPos pos) {
        super(pos);
    }

    public SqlColMapping(SqlParserPos pos, SqlIdentifier fromCol, SqlIdentifier toCol) {
        super(pos);
        this.fromCol = fromCol;
        this.toCol = toCol;
    }

    @Override
    public SqlOperator getOperator() {
        return null;
    }

    @Override
    public List<SqlNode> getOperandList() {
        return null;
    }

    public SqlIdentifier getFromCol() {
        return fromCol;
    }

    public void setFromCol(SqlIdentifier fromCol) {
        this.fromCol = fromCol;
    }

    public SqlIdentifier getToCol() {
        return toCol;
    }

    public void setToCol(SqlIdentifier toCol) {
        this.toCol = toCol;
    }

    @Override
    public void unparse(SqlWriter writer, int leftPrec, int rightPrec) {
        fromCol.unparse(writer, leftPrec, rightPrec);
        writer.print(" ");
        toCol.unparse(writer, leftPrec, rightPrec);
    }
}
