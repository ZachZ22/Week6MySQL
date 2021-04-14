package dao;

import entity.race;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class raceDao {




    //Create Race
     public void choseRace(String race) throws SQLException {

         String sql = "INSERT INTO races (race) VALUES (?)";
         Connection connection = null;
         PreparedStatement statement = null;

         try {
             connection = DbConnection.getInstance().getConnection();
             statement = connection.prepareStatement(sql);
             statement.setString(1, race);


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







        //Read race
        public List<race> getRaces() throws SQLException {
            String sql = "SELECT * FROM races";
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            List<race> races = new ArrayList<>();

            try {

                connection = DbConnection.getInstance().getConnection();
                statement = connection.prepareStatement(sql);
                rs = statement.executeQuery();

                while (rs.next()) {

                    long raceID = rs.getLong("ID");
                    String raceChoice = rs.getString("race");
                    race RACE = new race((int) raceID,raceChoice);
                    races.add(RACE);


                }
                return races;

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





        //Update Race

    public void updateRaces(long id, String race) throws SQLException{
        String sql = "Update races SET race = ? WHERE ID = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, race);
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


        //Delete Race

    public void deleteRace(long id) throws SQLException{
         String sql = "Delete from races WHERE ID = ?";
         Connection connection = null;
         PreparedStatement statement = null;

        try {
            connection = DbConnection.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);


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




