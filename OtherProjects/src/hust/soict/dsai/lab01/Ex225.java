package hust.soict.dsai.lab01;
/*2.2.5 Write a program to calculate sum,
difference,product, and quotient of 2 double numbers which
are entered by users */
import java.util.Scanner;

public class Ex225 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        String strNum1 = input.nextLine();
        double num1 = Double.parseDouble(strNum1);
        
        System.out.print("Enter the second number: ");
        String strNum2 = input.nextLine();
        double num2 = Double.parseDouble(strNum2);
        
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;
        
        System.out.println("The sum of the two numbers is " + sum);
        System.out.println("The difference of the two numbers is " + difference);
        System.out.println("The product of the two numbers is " + product);
        
        if (Double.isFinite(quotient)) {
            System.out.println("The quotient of the two numbers is " + quotient);
        } else {
            System.out.println("Cannot divide by zero");
        }
    }
}
