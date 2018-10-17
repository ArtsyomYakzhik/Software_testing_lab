import java.util.Scanner;
import java.util.*;
import java.util.function.*;

//This is my code
public class Starter {

    public static void main(String[] args) {
	


        double x, y;

        Scanner scan=new Scanner(System.in);
        String operation;

        System.out.println("Operation:");
        operation=scan.next();

        System.out.println("First number:");
        x=scan.nextDouble();

        System.out.println("Second number:");
        y=scan.nextDouble();

	Calculator calcObject = new Calculator();	

	System.out.println("Result: " + calcObject.GetResult(operation, x, y));

    }
}
