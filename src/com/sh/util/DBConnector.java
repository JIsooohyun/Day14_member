package com.sh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector { 
	
	public static Connection connect() throws Exception{//db연결
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@211.238.142.30:1521:xe";
		String dirver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(dirver);
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	public static void disconnect(PreparedStatement st, Connection conn) throws Exception{
		
		st.close();
		conn.close();
	}
	
	public static void disconnect(PreparedStatement st, Connection conn, ResultSet rs) throws Exception{
		rs.close();
		st.close();
		conn.close();
	}
	
}
