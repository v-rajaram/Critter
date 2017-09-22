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
		
		Scanner scan = new Scanner(new FileReader("./species/" + fileName));


		String commandString = "";
		String name = "";
		
		try {
			
			
			if(scan.hasNextLine()) {
				name = scan.nextLine();
			}
//			System.out.println(name);
			
			while(scan.hasNextLine()) {
				if(scan.nextLine().equals("\n"))
					break;
				commandString += scan.nextLine() + "%"; //Signifies Command endline
			}
			
			String [] commands = commandString.split("%");

			for(Object o: commands)
				System.out.println(o);
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

