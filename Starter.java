import java.util.Scanner;

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

        Calculator calculator_Object=new Calculator(x,y);

        switch (operation) {
            case "+":
                System.out.println(operation + ": " + calculator_Object.Plus());
                break;
            case "*":
                System.out.println(operation + ": " + calculator_Object.Multiply());
                break;
            case "-":
                System.out.println(operation + ": " + calculator_Object.Minus());
                break;
            case "/":
                System.out.println(operation + ": " + calculator_Object.Divide());
                break;
                default:
                    System.out.println(operation + " is wrong operation");
                    break;

        }
    }
}
