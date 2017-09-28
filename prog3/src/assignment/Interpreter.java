package assignment;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		
		ArrayList<String> commands = (ArrayList<String>) c.getCode();
		
		//int numCommands = commands.size(); 
		
		if(c.getNextCodeLine() == 0) {
			c.setNextCodeLine(1);
		}
		
		//System.out.println(commands.size());
		
		for(int i = c.getNextCodeLine(); i <= commands.size(); i++) {
			String [] splitCommands = commands.get(c.getNextCodeLine()-1).split(" ");
			
			switch(splitCommands[0]) {
			case "hop":
				c.hop();
				c.setNextCodeLine(c.getNextCodeLine() + 1);
				//System.out.println("hip hop");
				//System.out.println(c.getNextCodeLine());
				return;
			case "left":
				c.left();
				c.setNextCodeLine(c.getNextCodeLine() + 1);
				//System.out.println("lefty loosey");
				//System.out.println(c.getNextCodeLine());
				return;
			case "right":
				c.right();
				c.setNextCodeLine(c.getNextCodeLine()+1);
				//System.out.println("righty tighty");
				//System.out.println(c.getNextCodeLine());
				return;
			case "eat":
				c.eat();
				c.setNextCodeLine(c.getNextCodeLine() + 1);
				return;
			case "infect":
				if(splitCommands.length == 1) {
					c.infect();
				}
				else {
					c.infect(Integer.parseInt(splitCommands[1]));
				}
				c.setNextCodeLine(c.getNextCodeLine() + 1);
				return;
			case "go":
				String goParam = splitCommands[1];
				if(goParam.charAt(0) == '+') {
					c.setNextCodeLine(Integer.parseInt(goParam.substring(1)) + c.getNextCodeLine());
					//System.out.println("go is being called.");
					//System.out.println(c.getNextCodeLine());
				}
				else if (goParam.charAt(0) == '-') {
					c.setNextCodeLine(c.getNextCodeLine() - Integer.parseInt(goParam.substring(1)));
					//System.out.println("go is being called.");
					//System.out.println(c.getNextCodeLine());
				}
				else if (goParam.charAt(0) == 'r') {
					int register = Integer.parseInt(goParam.substring(1));
					//System.out.println(register);
					//System.out.println("go is being called.");
					//System.out.println(c.getNextCodeLine());
					c.setNextCodeLine(c.getReg(register));
				}
				else {
					c.setNextCodeLine(Integer.parseInt(goParam.substring(0)));
					//System.out.println("go is being called.");
					//System.out.println(c.getNextCodeLine());
				}
				break;
			case "ifenemy":  
				//System.out.println("ifenemy called");
				int enemyBearing = Integer.parseInt(splitCommands[1]);
	        		int enemyInstructionNum = Integer.parseInt(splitCommands[2]);	
	            	if(c.getCellContent(enemyBearing)==Critter.ENEMY) {
	            		c.setNextCodeLine(enemyInstructionNum);
	            		//System.out.println("Enemy detected");
	            	}
	            	else {
	            		c.setNextCodeLine(c.getNextCodeLine() + 1);
	            	}
	            	break;
			case "ifally":  
				//System.out.println("ifally called");
				int allyBearing = Integer.parseInt(splitCommands[1]);
	        		int allyInstructionNum = Integer.parseInt(splitCommands[2]);	
	            	if(c.getCellContent(allyBearing)==Critter.ALLY) {
	            		c.setNextCodeLine(allyInstructionNum);
	            		//System.out.println("Ally detected");
	            	}
	            	else {
	            		c.setNextCodeLine(c.getNextCodeLine() + 1);
	            	}
	            	break;
			case "ifempty":
				//System.out.println("ifempty called");
				int emptyBearing = Integer.parseInt(splitCommands[1]);
				//System.out.println(emptyBearing);
				int emptyInstructionNum = Integer.parseInt(splitCommands[2]);
				if(c.getCellContent(emptyBearing)==Critter.EMPTY) {
					//System.out.println("Empty cell detected");
					c.setNextCodeLine(emptyInstructionNum);
					//System.out.println("Next Instruction: " + emptyInstructionNum);
				}
				else {
					c.setNextCodeLine(c.getNextCodeLine() + 1);
				}
				break;
			case "ifwall":
				//System.out.println("ifwall called");
				int wallBearing = Integer.parseInt(splitCommands[1]);
				//System.out.println(emptyBearing);
				int wallInstructionNum = Integer.parseInt(splitCommands[2]);
				if(c.getCellContent(wallBearing)==Critter.WALL) {
					//System.out.println("ouch!");
					c.setNextCodeLine(wallInstructionNum);
					//System.out.println("Next Instruction: " + wallInstructionNum);
				}
				else {
					c.setNextCodeLine(c.getNextCodeLine() + 1);
				}
				break;
			case "ifrandom":
				//System.out.println("ifrandom called");
				int randomInstructionNum = Integer.parseInt(splitCommands[1]);
				if(c.ifRandom()) {
					c.setNextCodeLine(randomInstructionNum);
				}
				else {
					c.setNextCodeLine(c.getNextCodeLine() + 1);
				}
				break;
			case "ifangle":
				//System.out.println("ifangle called");
				int angleBearing1 = Integer.parseInt(splitCommands[1]);
				int angleBearing2 = Integer.parseInt(splitCommands[2]);
				int angleInstructionNum = Integer.parseInt(splitCommands[3]);
				if(c.getOffAngle(angleBearing1)==angleBearing2)
					c.setNextCodeLine(angleInstructionNum);
				else {
					c.setNextCodeLine(c.getNextCodeLine() + 1);
				}
				break;
			case "write":
				int register = Integer.parseInt(splitCommands[1].substring(1));
				int value = Integer.parseInt(splitCommands[2]);
				c.setReg(register, value);
				//System.out.println(value + " written to " + register);
				c.setNextCodeLine(c.getNextCodeLine() + 1);
				break;
			case "add":
				//System.out.println(c.getReg(Integer.parseInt(splitCommands[1])));
				int addr1 = Integer.parseInt(splitCommands[1].substring(1));
				int addr2 = Integer.parseInt(splitCommands[2].substring(1));
				c.setReg(addr1, c.getReg(addr1) + c.getReg(addr2));
				//System.out.println(c.getReg(Integer.parseInt(splitCommands[1])));
				c.setNextCodeLine(c.getNextCodeLine() + 1);
				break;
			case "sub":
				int subr1 = Integer.parseInt(splitCommands[1].substring(1));
				int subr2 = Integer.parseInt(splitCommands[2].substring(1));
				c.setReg(subr1, c.getReg(subr1) - c.getReg(subr2));
				c.setNextCodeLine(c.getNextCodeLine() + 1);
				break;
			case "inc":
				c.setReg(Integer.parseInt(splitCommands[1].substring(1)), c.getReg(Integer.parseInt(splitCommands[1].substring(1)) + 1));
				c.setNextCodeLine(c.getNextCodeLine() + 1);
				break;
			case "dec":
				c.setReg(Integer.parseInt(splitCommands[1].substring(1)), c.getReg(Integer.parseInt(splitCommands[1].substring(1)) - 1));
				c.setNextCodeLine(c.getNextCodeLine() + 1);
				break;
			case "iflt":
				int lessr1 = Integer.parseInt(splitCommands[1].substring(1));
				int lessr2 = Integer.parseInt(splitCommands[2].substring(1));
				int lessInstructionNum = Integer.parseInt(splitCommands[3]);
				if(c.getReg(lessr1) < c.getReg(lessr2)) {
					c.setNextCodeLine(lessInstructionNum);
				}
				else {
					c.setNextCodeLine(c.getNextCodeLine() + 1);
				}
				break;
			case "ifeq":
				int equalr1 = Integer.parseInt(splitCommands[1].substring(1));
				int equalr2 = Integer.parseInt(splitCommands[2].substring(1));
				int equalInstructionNum = Integer.parseInt(splitCommands[3]);
				if(c.getReg(equalr1) == c.getReg(equalr2)) {
					c.setNextCodeLine(equalInstructionNum);
				}
				else {
					c.setNextCodeLine(c.getNextCodeLine() + 1);
				}
				break;
			case "ifgt":
					int greatr1 = Integer.parseInt(splitCommands[1].substring(1));
					int greatr2 = Integer.parseInt(splitCommands[2].substring(1));
					int greatInstructionName = Integer.parseInt(splitCommands[3]);
					if(c.getReg(greatr1) == c.getReg(greatr2)) {
						c.setNextCodeLine(greatInstructionName);
					}
					else {
						c.setNextCodeLine(c.getNextCodeLine() + 1);
					}
					break;
				
			default:
					break;
			}		
		}
	}


	public CritterSpecies loadSpecies(String filename) throws IOException {
	// obviously, your code should do something
		
//		System.out.println("Enter in file pls");
//		Scanner user = new Scanner(System.in);
//		String fileName = user.nextLine();
		Scanner scan = new Scanner(new FileReader(filename));
		String name = "";
		ArrayList <String> commands = new ArrayList <String>();
		try {
			if(scan.hasNextLine()) {
				name = scan.nextLine();
			}
			
			while(scan.hasNextLine()) {
				String stored = scan.nextLine();
				if(stored.equals("")) {
					break;
				}
				commands.add(stored);
			}		
			//for(String str: commands)
			//	System.out.println(str);
		}
		finally {
			scan.close();
		}
		return new CritterSpecies(name, commands);
	}

}