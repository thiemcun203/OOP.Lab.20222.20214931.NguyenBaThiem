import java.util.Scanner;
public class ex225 {
    public static void main(String[] args){


    //need type return, datatype and ;
    Scanner sc = new Scanner(System.in); // new -> make object from class
    String strNum1 = sc.nextLine();
    String strNum2 = sc.nextLine();
    double num1 = Double.parseDouble(strNum1);
    double num2 = Double.parseDouble(strNum2);
    sum(num1, num2);
    difference(num1, num2);
    product(num1,num2);
    quotient(num1, num2);
}
    public static double sum(double num1,double num2){
        System.out.println(num1 + num2);
        return num1 +num2;
    }
    public static double difference( double num1, double num2) {
        if (num1 > num2)
        {System.out.println(num1 -num2);return num1-num2;}
        else {
            System.out.println(num2-num1);return num1-num2;}
             
        }
    public static double product(double num1, double num2){
        double result =num1*num2;
        System.out.println(result);
        return result;
    }
    public static double quotient(double num1, double num2){
        if (num2 == 0) {
            System.out.println("Can not divide");
            return 0;
        }
        else{
            double result = num1/num2;
            System.out.println(result);
            return result;
        }
    }
}
