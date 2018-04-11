package utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnction {
	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String DB_URL="jdbc:mysql://localhost:3306/bookdb?useUnicode=true&characterEncoding=utf-8";
	public static final String DB_USER="root";
	public static final String DB_PWD="753951";
	
	private Connection mConnection=null;
	private Statement mStatement=null;
	private ResultSet mResultSet=null;
	
	//连接数据库
	public Connection getConnection() {
		try {
			Class.forName(DRIVER).newInstance();
			mConnection=DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
		} catch (Exception e) {
			e.printStackTrace();
			closeConnection();
		}
		
		return mConnection;
	}
	
	//执行查询语句
	public ResultSet executeQuery(String sql) {
		getConnection();
		
		if(mConnection!=null) {
			try {
				mStatement=mConnection.createStatement();
				mResultSet=mStatement.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
				closeConnection();
			}
		}
		
		return mResultSet;
	}
	
	//执行除查询外的语句
		public void executeOther(String sql) {
			getConnection();
			
			if(mConnection!=null) {
				try {
					mStatement=mConnection.createStatement();
					mStatement.execute(sql);
				} catch (SQLException e) {
					e.printStackTrace();
					closeConnection();
				}
			}
		}
		
		//关闭连接
		public void closeConnection() {
			try {
				if(mConnection!=null) {
					mConnection.close();
				}
				
				if(mStatement!=null) {
					mStatement.close();
				}
				
				if(mResultSet!=null) {
					mResultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
