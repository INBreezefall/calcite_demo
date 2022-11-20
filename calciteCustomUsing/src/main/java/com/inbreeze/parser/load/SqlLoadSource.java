package com.inbreeze.parser.load;

import org.apache.calcite.sql.SqlIdentifier;

@SuppressWarnings("unused")
public class SqlLoadSource {
    private SqlIdentifier type;
    private String obj;

    public SqlLoadSource(SqlIdentifier type, String obj) {
        this.type = type;
        this.obj = obj;
    }

    public SqlIdentifier getType() {
        return type;
    }

    public void setType(SqlIdentifier type) {
        this.type = type;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
