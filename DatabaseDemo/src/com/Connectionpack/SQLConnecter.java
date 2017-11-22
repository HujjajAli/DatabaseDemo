package com.Connectionpack;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;



public class SQLConnecter {

	public SQLConnecter() 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");	
		JOptionPane.showMessageDialog(null, "DriverLoad Secceseful");
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "DriverLoad Not Secceseful");
		}
		
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdemo","root","");
			JOptionPane.showMessageDialog(null, "Connection Secceseful");
			int c = Integer.parseInt(JOptionPane.showInputDialog("What you want to do 1.INSERT DATA\n2.SEARCH DATA"));
			if(c==1)
			{
			  Statement stm = con.createStatement();
			  String insertQuery = "INSERT INTO student(SudentName,Cast,Address,Roll_No)values('Mohammad','Nizamani','Matli,Badin',156)";
			  int row = stm.executeUpdate(insertQuery);
			
			  if(row>0)
			  {
			 	JOptionPane.showMessageDialog(null, "INSERT Succesfully");
			  }
			  else{JOptionPane.showMessageDialog(null, "Failed to INSERT");}
			}
			else if(c==2)
			{
				Statement stm = con.createStatement();
				
				String slectQuery = "SELECT * FROM student";
				ResultSet rs = stm.executeQuery(slectQuery);
				
				while(rs.next())
				{
					String ID = rs.getString("id");
					String name = rs.getString("SudentName");
					String cast = rs.getString("Cast");
					String address = rs.getString("Address");
					int roll_No = rs.getInt("Roll_No");
					
					JOptionPane.showMessageDialog(null, "ID :"+ID+"\nName :"+name+"\nCast :"+cast+"\nAddress :"+address+"\nRoll_No :"+roll_No);
				}
			}
			else{JOptionPane.showMessageDialog(null, "Not Found");}
			
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Connection Not Secceseful");
		}
	}

	public static void main(String[] args)
	{
		new SQLConnecter();

	}

}
