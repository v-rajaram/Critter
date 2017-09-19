package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class testLoadSpecies {
	
	
	public static void main (String args[]) throws FileNotFoundException {
		
		
		System.out.println("Enter in file pls");
		Scanner user = new Scanner(System.in);
		String fileName = user.nextLine();
<<<<<<< HEAD
		Scanner scan = new Scanner(new FileReader("\\species\\" + fileName));
=======
		
		Scanner scan = new Scanner(new FileReader("./species/" + fileName));
>>>>>>> 0800eb6d375cf16c7de33787f879a25532018a5d
		String commandString = "";
		String name = "";
		
		try {
			
			/**
			if(scan.hasNextLine() && !(scan.nextLine().charAt(0) == '\n')) {
				name = scan.nextLine();
			}
			
			while(scan.hasNextLine()) {
				commandString += scan.nextLine() + "%"; //Signifies Command endline
			}
			
			String [] commands = commandString.split("%");
			// Can you see this?
			System.out.println(commands);
			*/
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());//Signifies Command endline
			}
		}
		finally {
			user.close();
			scan.close();
		}
		
	}
	

}

