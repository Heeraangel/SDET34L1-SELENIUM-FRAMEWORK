package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.cj.jdbc.Driver;

public class DatabaseMethod {
	public static ArrayList<String> getDataFromDatabase(String url,String uname,String pwd,String query,int index) throws SQLException
	{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection connection=DriverManager.getConnection(url,uname,pwd);
	Statement statement=connection.createStatement();
	ResultSet result=statement.executeQuery(query);
	ArrayList<String> list=new ArrayList<>();
	while(result.next())
		list.add(result.getString(index));
	connection.close();
	return list;
	}
	public static void setDataFromDatabase(String url,String uname,String pwd,String query) throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection=DriverManager.getConnection(url,uname,pwd);
		Statement statement=connection.createStatement();
		int result = statement.executeUpdate(query);
		if(result>=1)
			System.out.println("Data entered/modified successfully");
		connection.close();
	}
}
