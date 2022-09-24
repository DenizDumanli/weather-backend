//-----------------------------------------------------
// Title: Tester
// Author: Deniz Dumanlı
// ID: 25337236168
// Section: 1
// Description: This class is a tester class for our program.
//-----------------------------------------------------
package com.weather;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.List;
import java.util.Map;

public class Tester {
    public static void main(String[] args) throws JSQLParserException {
        // By calling those method we start the testing.
//        getUserandCreateTest();
//        deleteUserTest();
//        updateUserTest();
        ufuqi();

    }

    public static void ufuqi() throws JSQLParserException {
        String s = "Select * from ufuk as uf";
        Statement parse = CCJSqlParserUtil.parse(s);
        Select selectParse = (Select) parse;
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        List<String> tableList = tablesNamesFinder.getTableList(selectParse);
        Map<String, String> deniz = tablesNamesFinder.deniz(parse);
        System.out.println("stay");
    }

}
