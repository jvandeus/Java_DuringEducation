/* Assignment 1
 * 
 * This program calculates tha balance of an account after accumulating interest input by the user.
 * The user inputs the starting amount, the years that the interest is accumulating, and the 
 * amount of interest. The program them shows the user how much ends up in the account.
 * 
 * By Joe Van Deusen
 *
 * Time estimates
 *
 * Time    | Estimate | Actual
 * --------|----------|--------
 * Stage 1 |    5     |   5
 * --------|----------|--------
 * Stage 2 |   20     |   15
 * --------|----------|--------
 * Stage 3 |   20     |   25
 * --------|----------|--------
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class p350num7 extends JFrame {
	//declare variable
	double gui;
	EventHandler eventHandler;
	//declare GUI components
	JTextField depositTF, yearsTF, interestTF;
	JButton calculate;
	JLabel depositL, yearsL, interestL, result;
	Container c;
	//constructor
	public p350num7() {
		// create the components
		depositTF = new JTextField();
		depositTF.setEditable(true);
		yearsTF = new JTextField();
		yearsTF.setEditable(true);
		interestTF = new JTextField();
		interestTF.setEditable(true);
		calculate = new JButton("Calclate");
		depositL = new JLabel ("Amount Deposited:  ",JLabel.RIGHT);
		yearsL = new JLabel ("Years:  ",JLabel.RIGHT);
		interestL = new JLabel ("Interest:  ",JLabel.RIGHT);
		result = new JLabel ("Results Apear Here.",JLabel.CENTER);
		
		// add the components
		c = getContentPane();
		c.setLayout(new GridLayout(4,2));
		c.add(depositL);
		c.add(depositTF);
		c.add(yearsL);
		c.add(yearsTF);
		c.add(interestL);
		c.add(interestTF);
		c.add(calculate);
		c.add(result);
		
		// register with the buttons
		eventHandler = new EventHandler();
		calculate.addActionListener(eventHandler);
		// render window
		setTitle("Certificate of Deposit");
		setSize(300,200);
		setLocation(0,0);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	// Event Listener class
	private class EventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			double deposit, years, interest, fin;
			if (ae.getSource().equals(calculate)) {
				deposit = Double.parseDouble(depositTF.getText());
				years = Double.parseDouble(yearsTF.getText());
				interest = Double.parseDouble(interestTF.getText());
				
				fin = Math.pow((1 + (interest/100)),years) * deposit;
				DecimalFormat formatresult = new DecimalFormat("#.##");
				result.setText("" + formatresult.format(fin));
			}
			else {
			}
		}
	}
	public static void main(String[] args) {
		p350num7 myApp = new p350num7();
	}
}