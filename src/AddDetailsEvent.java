import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class AddDetailsEvent implements ActionListener{
public JTextField tt1, tt2, tt3, tt4, tt5, tt6;
public String accNum;
	
	public AddDetailsEvent(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5,JTextField t6) {
		tt1 = t1;
		tt2 = t2;
		tt3 = t3;
		tt4 = t4;
		tt5 = t5;
		tt6 = t6;
	}
	
	public void actionPerformed (ActionEvent x) {
		accNum = tt6.getText();
		try {
			String Query1="select * from account where accNo = '"+accNum+"'";
			ResultSet r=Database.statement.executeQuery(Query1);
			String accNo="";
			String name="";
			String add="";
			if(r.next()) { 
				accNo=r.getString("accNo");
				name=r.getString("name");
				add=r.getString("address");
				tt1.setText(name);
				tt2.setText(add);
			}
			String Query2="select SUBSTR(AccNo,1,1) from account where accNo = '" + accNo+"'";
			ResultSet r2=Database.statement.executeQuery(Query2);
			String gender="";
			if(r2.next()) { 
				gender = r2.getString("SUBSTR(AccNo,1,1)");
				if (gender.equals("M")){
					gender = "Male";
				}
				else{
					gender = "Female";
				}
				tt4.setText(gender);
			}
			String Query3="select SUBSTR(AccNo,2,1) from account where accNo = '" + accNo+"'";
			ResultSet r3=Database.statement.executeQuery(Query3);
			String type="";
			if(r3.next()) { 
				type = r3.getString("SUBSTR(AccNo,2,1)");
				if (type.equals("C")){
					type = "Current Account";
				}
				else{
					type = "Savings Account";
				}
				tt3.setText(type);
			}
			String Query4="select amount from transaction where accNo = '" + accNo+"'";
			ResultSet r4=Database.statement.executeQuery(Query4);
			int balance;
			if(r4.next()) { 
				balance = r4.getInt("amount");
				tt5.setText(Integer.toString(balance));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
