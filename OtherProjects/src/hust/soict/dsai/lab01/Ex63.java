package hust.soict.dsai.lab01;
/*Write a program to display a triangle with a height of n stars (*)
n=5
    *
   ***
  *****
 *******
*********

 */
import java.util.Scanner;;
public class Ex63 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("n:");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
