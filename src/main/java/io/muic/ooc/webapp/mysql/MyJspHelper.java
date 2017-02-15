package io.muic.ooc.webapp.mysql;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by joakimnilfjord on 2/14/2017 AD.
 */

public class MyJspHelper {
    public static ResultSet getResultSet() throws Exception {
        MySql mySql = new MySql();
        return mySql.getResultSet();

    }

    public static ArrayList<String> getResultSetAsArray() throws  Exception{
        ResultSet resultSet = getResultSet();
        ArrayList<String > resulSetArray = new ArrayList<>();

        while (resultSet.next()) {
            resulSetArray.add(resultSet.getString(1));
        }
        return resulSetArray;

    }

}
