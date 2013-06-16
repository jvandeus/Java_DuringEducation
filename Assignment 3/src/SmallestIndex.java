/* Assignment 3 part 1
 * 
 * This program takes an array of values and prints it in order as well as
 * the index of the smallest integer. The first element in the array will
 * return as index of 1.
 * 
 * by Joe Van Deusen
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

import java.util.*;

public class SmallestIndex {
	//methods
	Scanner console = new Scanner(System.in);
	static final int MAXSIZE = 50; // max array size
	static final int LINESIZE = 10; // max numbers on a display line
	static final int MINVALUE = Integer.MIN_VALUE;

	//This method returns the index of the smallest value in the array of given size
	public static int smallestIndex (int[] array, int size) {
		//declare local variables
		int smallestIndex = 0;
		int smallestValue = array[0];
		for (int j=0; j < size; j++) {
			if(array[j] < smallestValue) {
				smallestIndex = j;
			}
		}
		return smallestIndex + 1;
	}
	
	//See ArraySort.java under code examples to see the following method
	public static void printArray(int[] array, int size) {
		for (int i=0; i<size; ) {
			System.out.printf("%5d", array[i]);
			i++;
			if (i%LINESIZE == 0 )
				System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// declare variables
		
		int index; // stores the value of smallest index
		int size = 0;
		int[] array = new int[MAXSIZE];
		for (int i=0; i<array.length; i++) {
			array[i] = MINVALUE;
		}
		Scanner input = new Scanner(System.in);
		
		//prompt user for size of the array
		System.out.println("Please enter the size of the array");
		size = input.nextInt();
		//then that many values to fill the array
		System.out.println("Please input the numbers in the array seperated by spaces,\n any extra will be ignored.");
		for(int a=0; a < size; a++) {
			array[a] = input.nextInt();
		}
				
		//print the array inputed by user
		printArray(array, size);
		
		//compute smallest index by calling the method you created above
		index = smallestIndex(array, size);
		System.out.println("The smallest index is " + index);
		
	}

}
