package com.ConnectionAssingment;

import javax.swing.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Information 
{

		SQLConnecters sqlcon = new SQLConnecters();
		Statement stm;
		
		public static void main(String[] args) 
		{
			
			Information ob = new Information();
			int option = Integer.parseInt(JOptionPane.showInputDialog("Select Anyone Option\n1.INSERT DATA\n2.SEARCH DATA\n3.UPDATE DATA\n4.DELETE DATA"));
			
			if(option == 1)//INSERT DATA OPTION
			{	
			
			String name = JOptionPane.showInputDialog("Enter Student Name: ");
			String cast = JOptionPane.showInputDialog("Enter Student Cast: ");
			String address = JOptionPane.showInputDialog("Enter Student Address: ");
			int roll_No = Integer.parseInt(JOptionPane.showInputDialog("Enter Student Roll No: "));
			ob.insertData(name, cast, address, roll_No);
			}
			else if(option == 2)//SELECT DATA OPTION
			{
				int choice = Integer.parseInt(JOptionPane.showInputDialog("1.Show Full Data:\n2.Search By ID: "));
				if(choice == 1){ob.showData();}
				else if(choice == 2)
				{
					int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID: "));
					ob.showData(id);
				}else{JOptionPane.showMessageDialog(null,"Not Found!");}
			}
			else if(option == 3)//UPDATE DATA OPTION
			{
				int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID Which You Want To Update: "));
				String name = JOptionPane.showInputDialog("Enter Student Name: ");
				String cast = JOptionPane.showInputDialog("Enter Student Cast: ");
				String address = JOptionPane.showInputDialog("Enter Student Address: ");
				int roll_No = Integer.parseInt(JOptionPane.showInputDialog("Enter Student Roll No: "));
				ob.updateData(id, name, cast, address, roll_No);
				
			}
			else if(option == 4)//DELETE DATA OPTION
			{
				int choice = Integer.parseInt(JOptionPane.showInputDialog("1.DELETE BY ID\n2.DELETE ALL DATA"));
				
				if(choice == 1)
				{
					int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID Which You Want To Delete: "));
					ob.deleteData(id);
				}
				else if(choice == 2)
				{
					//yes == 0//no == 1// cancel == 2
					
					int data = JOptionPane.showConfirmDialog(null, "Are you sure you Want delete All data?");
					if(data == 0)
					{
						ob.deleteData();
					}
					else{JOptionPane.showMessageDialog(null, "Failed to Formate Data");}
					
				}
				else{JOptionPane.showMessageDialog(null, "Not Found!");}
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Not Found!");
			}
			
		}//Main Methode End
		
		
		
		
		public void insertData(String name,String cast,String address,int roll_No)
		{
			try {
				stm = sqlcon.con.createStatement();
				String insertQuery = "INSERT INTO student(SudentName,Cast,Address,Roll_No)values('"+name+"','"+cast+"','"+address+"','"+roll_No+"')";
				int row = stm.executeUpdate(insertQuery);
				
				if(row>0)
				{
					JOptionPane.showMessageDialog(null, "INSERT DATA Succesfully");
				}
				else{JOptionPane.showMessageDialog(null, "Failed to INSERT");}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			  
		}
		
		
		
		public void showData()//Full Table
		{
			try 
			{
				stm = sqlcon.con.createStatement();
				
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
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
		
		
		
		
		public void showData(int id)
		{
			try 
			{
				stm = sqlcon.con.createStatement();
				
				String slectQuery = "SELECT * FROM student where id='"+id+"'";
				ResultSet rs = stm.executeQuery(slectQuery);
				
				if(rs.next())
				{
					String ID = rs.getString("id");
					String name = rs.getString("SudentName");
					String cast = rs.getString("Cast");
					String address = rs.getString("Address");
					int roll_No = rs.getInt("Roll_No");
					
					JOptionPane.showMessageDialog(null, "ID :"+ID+"\nName :"+name+"\nCast :"+cast+"\nAddress :"+address+"\nRoll_No :"+roll_No);
				}
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
		}
		
		public void updateData(int id,String name,String cast,String address,int roll_No)
		{
			try{
				stm = sqlcon.con.createStatement();
				String updateQuery = "update student set SudentName='"+name+"',Cast='"+cast+"',Address='"+address+"',Roll_No='"+roll_No+"' where id="+id+"";
				int row = stm.executeUpdate(updateQuery);
				
				if(row>0)
				{
					JOptionPane.showMessageDialog(null, "UPDATE DATA Succesfully");
				}
				else{JOptionPane.showMessageDialog(null, "Failed to UPDATE");}
				
			}catch (SQLException e) 
			{
			
				e.printStackTrace();
			}
			
		}
		
		public void deleteData()//Delete All Recorde
		{
			try 
			{
				stm = sqlcon.con.createStatement();
				String deleteQuery = "DELETE FROM student";
				int row = stm.executeUpdate(deleteQuery);
				if(row>0)
				{
					JOptionPane.showMessageDialog(null, "Secussefully Data Formated  ");
				}
				else{JOptionPane.showMessageDialog(null, "Failed to Failed to Formate");}
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}	
		}
		
		public void deleteData(int id)//Delete By ID Function
		{
			try 
			{
				stm = sqlcon.con.createStatement();
				String deleteQuery = "DELETE FROM student WHERE id='"+id+"'";
				int row = stm.executeUpdate(deleteQuery);
				if(row>0)
				{
					JOptionPane.showMessageDialog(null, "Secussefully Delete Data of ID Number:  "+id);
				}
				else{JOptionPane.showMessageDialog(null, "Failed to Delete");}
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
		}
		
		
		

}


