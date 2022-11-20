package com.inbreeze.parser.load;

import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParserPos;

import java.util.List;

@SuppressWarnings("unused")
public class SqlLoad extends SqlCall {
    // 1.成员变量 Load 结构内部包含的数据结构(类比 SqlSelect)
    private SqlLoadSource source;
    private SqlLoadSource target;
    private SqlNodeList colMapping;
    private String separator;

    // 2.构造器
    protected SqlLoad(SqlParserPos pos) {
        super(pos);
    }

    public SqlLoad(SqlParserPos pos, SqlLoadSource source, SqlLoadSource target, SqlNodeList colMapping, String separator) {
        super(pos);
        this.source = source;
        this.target = target;
        this.colMapping = colMapping;
        this.separator = separator;
    }

    // 3.实现方法
    @Override
    public SqlOperator getOperator() {
        return null;
    }

    @Override
    public List<SqlNode> getOperandList() {
        return null;
    }

    @Override
    public void unparse(SqlWriter writer, int leftPrec, int rightPrec) {
        writer.keyword("LOAD");

        source.getType().unparse(writer, leftPrec, rightPrec);

        writer.keyword(":");
        writer.print("'" + source.getObj() + "' ");
        writer.keyword("TO");

        target.getType().unparse(writer, leftPrec, rightPrec);

        writer.keyword(":");
        writer.print("'" + target.getObj() + "' ");

        final SqlWriter.Frame frame = writer.startList("(", ")");
        for (SqlNode sqlNode : colMapping) {
            writer.newlineAndIndent();
            writer.sep(",", false);
            sqlNode.unparse(writer, leftPrec, rightPrec);
        }
        writer.endList(frame);

        writer.keyword("SEPARATOR");
        writer.print("'" + separator + "'");

    }


    public SqlLoadSource getSource() {
        return source;
    }

    public void setSource(SqlLoadSource source) {
        this.source = source;
    }

    public SqlLoadSource getTarget() {
        return target;
    }

    public void setTarget(SqlLoadSource target) {
        this.target = target;
    }

    public SqlNodeList getColMapping() {
        return colMapping;
    }

    public void setColMapping(SqlNodeList colMapping) {
        this.colMapping = colMapping;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
