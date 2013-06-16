/* A utility class for sorting integers in an array
 * by Mahadev
 */

package my.util;

import java.util.Scanner;

public class ArraySort {
	//declare variables
	static final int MAXSIZE = 50; // max array size
	static final int LINESIZE = 10; // max numbers on a display line
	static final int MINVALUE = Integer.MIN_VALUE;

	//methods
	public static int[] getArrayOfNumbers() {
		int[] data = new int[MAXSIZE];
		for (int i=0; i<data.length; i++) {
			data[i] = MINVALUE;
		}
		int index = 0;
		// prompt user for data and store it
		System.out.println("Please enter up to "+MAXSIZE+" integers separated by spaces.\n" +
				"End the input with any letter" );
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			try {
				data[index] = input.nextInt();
				index++;
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Maximum is " + MAXSIZE);
				return data;
			}
			catch (Exception e) {
				System.out.println("Wrong input, so quitting");
				return null;
			}
		}
		return data;
	}

	public static int getArraySize(int[] array) {
		int size = 0;
		try {
			while (array[size] != MINVALUE)
				size++;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return size;
		}
		return size;
	}

	public static void bubbleSort(int[] array, int size) {
		int temp;
		for (int i=size-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (array[j] > array[j+1]) {
					// swap the two values
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	public static void selectionSort(int[] array, int size) {
		int temp;
		for (int i = size-1; i>0; i--) {
			for (int j = 0; j<i; j++) {
				if (array[j] > array[i]) {
					// swap the two values
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		
	}

	public static void printArray(int[] array, int size) {
		for (int i=0; i<size; ) {
			System.out.printf("%5d", array[i]);
			i++;
			if (i%LINESIZE == 0 )
				System.out.println();
		}
		System.out.println();
	}
	
	public static int find(int[] array, int size, int key) {
		//array may not be sorted
		for (int i=0; i < size; i++) {
			if (array[i] == key) 
				return i;
		}
		return -1;
	}
	
	public static int removeAt(int[] array, int size, int index) {
		// removes the element at index
		if ((index > size-1) || (index < 0)) {
			System.out.println("Invalid index.  Nothing removed.");
			return size;
		}
		System.out.println("The number " + array[index] + " is successfully removed.");
		for (int i = index; i < size-1; i++) {
			array[i] = array[i+1];
		}
		return size-1;
	}
	
	public static int remove(int[] array, int size, int key) {
		int index = find(array, size, key);
		return removeAt(array, size, index);
	}
		
}




