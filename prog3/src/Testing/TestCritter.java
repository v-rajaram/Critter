package Testing;

import java.util.List;

import assignment.Critter;
import assignment.CritterSpecies;

public class TestCritter implements Critter{
	
	private String methodCalled;
	private List code;
	private int codeLine = 1;
	
	public TestCritter(String name, List code) {
		this.code = code;
		this.methodCalled = "";
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCellContent(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getCode() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public int getNextCodeLine() {
		// TODO Auto-generated method stub
		return codeLine;
	}

	@Override
	public int getOffAngle(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getReg(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void hop() {
		// TODO Auto-generated method stub
		methodCalled += "hop";
	}

	@Override
	public boolean ifRandom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void infect() {
		// TODO Auto-generated method stub
		methodCalled += "infect";
	}

	@Override
	public void infect(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		methodCalled += "left";
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		methodCalled += "right";
	}

	@Override
	public void setNextCodeLine(int arg0) {
		// TODO Auto-generated method stub
		this.codeLine = arg0;
	}

	@Override
	public void setReg(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public String getmethodCalled() {
		return methodCalled;
	}

}
