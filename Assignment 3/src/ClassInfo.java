/* Assignment 3 part 2
 * 
 * This program takes the values of students and their scores from a text file. This data is used
 * to determine who has a failing grade and who who as the highest score. These are then output to
 * to the user via console prompt.
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

import java.io.*;
import java.util.*;

public class ClassInfo {

	public static void main(String[] args) {
		//declare variables that includes
		final int MAX_SIZE = 50;
		String[] firstname = new String[MAX_SIZE];
		String[] lastname = new String[MAX_SIZE];
		int[] scores = new int[MAX_SIZE];
		int size = 0, highest;
		double sum = 0, average = 0;
		Scanner inFile = null;
		try {
			inFile = new Scanner(new FileReader("input.txt"));
		}
		catch(Exception e){
			System.exit(0);
		}
		while (inFile.hasNext()) {
			//try and read first name and assign to firstname[size]
			firstname[size] = inFile.next();
			// try and read last name and assign to lastname[size]
			lastname[size] = inFile.next();
			//try and read score and assign to scores[size]
			scores[size] = inFile.nextInt();
			size++;
		}
		
		//compute the sum of all scores using the following for loop
		for (int i=0; i < size; i++) {
			// add to sum, scores[i]
			sum += scores[i];
		}
		//average equals sum/size 
		average = sum/size;
		
		//compute highest score
		highest = scores[0]; // as a starting value
		for (int i=1; i < size; i++) {
			if(scores[i] > highest) {
				highest = scores[i];
			}
		}
		
		//list the student that are below average
		System.out.println("Students with below average score are:\n");
		for (int i=0; i<size; i++) {
			//if score[i] < average, println(firstname[i] +" "+lastname[i])
			if(scores[i] < average) {
				System.out.println(firstname[i] + " " + lastname[i]);
			}
		}
		System.out.println("");
		//list the students with highest score
		System.out.println("The Student with the highest score is:\n");
		for (int i=0; i<size; i++) {
			//if score[i] is highest, println(firstname[i] +" "+lastname[i])
			if(scores[i] == highest) {
				System.out.println(firstname[i] + " " + lastname[i]);
			}
		}
	}

}
