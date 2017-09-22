package assignment;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Responsible for loading critter species from text files and interpreting the
 * simple Critter language.
 * 
 * For more information on the purpose of the below two methods, see the
 * included API/ folder and the project description.
 */

public class Interpreter implements CritterInterpreter {

	public void executeCritter(Critter c) {
	
	
	
	return;
	
	}

	public CritterSpecies loadSpecies(String filename) throws IOException {
	// obviously, your code should do something
		System.out.println("Enter in file pls");
		Scanner user = new Scanner(System.in);
		String fileName = user.nextLine();
		Scanner scan = new Scanner(new FileReader("./species/" + fileName));
		String commandString = "";
		String name = "";
		LinkedList<String> commands = new LinkedList <String>();
		try {		
			
			if(scan.hasNextLine()) {
				name = scan.nextLine();
			}
			
			while(scan.hasNextLine()) {				
				String stored = scan.nextLine();
				if(stored.equals(""))
					break;
				commandString += stored + "%"; //Signifies Command endline
				//commands.add(stored);
			}
			
			String[] splitted = commandString.split("%");
			
			for(String str: splitted)
				System.out.println(str);
			
			//for(String str: commands)
				//System.out.println(str);		
		}
		
		finally {
			scan.close();
			
		}
		
		return new CritterSpecies(name, commands);
	}

}