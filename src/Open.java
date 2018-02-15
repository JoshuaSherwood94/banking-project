import java.awt.*;
import javax.swing.*;

public class Open {
	
	public Open (){
		
	JFrame f = new JFrame();

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	
	f.setLayout(new GridLayout(5,1));
	
	JLabel l1 = new JLabel("LAST NAME:");
	JLabel l2 = new JLabel("EMAIL:");

	JTextField t1 = new JTextField(25);
	JTextField t2 = new JTextField(25);

	JButton b1 = new JButton("SUBMIT");
	
    JRadioButton saving = new JRadioButton("Saving Account");
    saving.setSelected(true);

    JRadioButton current = new JRadioButton("Current Account");

    JRadioButton male = new JRadioButton("Male");
    male.setSelected(true);

    JRadioButton female = new JRadioButton("Female");

    ButtonGroup groupAccount = new ButtonGroup();
    groupAccount.add(saving);
    groupAccount.add(current);
    
    ButtonGroup groupGender = new ButtonGroup();
    groupGender.add(male);
    groupGender.add(female);

    AddOpenEvent e1 = new AddOpenEvent (t1, t2, saving, current, male, female);
    b1.addActionListener(e1);

	p1.add(l1);
	p1.add(t1);

	p2.add(l2);
	p2.add(t2);

	p3.add(saving);
	p3.add(current);
	
	p4.add(male);
	p4.add(female);
	
	p5.add(b1);

	f.add(p1);
	f.add(p2);
	f.add(p3);
	f.add(p4);
	f.add(p5);
	
	f.setSize(500, 500);
	f.setVisible(true);
	}
}
