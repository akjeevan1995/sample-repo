package practiceJava;

public class ClassJava {
	
	public String name = "Dog";
	public int weight = 15;
	public int height = 25;
	
	
	public static void main(String [] arg)
	{
		ClassJava testObj = new ClassJava();
		
		System.out.println(testObj.name +" " + testObj.height +" "+ testObj.weight);
		
		System.out.println("Pig");	
	}
	
	}
