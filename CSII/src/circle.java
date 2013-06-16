/* Assignment 2
 * User inputs the data for the center point and a point on the circle.
 * using different methods the program outputs 4 values:
 * radius, diameter, circumference, and area. 
 * There is no error handling in this version. 
 * The program will no function if the proper input is not filled.
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

public class circle extends JFrame {
	//declare variable
	double gui;
	EventHandler eventHandler;
	//declare GUI components
	JTextField FirstX, SecondX, FirstY, SecondY, RadiusTF, DiameterTF, CircumferenceTF, AreaTF;
	JButton Calculate;
	JLabel CenterX, CenterY, PointX, PointY, RadiusL, DiameterL, CircumferenceL, AreaL, Blank;
	Container c;
	//constructor
	public circle() {
		// create the components
		FirstX = new JTextField();
		FirstX.setEditable(true);
		SecondX = new JTextField();
		SecondX.setEditable(true);
		FirstY = new JTextField();
		FirstY.setEditable(true);
		SecondY = new JTextField();
		SecondY.setEditable(true);
		RadiusTF = new JTextField();
		RadiusTF.setEditable(true);
		DiameterTF = new JTextField();
		DiameterTF.setEditable(true);
		CircumferenceTF = new JTextField();
		CircumferenceTF.setEditable(true);
		AreaTF = new JTextField();
		AreaTF.setEditable(true);
		Calculate = new JButton("Calclate");
		CenterX = new JLabel ("Center X: ",JLabel.RIGHT);
		CenterY = new JLabel ("Center Y: ",JLabel.RIGHT);
		PointX = new JLabel ("Point X: ",JLabel.RIGHT);
		PointY = new JLabel ("Point Y: ",JLabel.RIGHT);
		RadiusL = new JLabel ("Radius: ",JLabel.RIGHT);
		DiameterL = new JLabel ("Diameter: ",JLabel.RIGHT);
		CircumferenceL = new JLabel ("Circumference: ",JLabel.RIGHT);
		AreaL = new JLabel ("Area: ",JLabel.RIGHT);
		Blank = new JLabel ("");
		
		// add the components
		c = getContentPane();
		c.setLayout(new GridLayout(9,2));
		c.add(CenterX);
		c.add(FirstX);
		c.add(CenterY);
		c.add(FirstY);
		c.add(PointX);
		c.add(SecondX);
		c.add(PointY);
		c.add(SecondY);
		c.add(RadiusL);
		c.add(RadiusTF);
		c.add(DiameterL);
		c.add(DiameterTF);
		c.add(CircumferenceL);
		c.add(CircumferenceTF);
		c.add(AreaL);
		c.add(AreaTF);
		c.add(Calculate);
		c.add(Blank);
		
		// register with the buttons
		eventHandler = new EventHandler();
		Calculate.addActionListener(eventHandler);
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
			double CenterX, CenterY, PointX, PointY, D, R, C, A;
			if (ae.getSource().equals(Calculate)) {
				CenterX = Double.parseDouble(FirstX.getText());
				CenterY = Double.parseDouble(FirstY.getText());
				PointX = Double.parseDouble(SecondX.getText());
				PointY = Double.parseDouble(SecondY.getText());
				
				R = Radius(CenterX, CenterY, PointX, PointY);
				D = Diameter(CenterX, CenterY, PointX, PointY);
				C = Circumference(CenterX, CenterY, PointX, PointY);
				A = Area(CenterX, CenterY, PointX, PointY);
				DecimalFormat formatDiameter = new DecimalFormat("#.##");
				RadiusTF.setText("" + formatDiameter.format(R));
				DiameterTF.setText("" + formatDiameter.format(D));
				CircumferenceTF.setText("" + formatDiameter.format(C));
				AreaTF.setText("" + formatDiameter.format(A));
			}
			else {
			}
		}
	}
	public double Radius(double CX, double CY, double PX, double PY)
	{
		double fin;
		fin = Math.sqrt(Math.pow((CX-PX),2)+Math.pow((CY-PY),2));
		return fin;
	}
	public double Diameter(double CX, double CY, double PX, double PY)
	{
		double fin;
		fin = Math.sqrt(Math.pow((CX-PX),2)+Math.pow((CY-PY),2))*2;
		return fin;
	}
	public double Circumference(double CX, double CY, double PX, double PY)
	{
		double fin;
		fin = Math.sqrt(Math.pow((CX-PX),2)+Math.pow((CY-PY),2));
		fin = 2*Math.PI*fin;
		return fin;
	}
	public double Area(double CX, double CY, double PX, double PY)
	{
		double fin;
		fin = Math.sqrt(Math.pow((CX-PX),2)+Math.pow((CY-PY),2));
		fin = Math.pow((Math.PI*fin),2);
		return fin;
	}
	public static void main(String[] args) {
		circle myApp = new circle();
	}
}