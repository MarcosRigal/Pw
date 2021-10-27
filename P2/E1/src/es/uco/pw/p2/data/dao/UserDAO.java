package es.uco.pw.p2.data.dao;

import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import es.uco.pw.p2.business.UserDTO;
import es.uco.pw.p2.data.common.DBConnection;

/**
 * A DAO for users which makes use of a MySQL database connection via JDBC.
 * @author Aurora Ramirez
 * @author Jose Raul Romero
 * */

public class UserDAO {

	public ArrayList<UserDTO> requestUsersByAge(int age) {
		ArrayList<UserDTO> listOfUsers = new ArrayList<UserDTO>();
		try {
			DBConnection dbConnection = new DBConnection();
			Connection connection = dbConnection.getConnection();
			// Important: This query is hard-coded here for illustrative purposes only
			String query = "select * from User where age < " + age;
			
			// Important: We can replace this direct invocation to CRUD operations in DBConnection
			Statement stmt = connection.createStatement();
			ResultSet rs = (ResultSet) stmt.executeQuery(query);

			while (rs.next()) {
				String last = rs.getString("last");
				String first = rs.getString("first");
				int uAge = rs.getInt("age");
				listOfUsers.add(new UserDTO(last, first, uAge));
			}

			if (stmt != null){ 
				stmt.close(); 
			}
			dbConnection.closeConnection();
		} catch (Exception e){
			System.err.println(e);
			e.printStackTrace();
		}
		return listOfUsers;
	}
}