package practiceJava;

import java.util.Scanner;
import java.lang.IllegalAccessException;
public class DemoTest1 {


	public static void main(String[] args) throws Exception {

	
		 Scanner userInput = new Scanner(System.in);

//	Scanner scanner = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = userInput.nextLine();
		
		System.out.printf("Hey %s, How are you?", name);
		String status = userInput.nextLine(); 
		
		 
		    String yes = "YES";
		    String no = "NO";

		   
		    while (true) {

		        System.out.println("Enter your name:");
		        name = userInput.next();

		        System.out.println("Please varify your name by typing YES or NO");
		        String input = userInput.next();

		        if (input.equals(yes)) {
		            System.out.println("Your name is: " + name);
		            
		        } else if (input.equals(no)) {
		            System.out.println("Enter your name again");
		        }


		System.out.println("What is your age?");
		int age = userInput.nextInt();
		
		System.out.println("Thank you for the information");
		userInput.close();

	}
	}
}




