package io.muic.ooc.webapp.mysql;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
            String usernamefromDB=resultSet.getString("username");
            resulSetArray.add(usernamefromDB);

        }
        return resulSetArray;
    }
    public static HashSet<Object> getHashSet() throws  Exception {
        HashSet<Object> ok = new HashSet<>();
        ResultSet resultSet = getResultSet();
        while (resultSet.next()) {
            String usernamefromDB=resultSet.getString("username");
            ok.add(usernamefromDB);
        }
        return ok;
    }





}
