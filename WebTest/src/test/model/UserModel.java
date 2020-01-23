package test.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import test.entity.User;

public class UserModel {
	public List<User> listUsers(DataSource datasource, HttpServletResponse response){
		List<User> ret = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connect = datasource.getConnection();
			
			String query = "select * from User";
			
			stmt = connect.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				ret.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("email")));
			}
		}
		catch(SQLException e) {
			try {
				response.getWriter().print("issue in sql connection.");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return ret;
	}
}
