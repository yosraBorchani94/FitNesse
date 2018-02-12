package calculator;

public class Calculator {
	private int first, second;

	public void setFirst(int first) {
		this.first = first;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int addition() {
		return (first + second);
	}

	public int minus() {
		return (first - second);
	}

	public int multiply() {
		return (first * second);
	}

	public float divide()
	{
	return (first/second);
	}
}
