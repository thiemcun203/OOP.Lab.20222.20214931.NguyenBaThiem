import java.util.Scanner;
public class ex226 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String stra = sc.nextLine();
        String strb = sc.nextLine();
        Double a = Double.parseDouble(stra);
        Double b = Double.parseDouble(strb);
        solveLinearEquation(a, b);
    }
    public static void solveLinearEquation(double a, double b){
        if (a==0){
            if (b==0){
                System.out.println("There are infinitely many solutions");
            }
            else{
                System.out.println("There is no solution");
            }
        }
        else {
            System.out.println(-b/a);
        }
    }
    public static void solveSystemEquation (double )
}
