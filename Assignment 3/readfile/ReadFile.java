import java.io.*;
import java.util.*;
public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inFile = null;
		try {
			inFile = new Scanner(new FileReader("input.txt"));
		}
		catch(Exception e) {
			System.exit(0);
		}
		while (inFile.hasNext()){
			System.out.print(inFile.next() + " ");
			System.out.print(inFile.next() + " ");
			System.out.println(inFile.nextInt());
		}

	}

}
