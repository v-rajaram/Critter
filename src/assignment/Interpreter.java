package assignment;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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
		
		int numCommands = commands.size();
		for(String strng : commands) {
			System.out.print(strng + " ");
			System.out.println("");
		}
		
		for(int i = 0; i < commands.size(); i++) {
			String [] splitCommands = commands.get(i).split(" ");
			for(String com : splitCommands) {
				System.out.println(com);
			}
			System.out.println(splitCommands[0]);
			switch (splitCommands[0]) {
				case "hop": 
					c.hop();
					break;
				case "left":
					c.left();
	            		break;
	            case "right":  
	            		c.right();
	            		break;
	            case "infect":  
	            		c.infect(Integer.parseInt(splitCommands[1]));
	            		break;
	            case "eat":  
	            		c.eat();
	            		break;
	            case "go": 
	            		String goParam = splitCommands[1];
	            		if(goParam.charAt(0) == '+')
	            			c.setNextCodeLine(Integer.parseInt(goParam.substring(1)) + i);
	            		else if(goParam.charAt(0) == '-')
	            			c.setNextCodeLine(i - Integer.parseInt(goParam.substring(1)));
	            		else if(goParam.charAt(0) == 'r')
	            			c.setNextCodeLine(c.getReg(Integer.parseInt(goParam.substring(1))));
	            		else
	            			c.setNextCodeLine(Integer.parseInt(goParam.substring(1)));
	            		break;
	            case "ifrandom":
	            		if(c.ifRandom()) {
	            			int randomIndex = ThreadLocalRandom.current().nextInt(0, numCommands);
	            			c.setNextCodeLine(randomIndex);
	            		}
	            		break;
	            case "ifempty":
	            		int emptyBearing = Integer.parseInt(splitCommands[1]);
	            		int emptyInstructionNum = Integer.parseInt(splitCommands[2]);
	            		if(c.getCellContent(emptyBearing)==Critter.EMPTY)
	            			c.setNextCodeLine(emptyInstructionNum);
	            		break;
	            case "ifally":  
		            	int allyBearing = Integer.parseInt(splitCommands[1]);
	            		int allyInstructionNum = Integer.parseInt(splitCommands[2]);	
		            	if(c.getCellContent(allyBearing)==Critter.ALLY)
		            		c.setNextCodeLine(allyInstructionNum);
		            	break;
	            case "ifenemy":  
		            	int enemyBearing = Integer.parseInt(splitCommands[1]);
	            		int enemyInstructionNum = Integer.parseInt(splitCommands[2]);	
		            	if(c.getCellContent(enemyBearing)==Critter.ENEMY)
		            		c.setNextCodeLine(enemyInstructionNum);
		            	break;
	            case "ifwall":
		            	int wallBearing = Integer.parseInt(splitCommands[1]);
	            		int wallInstructionNum = Integer.parseInt(splitCommands[2]);	
		            	if(c.getCellContent(wallBearing)==Critter.WALL)
		            		c.setNextCodeLine(wallInstructionNum);
	            		break;
	            	case "ifangle":
	            		int angleBearing1 = Integer.parseInt(splitCommands[1]);
	            		int angleBearing2 = Integer.parseInt(splitCommands[2]);
	            		int angleInstructionNum = Integer.parseInt(splitCommands[3]);
	            		if(c.getOffAngle(angleBearing1)==angleBearing2)
	            			c.setNextCodeLine(angleInstructionNum);
	            		break;
	            	case "write":
	            		int register = Integer.parseInt(splitCommands[1]);
	            		int value = Integer.parseInt(splitCommands[2]);
	            		c.setReg(register, value);
	            		break;
	            	case "add":
	            		int addr1 = Integer.parseInt(splitCommands[1]);
	            		int addr2 = Integer.parseInt(splitCommands[2]);
	            		c.setReg(addr1, c.getReg(addr1) + c.getReg(addr2));
	            		break;
	            	case "sub":
	            		int subr1 = Integer.parseInt(splitCommands[1]);
	            		int subr2 = Integer.parseInt(splitCommands[2]);
	            		c.setReg(subr1, c.getReg(subr1) + c.getReg(subr2));
	            		break;
	            	case "inc":
	            		c.setReg(Integer.parseInt(splitCommands[1]), c.getReg(Integer.parseInt(splitCommands[1]) + 1));
	            		break;
	            	case "dec":
	            		c.setReg(Integer.parseInt(splitCommands[1]), c.getReg(Integer.parseInt(splitCommands[1]) - 1));
	            		break;
	            	case "iflt":
	            		int lessr1 = Integer.parseInt(splitCommands[1]);
	            		int lessr2 = Integer.parseInt(splitCommands[2]);
	            		int lessInstructionNum = Integer.parseInt(splitCommands[3]);
	            		if(c.getReg(lessr1) < c.getReg(lessr2)) {
	            			c.setNextCodeLine(lessInstructionNum);
	            		}
	            		break;
	            	case "ifreq":
	            		int equalr1 = Integer.parseInt(splitCommands[1]);
	            		int equalr2 = Integer.parseInt(splitCommands[2]);
	            		int equalInstructionNum = Integer.parseInt(splitCommands[3]);
	            		if(c.getReg(equalr1) == c.getReg(equalr2)) {
	            			c.setNextCodeLine(equalInstructionNum);
	            		}
	            		break;
	            	case "ifgt":
	            		int greatr1 = Integer.parseInt(splitCommands[1]);
	            		int greatr2 = Integer.parseInt(splitCommands[2]);
	            		int greatInstructionName = Integer.parseInt(splitCommands[3]);
	            		if(c.getReg(greatr1) == c.getReg(greatr2)) {
	            			c.setNextCodeLine(greatInstructionName);
	            		}
	            		break;
	            	default: 
                     break;
			}
		}
		
	return;
	
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