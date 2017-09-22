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
				String stored = scan.nextLine();
				if(stored.equals(""))
					break;
				commandString += stored + "%"; //Signifies Command endline
			}
			
			String [] commands = commandString.split("%");
			
			
			
		}
		finally {
			user.close();
			scan.close();
		}
		
	}
	

}

