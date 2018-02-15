import java.awt.event.*;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddWithdrawEvent implements ActionListener{
public JTextField tt1, tt2, tt3, tt4, tt5;
public String accNum;
public int balance;
public boolean on = false;
	
	public AddWithdrawEvent(JTextField t1, JTextField t2, JTextField t3, JTextField t4) {
		tt1 = t1;
		tt2 = t2;
		tt3 = t3;
		tt4 = t4;

	}
	public AddWithdrawEvent(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5) {
		tt1 = t1;
		tt2 = t2;
		tt3 = t3;
		tt4 = t4;
		tt5 = t5;
		on = true;
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
			if(r2.next()) { 
				balance = r2.getInt("amount");
				tt4.setText(Integer.toString(balance));
			}
			if(accNo != ""){
				if (on == true){
					int input = Integer.parseUnsignedInt(tt5.getText());
					if(input <= balance){
						balance = balance - input;
						String Query3="update transaction set amount = "+balance+" where accNo= '" + accNum +"'";
						Database.statement.executeUpdate(Query3);
						tt4.setText(Integer.toString(balance));
						tt5.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null, "You can only withdraw up to £" + balance);
						}
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please enter Your account ID");
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
