package Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import assignment.Interpreter;

public class CritterExecuteTesting {

	
	Interpreter ourCode = new Interpreter();
	
	
	
	@Test
	public void testHop() {
		ArrayList<String>commands = new ArrayList<String>();
		commands.add("hop");
		TestCritter c = new TestCritter("Hiphop", commands);
		ourCode.executeCritter(c);
		assertEquals(commands.get(0), c.getmethodCalled());
	}
	
	@Test
	public void testLeft() {
		ArrayList<String>commands = new ArrayList<String>();
		commands.add("left");
		TestCritter c = new TestCritter("Hiphop", commands);
		ourCode.executeCritter(c);
		assertEquals(commands.get(0), c.getmethodCalled());
	}
	
	@Test
	public void testRight() {
		ArrayList<String>commands = new ArrayList<String>();
		commands.add("right");
		TestCritter c = new TestCritter("Hiphop", commands);
		ourCode.executeCritter(c);
		assertEquals(commands.get(0), c.getmethodCalled());
	}
	
	@Test
	public void testInfectNoParam() {
		ArrayList<String>commands = new ArrayList<String>();
		commands.add("infect");
		TestCritter c = new TestCritter("Hiphop", commands);
		ourCode.executeCritter(c);
		assertEquals(commands.get(0), c.getmethodCalled());
	}

}
