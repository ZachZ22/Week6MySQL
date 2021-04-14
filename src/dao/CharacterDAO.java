package dao;

import entity.Character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.parser.DTDConstants.ID;

public class CharacterDAO {

    public static Character getCharacter(int id) throws SQLException {

        String sql = "SELECT character_name.ID, character_name.first_name, character_name.last_name,classes.name,races.race FROM character_name " +
                     "LEFT JOIN character_classes ON character_name.ID = character_classes.character_id LEFT JOIN classes ON character_classes.classes_id = classes.id " +
                     "LEFT JOIN races ON character_name.race_id = races.id " +
                     "WHERE character_name.ID = ? " +
                     //"WHERE character_name.ID = ? AND races.race = ? " +
                     "ORDER BY character_name.ID;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Character> charc = new ArrayList<>();


        try {
            connection = DbConnection.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            //statement.setString(2, "Human");
            rs = statement.executeQuery();

            while (rs.next()) {

                int characterID = rs.getInt(1);
                String firstName = rs.getString("first_name");
                String lasteName = rs.getString("last_name");
                String classss = rs.getString("name");
                String racee = rs.getString("race");
                Character characterOne = new Character(ID, firstName, lasteName, classss, racee);
                return(characterOne);
            }
            return null;

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

    public static List<Character> getAllCharacters() throws SQLException {


        String sql = "SELECT character_name.ID, character_name.first_name, character_name.last_name,classes.name,races.race FROM character_name LEFT JOIN character_classes ON character_name.ID = character_classes.character_id LEFT JOIN classes ON character_classes.classes_id = classes.id LEFT JOIN races ON character_name.race_id = races.id ORDER BY character_name.ID;";
        //String sql = "SELECT * FROM character_name, classes, races;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Character> charc = new ArrayList<>();


        try {
            connection = DbConnection.getInstance().getConnection();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();



            while (rs.next()){

                int characterID = rs.getInt(1);
                String firstName= rs.getString("first_name");
                String lasteName = rs.getString("last_name");
                String classss = rs.getString("name");
                String racee = rs.getString("race");
                //System.out.println("CharacterId:" +characterID);
                //System.out.println("firstName:" +firstName);
                //System.out.println("lasteName:" +lasteName);
                //System.out.println("classss:" +classss);
                //System.out.println("racee:" +racee);
                Character characterOne = new Character(ID, firstName,lasteName,classss,racee);
                charc.add(characterOne);

            }return charc;





        }finally {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }if(rs != null) {
                rs.close();
            }
        }






    }





}
