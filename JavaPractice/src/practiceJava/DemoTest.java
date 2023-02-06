package practiceJava;
import java.util.Scanner;

public class DemoTest {

    public static void main(String[] args) {    
    	Scanner userInput = new Scanner(System.in);
        String name;
        String yes = "YES";
        String no = "NO";    
        

        System.out.println("Enter your name:");
         name = userInput.next();
        System.out.println("Please varify your name by typing YES or NO");

       
		if (input.equals(yes)) {
            System.out.println("Your name is: " + name);
        } else if (input.equals(no)) {
            System.out.println("Enter your name again");

        }
            
    }    
}