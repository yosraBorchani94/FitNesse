package JonnasT.FitNesse;

public class SubtractAnIntegerToAnother {
	  private int intToBeSubtracted;
	  private int minus;
	  
	  private Calculator calculator;
	  
	  public SubtractAnIntegerToAnother() {
	    calculator = new Calculator();
	  }
	  
	  public void setIntToBeSubtracted(int intToBeSubtracted) {
	    this.intToBeSubtracted = intToBeSubtracted;
	  }
	  
	  public void setMinus(int minus) {
	    this.minus = minus;
	  }
	  
	  public int resultOfSubtraction() {
	    return calculator.minus(intToBeSubtracted, minus);
	  }
}