import java.awt.*;
import javax.swing.*;

public class Balance {
	
	public Balance (){
		
	JFrame f = new JFrame();

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	
	f.setLayout(new GridLayout(6,2));
	
	JLabel l1 = new JLabel("Account No:");
	JLabel l2 = new JLabel("Name:");
	JLabel l3 = new JLabel("Address:");
	JLabel l4 = new JLabel("Current Balance:");

	JTextField t1 = new JTextField(25);
	JTextField t2 = new JTextField(25);
	JTextField t3 = new JTextField(25);
	JTextField t4 = new JTextField(25);

	JButton b1 = new JButton("SUBMIT");
    
    AddBalanceEvent e1 = new AddBalanceEvent (t1, t2, t3, t4);
    b1.addActionListener(e1);

	p1.add(l1);
	p1.add(t1);

	p2.add(l2);
	p2.add(t2);

	p3.add(l3);
	p3.add(t3);
	
	p4.add(l4);
	p4.add(t4);
	
	p1.add(b1);

	f.add(p1);
	f.add(p2);
	f.add(p3);
	f.add(p4);
	
	f.setSize(500, 500);
	f.setVisible(true);
	}
}
