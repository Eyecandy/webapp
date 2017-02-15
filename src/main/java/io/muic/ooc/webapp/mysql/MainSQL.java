package io.muic.ooc.webapp.mysql;

/**
 * Created by joakimnilfjord on 2/14/2017 AD.
 */
public class MainSQL {

    public static void main(String[] args) throws  Exception{
        MySql mySql = new MySql();
        //mySql.addUser("Hello","Password");
        //mySql.readData();
        mySql.displayUsers();

    }
}
