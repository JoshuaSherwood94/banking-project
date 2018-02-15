import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
	public static void main(String [] args) throws ClassNotFoundException {
		
		JFrame window= new JFrame("Banking System");
		window.setLayout(new GridLayout(4,4));
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu1 = new JMenu("Account");
		JMenu menu2 = new JMenu("Transactions");
		
		JMenuItem item1 = new JMenuItem ("Open");
		JMenuItem item2 = new JMenuItem ("Details");
		
		JMenuItem item3 = new JMenuItem ("Deposit");
		JMenuItem item4 = new JMenuItem ("Withdraw");
		JMenuItem item5 = new JMenuItem ("Balance");
		
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Open();
			}
		});
		
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Details();
			}
		});
		
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Deposit();
			}
		});
		
		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Withdraw();
			}
		});
		
		item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Balance();
			}
		});
		
		menu1.add(item1);
		menu1.add(item2);
		menu2.add(item3);
		menu2.add(item4);
		menu2.add(item5);
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		window.setJMenuBar(menuBar);
		window.setSize(500, 500);
		window.setVisible(true);
	}
}