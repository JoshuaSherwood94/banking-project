import java.awt.event.*;

import javax.swing.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class AddOpenEvent implements ActionListener{
public String name, Add;
public JRadioButton sBut, cBut, mBut, fBut;
public JTextField tt1, tt2;
public String gender, account;


	public AddOpenEvent(JTextField t1, JTextField t2, JRadioButton saving, JRadioButton current, JRadioButton male, JRadioButton female) {
		tt1 = t1;
		tt2 = t2;
		sBut = saving;
		cBut = current;
		mBut = male;
		fBut = female;
	}
	
	public void actionPerformed (ActionEvent x) {

		name = tt1.getText();
		Add = tt2.getText();
		
		if(sBut.isSelected()){ 
	        account="S";
		}
		else if(cBut.isSelected()) {
	        account="C";
		}
		if(mBut.isSelected()){ 
	        gender="M";
		}
		else if(fBut.isSelected()) { 
	        gender="F";
		}
		
		try {
			String Query1="select concat('"+account+"','"+gender+"',COALESCE (lpad(MAX(SUBSTR(AccNo,3,3))+1,3,'0'),'001')) as ac From account Where SUBSTR(AccNo,1,1)='"+account+"'";
			ResultSet r=Database.statement.executeQuery(Query1);
			String NewAcno="";
				if(r.next()) { 
					NewAcno=r.getString(1);
				}
				
			String Query="insert into account values ('"+NewAcno+ "','" + name + "','" + Add + "')";
			Database.statement.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Your ID is: " + NewAcno);			
			
			//Adding person to Transaction table
			String Query2="insert into transaction values ('"+NewAcno+ "','"+0+"',CURDATE(),'"+account+"')";
			Database.statement.executeUpdate(Query2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

