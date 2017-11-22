package com.newTestExp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Sales 
{
	public static void main(String[] args)
	{
		Connection con;
		Statement stm = null;
		ArrayList o = new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(null, "Driver Loaded");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Driver Not Loaded");
			e.printStackTrace();
		}
		
		try {
			con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales","root","");
			JOptionPane.showMessageDialog(null, "Connection Stablished");
			 stm = con.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Not Stablished");
			e.printStackTrace();
		}
		
		String query = "SELECT 	costumer.ID,costumer.CosName , items.ItemName, items.cost  FROM costumer,items WHERE costumer.ID = sellerID ORDER BY costumer.ID";
		try {
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next())
			{
				String id = rs.getString(1);
				String cusName = rs.getString(2);
				String itemName = rs.getString(3);
				String cost = rs.getString(4);
				
				o.add(id);
				o.add(cusName);
				o.add(itemName);
				o.add(cost);
				System.out.println("Item Name: "+itemName+" \tSaller Name: "+cusName+"\tItem Price: $"+cost);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
