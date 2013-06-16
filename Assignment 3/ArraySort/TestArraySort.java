/* Tests my.util.ArraySort methods
 * by Mahadev
 */

import my.util.ArraySort;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class TestArraySort {
	public static void main(String[] args) {
		// declare variables
		int[] data;
		int size;
		int key = 0;
		Scanner input;
		
		// prompt user for input and store
		data = ArraySort.getArrayOfNumbers();
		
		// get size of the array
		size = ArraySort.getArraySize(data);
		
		// display the array
		System.out.println("The numbers you gave are:");
		ArraySort.printArray(data, size);
		
		// sort the array
		ArraySort.bubbleSort(data, size);
		//ArraySort.selectionSort(data, size);
		
		// Ask user for a key to search for and remove it
		System.out.println("Please input an integer to search and delete from the data");
		input  = new Scanner(System.in);
		try {
			//key = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input an integer"));
			key = input.nextInt();
			System.out.println("The key to search and remove is " + key);
		}
		catch (Exception e) {
			System.out.println("You did not input an integer.  Good bye");
			e.printStackTrace();
			System.exit(1);
		}
		
		size = ArraySort.remove (data, size, key);
		
		// display the modified array
		System.out.println("The numbers in sorted order are:");
		ArraySort.printArray(data, size);
	}
}
