package JonnasT.FitNesse;

public class AddTwoNumber {
	private int firstInt;
	  private int secondInt;
	  
	  private Calculator calculator;
	  
	  public AddTwoNumber() {
	    calculator = new Calculator();
	  }
	  
	  public void setFirstInt(int firstInt) {
	    this.firstInt = firstInt;
	  }
	  
	  public void setSecondInt(int secondInt) {
	    this.secondInt = secondInt;
	  }
	  
	  public int resultOfAddition() {
	    return calculator.add(firstInt, secondInt);
	  }
	}
	  

