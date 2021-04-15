package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CharacterName;

public class characterNameDAO {
	public void createCharacterName(String firstName, String lastName) throws SQLException {
		String sql = "INSERT INTO Character_Name (firstName, lastName) VALUES (?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.executeUpdate();

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null)
				connection.close();
		}
	}

	public static List<CharacterName> getCharacterName() throws SQLException {
		String sql = "SELECT * FROM Character_Name";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<CharacterName> characterNames = new ArrayList<>();

		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				long characterNameId = resultSet.getLong("character_Name_Id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				CharacterName characterName = new CharacterName(characterNameId, firstName, lastName);
				characterNames.add(characterName);
			}
			return characterNames;
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null)
				connection.close();
		}

	}

	public void updateCharacterName(String firstName, String lastName, long id) throws SQLException {
		String sql = "UPDATE Character_Name SET first_name = ? AND last_Name = ? WHERE Character_Name_Id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setLong(3, id);

			statement.executeUpdate();

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null)
				connection.close();
		}
	}

	public void deleteCharacterName(long characterNameId) throws SQLException {
		String sql = "DELETE FROM Character_Name WHERE Charcter_Name_ID = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, characterNameId);

			statement.executeUpdate();

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null)
				connection.close();
		}
	}
}
