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
		
		LinkedList<String> commands = (LinkedList<String>) c.getCode();
		
		for(String str : commands) {
			String [] splitCommands = str.split(" ");
			switch (splitCommands[0]) {
				case "hop": ;
					break;
				case "left":  
	            		break;
	            case "right":  
	            		break;
	            case "infect":  
	            		break;
	            case "eat":  
	            		break;
	            case "go":  
	            		break;
	            case "ifrandom":  
	            		break;
	            case "ifempty":  
	            		break;
	            case "ifally":  
	            		break;
	            case "ifwall": 
	            		break;
	            	case "ifangle": 
	            		break;
	            	case "write": 
	            		break;
	            	case "add": 
	            		break;
	            	case "sub":
	            		break;
	            	case "inc":
	            		break;
	            	case "dec":
	            		break;
	            	case "iflt":
	            		break;
	            	case "ifreq":
	            		break;
	            	case "ifgt":
	            		break;
	            	default: 
                     break;
        }
			
			
			
			
			
		}
		
		
	
	
	
	return;
	
	}

	public CritterSpecies loadSpecies(String filename) throws IOException {
	// obviously, your code should do something
<<<<<<< HEAD
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
=======
		
//		System.out.println("Enter in file pls");
//		Scanner user = new Scanner(System.in);
//		String fileName = user.nextLine();
		Scanner scan = new Scanner(new FileReader("./species/" + filename));
		String name = "";
		LinkedList <String> commands = new LinkedList <String>();
		try {
			if(scan.hasNextLine() && !(scan.nextLine().charAt(0) == '\n')) {
				name = scan.nextLine();
			}
			
			while(scan.hasNextLine()) {
				String stored = scan.nextLine();
				if(stored.equals("")) {
					break;
				}
				commands.add(stored);
			}		
			for(String str: commands)
				System.out.println(str);
		}
		finally {
			scan.close();
		}
		return new CritterSpecies(name, commands);
	
>>>>>>> 539c6c4570cbc918cfb302df1002d550a12c8404
	}

}