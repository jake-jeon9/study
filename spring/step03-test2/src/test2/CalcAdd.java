package test2;

public class CalcAdd implements Calc{
	
	int num1,num2;
	
	@Override
	public void calculate() {
		System.out.println(num1 + " + " + num2 +" = "+(num1+num2));
	}
	

	public CalcAdd(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}


	
}
