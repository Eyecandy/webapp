package io.muic.ooc.webapp.mysql;


        import io.muic.ooc.webapp.service.Encryption;
        import org.apache.commons.lang.StringUtils;

        import java.sql.*;
        import java.util.ArrayList;

public class MySql{

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    String sql;


    public MySql() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","horde299");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }



    public void readData() throws Exception {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users");

        } finally {
            close();
        }
    }

    public ResultSet getResultSet() {
        return resultSet;
    }


    public boolean validateLogin(String username,String password) throws  Exception {
        resultSet =statement.executeQuery("select * from users");
        while (resultSet.next()) {
            String existingUserName = resultSet.getString("username");
            String existingPassword = resultSet.getString("password");
            if (existingUserName.equals(username) && Encryption.checkPassword(password, existingPassword)) {
                resultSet.beforeFirst();
                return true;
            }
        }
        resultSet.beforeFirst();
        return false;
    };

    public void editUser(String oldUserName,String newUserName) throws  Exception {
        String sql = "UPDATE test.users set username='"+newUserName+"' where username="+"'"+oldUserName+"'";
        System.out.println(sql);
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    public boolean addUser(String username, String password) throws Exception {
        String encryptedPassword = Encryption.hashPassword(password).toString();
        String sql = "insert into test.users values ('"+username+"','"+encryptedPassword+"','0')";

        preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        return true;
    }
    public void removeUser(String username) throws Exception{
        sql = "DELETE FROM test.users where username=" +"'"+username+"'";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }
    public ArrayList<String> displayUsers()  throws Exception{
        ArrayList<String> userNameLists= new ArrayList<>();
        while (resultSet.next()) {
            String existingUserName = resultSet.getString("username");
            userNameLists.add(existingUserName);
            System.out.println(resultSet.getString("username"));
            System.out.println();
        }
        return userNameLists;
    }

    public boolean checkIfUserExist(String username) throws  Exception{
        while (resultSet.next()) {
            String exisingUserName = resultSet.getString("username");

            if (StringUtils.equals(exisingUserName,username)) {
                resultSet.beforeFirst();
                System.out.println("Found" + username);
                return true;
            }
        }

        return false;
    }
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }
}
