/*
 * Dice Roller
 * 
 * This is a program that was originally intended to be the start of a character generator for the 
 * table top role playing game called Hackmaster. As it is right now it is a simple simulated dice 
 * roller. The user first inputs a custom roll according to the prompts on screen. The input is integers.
 * The program then goes on to decide character statistics. This is done via more prompts from the
 * program and integer input by the user.
 * 
 * As of right now there is no error catching, though the program function if the specified input it used.
 * 
 * By Joe Van Deusen
 */

import java.util.*;

public class Main {
	public static double str, dex, con, intel, wis, cha, com, hon;
	public static int answer;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int num=0, dice=0;
		System.out.println("Input number of rolls, space, dice type");
		num=console.nextInt();
		dice=console.nextInt();
		System.out.println("Your roll result is:" + roll(num,dice));
		System.out.println("Would you input your own stat rolls? Otherwise this will roll randomly.");
		System.out.println("0 for no, 1 for yes.");
		answer=console.nextInt();
		System.out.println("" + answer);
		if(answer==1){
			System.out.println("STR: ");
			str=console.nextDouble();
			System.out.println("DEX: ");
			dex=console.nextDouble();
			System.out.println("CON: ");
			con=console.nextDouble();
			System.out.println("INT: ");
			intel=console.nextDouble();
			System.out.println("WIS: ");
			wis=console.nextDouble();
			System.out.println("CHA: ");
			cha=console.nextDouble();
			System.out.println("COM: ");
			cha=console.nextDouble();
		}
		else if (answer==0){
			do{
				str=roll(3,6);
				dex=roll(3,6);	
				con=roll(3,6);	
				intel=roll(3,6);	
				wis=roll(3,6);	
				cha=roll(3,6);
				com=roll(3,6);
				System.out.println("Your stats are as follows: ");
				stats();
				System.out.println("\nWould you like to re-roll?");
				System.out.println("0 for no, 1 for yes.");
				answer=console.nextInt();
			}while(answer!=0);
		}
		else{
			System.out.println("You don't listen to instructions well, do you?");
			System.out.println("Sorry, the program will exit now.");
		}
		System.out.println("\nYour stats are as follows: ");
		stats();
	}
	
	//rolls dice for first int amount, with second int dice type
	public static int roll(int rolls, int dice) {
		int result=0;
		for (int i = 0; i < rolls; i++) {
			result+=(int)(Math.random()*dice+1);
		}
		return result;
	}
	public static void stats() {
		System.out.println("STR: " + str);
		System.out.println("DEX: " + dex);
		System.out.println("CON: " + con);
		System.out.println("INT: " + intel);
		System.out.println("WIS: " + wis);
		System.out.println("CHA: " + cha);
		System.out.println("COM: " + cha);
	}
}
