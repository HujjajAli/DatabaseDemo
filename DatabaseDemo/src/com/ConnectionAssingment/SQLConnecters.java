package com.ConnectionAssingment;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;

public class SQLConnecters {

	Connection con;
	
	
	public SQLConnecters() 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		JOptionPane.showMessageDialog(null, "DriverLoad Succesful");
		}catch(Exception e)
		{
			e.printStackTrace();
		JOptionPane.showMessageDialog(null, "DriverLoad Not Succesful!");
		}
		
		
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdemo","root","");
			JOptionPane.showMessageDialog(null, "Connection  Succesful!");
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Connection Not Succesful!");
		}
	}

	

}
