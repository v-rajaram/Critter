package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class testLoadSpecies {
	
	
	public static void main (String args[]) throws FileNotFoundException {
		
		
// obviously, your code should do something
		
		System.out.println("Enter in file pls");
		Scanner user = new Scanner(System.in);
		String fileName = user.nextLine();
		Scanner scan = new Scanner(new FileReader("./species/" + fileName));
		String name = "";
		LinkedList <String> commands = new LinkedList <String>();
		try {
			if(scan.hasNextLine() ) {
				name = scan.nextLine();
			}
			//System.out.println(name);
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
		
	}
	

}

