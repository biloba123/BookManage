package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Manager;
import utils.DbConnction;

public class ManagerDAO {
	public boolean check(String username, String password) {
		DbConnction connction=new DbConnction();
		String sql="select * from manager where username=\""+
				username+"\" and password=\""+password+"\"";
		ResultSet resultSet=connction.executeQuery(sql);
		
		try {
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			connction.closeConnection();
		}
		
		return false;
	}
}
