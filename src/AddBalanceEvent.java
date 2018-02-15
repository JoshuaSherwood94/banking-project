import java.awt.event.*;
import java.sql.*;

import javax.swing.JTextField;

public class AddBalanceEvent implements ActionListener{
public JTextField tt1, tt2, tt3, tt4;
public String accNum;
	
	public AddBalanceEvent(JTextField t1, JTextField t2, JTextField t3, JTextField t4) {
		tt1 = t1;
		tt2 = t2;
		tt3 = t3;
		tt4 = t4;
	}
	
	public void actionPerformed (ActionEvent x) {
		accNum = tt1.getText();

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
				tt2.setText(name);
				tt3.setText(add);
			}

			String Query2="select amount from transaction where accNo = '" + accNo+"'";
			ResultSet r2=Database.statement.executeQuery(Query2);
			int balance;
			if(r2.next()) { 
				balance = r2.getInt("amount");
				tt4.setText(Integer.toString(balance));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
