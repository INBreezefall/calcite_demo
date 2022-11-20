<#--
// Author: inbreeze
-->

// LOAD sourceType:obj TO targetType:obj (fromCol toCol (, fromCol toCol)*) [SPEARATOR '\t']
SqlNode SqlLoad() :
{
    SqlParserPos pos;
    SqlIdentifier sourceType;
    String sourceObj;
    SqlIdentifier targetType;
    String targetObj;
    SqlParserPos mapPos;
    SqlNodeList colMapping;
    String separator = "\t";
}
{
    <LOAD>                              // LOAD
    {
        pos = getPos();
    }
    sourceType = CompoundIdentifier()   // sourceType
    <COLON>                             // :
    sourceObj = StringLiteralValue()    // obj
    <TO>                                // TO
    targetType = CompoundIdentifier()   // targetType
    <COLON>                             // :
    targetObj = StringLiteralValue()   // obj
    {
        mapPos = getPos();
    }
    <LPAREN>                            // (
    {
        colMapping = new SqlNodeList(mapPos);
        colMapping.add(readOneColMapping());
    }
    (
        <COMMA>                         // ,
        {
            colMapping.add(readOneColMapping());
        }
    )*
    <RPAREN>
    [<SEPARATOR> separator = StringLiteralValue()]

    {
        return new SqlLoad(pos, new SqlLoadSource(sourceType, sourceObj), new SqlLoadSource(targetType, targetObj), colMapping, separator);
    }
}

JAVACODE String StringLiteralValue() {
    SqlNode sqlNode = StringLiteral();
    return ((NlsString) SqlLiteral.value(sqlNode)).getValue();
}

SqlNode readOneColMapping() :
{
    SqlIdentifier fromCol;
    SqlIdentifier toCol;
    SqlParserPos pos;
}
{
    {
        pos = getPos();
    }
    fromCol = SimpleIdentifier()
    toCol = SimpleIdentifier()
    {
        return new SqlColMapping(pos, fromCol, toCol);
    }
}