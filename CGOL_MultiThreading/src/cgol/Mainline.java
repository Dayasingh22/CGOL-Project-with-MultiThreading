package cgol;

import java.util.Scanner;

/**
 * 
 * Description : Program of CGOL which I made for the Project using Java
 * Multithreading
 * 
 * @author Dayanidhee Singh
 * 
 * @version 1.00 All rules of CGOL
 *
 */
public class Mainline {

	public static void main(String[] args) {
		//Taking the input from the User
		Scanner sc = new Scanner(System.in);
		
		//Variables row and column
		int r, c;
		char run;
		System.out.println("Enter the no of rows");
		//Taking the row from the user
		r = sc.nextInt();

		System.out.println("Enter the no of Columns");
		//Taking the column from the user
		c = sc.nextInt();
		
		//Declaring the Arrays which will store the intial CGOL
		int[][] arr = new int[r][c];

		System.out.println("Enter the CGOL:");
		System.out.println("Entry must be in 0 and 1, 0 for the dead cell and 1 for the alive cell");
		//Taking the user input for the initial generation
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//Making the object of first generation
		FirstGeneration fg = new FirstGeneration(r,c,arr);
		//Executing the thread
		fg.start();
		//Setting the priority so that the thread always gives output first
		fg.setPriority(8);
		
		//Calling the function and printing next life when user enter y
		do {
			//Making the object of Logic class
			LogicAndOutput lg = new LogicAndOutput(r,c,arr);
			//Executing the thread
			lg.start();
			//Setting the priority so that it always run after printing the generation
			lg.setPriority(2);
			//Asking the User to continue the game
			run = sc.next().charAt(0);
		} while (run == 'y');

		//When user enter any other character then y, loop stops and print below message
		System.out.println("Thank you for playing the game");
		sc.close();
	}

}
