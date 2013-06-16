/* Assignment 4
 * 
 * First this program constructs an array of integers input by the user, ended by a non-integer input.
 * The program displays the array formed and prompts the user to remove one of the element of the array.
 * The program then takes the array of values, removes an element and then shortens the array.
 * 
 * by Joe Van Deusen
 * 
 * Time estimates
 *
 * Time    | Estimate | Actual
 * --------|----------|--------
 * Stage 1 |    5     |   5
 * --------|----------|--------
 * Stage 2 |   20     |   25
 * --------|----------|--------
 * Stage 3 |   20     |   30
 * --------|----------|--------
 */

import java.util.Scanner;

public class arrayEdit {
	//declare variables
	Scanner console = new Scanner(System.in);
	static final int MAXSIZE = 50; // max array size
	static final int LINESIZE = 10; // max numbers on a display line
	static final int MINVALUE = Integer.MIN_VALUE;
	
	//various methods used
	public static void printArray(int[] array, int size) {
		for (int i=0; i<size; ) {
			System.out.printf("%5d", array[i]);
			i++;
			if (i%LINESIZE == 0 )
				System.out.println();
		}
		System.out.println();
	}
	
	public static int getIndex(int[] array, int size, int item) {
		// this method searches for item in array and if found returns its index.  Otherwise returns -1
		for (int i=0; i<size; i++) {
			if (array[i] == item) {
				return i;
			}
		}
		return -1;
	}
	
	public static int removeAt(int[] array, int size, int index) {
		// removes from array whatever item is at given index and shifts remaining elements.
		// return the updated size
		if (index >= size) {
			System.out.println("Perimeter out of bound. Nothing was removed.");
			return size;
		}
		//otherwise shift elements to left from the cell whose item was removed
		for (int i = index; i<size-1; i++) {
			array[i] = array[i+1]; // value in cell i is overwritten by the value in cell i+1
		}
		return size-1;
	}
	
	public static int remove(int[] array, int size, int item) {
		//first find if the item is in the array by calling getIndex method
		int index = getIndex(array, size, item);
		if (index == -1) {
			System.out.println("Nothing was found. Nothing was removed.");
			return size; // without any changes to the size.
		}
		//otherwise call removeAt to remove that item and update the array and its size
		return removeAt(array, size, index);
	}


	public static void main(String[] args) {
		//declare variables
		int size = 0, item = 0;
		int[] array = new int[MAXSIZE];
		for (int i=0; i<array.length; i++) {
			array[i] = MINVALUE;
		}
		Scanner input = new Scanner(System.in);
		
		// prompt user get values for an array
		System.out.println("Please input the numbers in the array seperated by spaces.\n " +
				"End it with a non number character");
		while(input.hasNextInt()) {
			try{
				array[size] = input.nextInt();
				size++;
			}
			catch(Exception e){
				System.out.println("That did not work.");
			}
		}
		// print the array
		printArray(array, size);
		
		Scanner in = new Scanner(System.in);
		//prompt user for an integer to remove from
		System.out.println("Please input the integer you would like removed");
		//capture it as item.
		try{
			item = in.nextInt();
		}
		catch(Exception e){
			System.out.println("That is not an integer");
		}
		
		//call remove() method to remove that item.
		size = remove(array,size,item);
		
		//print the modified array
		printArray(array, size);		
	}

}
