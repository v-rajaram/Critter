package assignment;



import java.io.FileReader;

import java.io.IOException;

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

// obviously, your code should do something

return;

}



public CritterSpecies loadSpecies(String filename) throws IOException {

// obviously, your code should do something

Scanner scan = new Scanner(new FileReader(filename));

String commandString = "";

String name = "";

if(scan.hasNextLine() && !(scan.nextLine().charAt(0) == '\n')) {

name = scan.nextLine();

}


while(scan.hasNextLine()) {

commandString += scan.nextLine() + "%"; //Signifies Command endline

}


String [] commands = commandString.split("%");

// Can you see this?


System.out.println(commands);


return null;

}

}