/* 
 * Review:
 * 
 * A simple review of Java syntax.
 * First the program asks for distance in miles, then it is converted to km and displayed.
 * A simple greeting follows, demonstrating the function of a do-while loop.
 * 
 * By Joe Van Deusen
 */

import java.util.*;

public class review {
	public static void main(String[] args) {
		// declare the variable miles and km
		Scanner console = new Scanner(System.in);
		double miles = 0.0, km;
		//prompt user for input
		System.out.println("Enter the Distance in miles ");
		//user inputs data (check or runtime errors)
		try {
		miles = console.nextDouble();
		}
		catch (Exception e) {
			System.out.println("wrong input, so quitting");
			System.exit(1);
		}
		//convert miles to km
		km = miles * 8/5;
		//display the results
		System.out.println(miles + " Miles = " + km + " km");
		int _x = 5;
		do {
		  System.out.print("Hello");
		} while (_x < 5);
	}
}
