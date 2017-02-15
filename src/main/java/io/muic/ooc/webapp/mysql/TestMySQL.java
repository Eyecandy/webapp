package io.muic.ooc.webapp.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by joakimnilfjord on 2/14/2017 AD.
 */
public class TestMySQL {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","horde299");
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM users;");
            while (rs.next()){
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("password"));
                System.out.println(rs.getString("session") == null ? "NULL" : rs.getString("session"));
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
