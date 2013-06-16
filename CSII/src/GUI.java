/*
 * Converter GUI:
 * 
 * A simple Distance Converter to and from Kilometers to Miles. This is done to become familiar with and
 * demonstrate the usage of GUI components of JFrame. The user enters a number above either Km or M and 
 * presses the corresponding button to see the conversion. No error handling was implemented in this version.
 * 
 * By Joe Van Deusen.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
	//declare variable
	double gui;
	EventHandler eventHandler;
	//declare GUI components
	JTextField kmTF, mTF;
	JButton right, left;
	JLabel kmL, mL, blank;
	Container c;
	//constructor
	public GUI() {
		// create the components
		kmTF = new JTextField();
		kmTF.setEditable(true);
		mTF = new JTextField();
		mTF.setEditable(true);
		right = new JButton("-->");
		left = new JButton("<--");
		kmL = new JLabel ("Km",JLabel.CENTER);
		mL = new JLabel ("M",JLabel.CENTER);
		blank = new JLabel ("");
		
		// add the components
		c = getContentPane();
		c.setLayout(new GridLayout(3,3));
		c.add(kmTF);
		c.add(right);
		c.add(mTF);
		c.add(kmL);
		c.add(left);
		c.add(mL);
		c.add(blank);
		c.add(blank);
		c.add(blank);
		
		// register with the buttons
		eventHandler = new EventHandler();
		right.addActionListener(eventHandler);
		left.addActionListener(eventHandler);
		// render window
		setTitle("Distance Converter");
		setSize(300,200);
		setLocation(0,0);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	// Event Listener class
	private class EventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			double km, m;
			if (ae.getSource().equals(right)) {
				km = Double.parseDouble(kmTF.getText());
				m = km * 8/5;
				mTF.setText("" + m);
				kmTF.setText("");
			}
			else {
				m = Double.parseDouble(mTF.getText());
				km = m * 5/8;
				kmTF.setText("" + km);
				mTF.setText("");
			}
		}
	}
	public static void main(String[] args) {
		GUI myApp = new GUI();
	}
}