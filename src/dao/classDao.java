package dao;

import entity.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class classDao {
    public void createClass(String name) throws SQLException {

        String sql = "INSERT INTO classes (name) VALUES (?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);


            statement.executeUpdate();


        }finally {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }




    }


    public List<classes> getClasses() throws SQLException {
        String sql = "SELECT * FROM classes";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<classes> classes = new ArrayList<>();

        try {

            connection = DbConnection.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {

                long classID = rs.getLong("ID");
                String className = rs.getString("name");
                classes CLASS = new classes(classID, className);
                classes.add(CLASS);



            }
            return classes;

        } finally {

            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }






    public void updateClass(long id, String name) throws SQLException{
        String sql = "Update classes SET name = ? WHERE ID = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setLong(2, id);


            statement.executeUpdate();


        }finally {

            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }


    }




    public void deleteClass(long ID) throws SQLException{
        String sql = "Delete from classes WHERE ID = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, ID);


            statement.executeUpdate();


        }finally {

            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }

}
