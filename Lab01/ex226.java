import java.util.Scanner;

public class ex226 {
    public static void main(String[] args) {
        solveLinearEquation();
        solveSystemEquation();
        solveQuadraticEquation();
    }

    public static void solveLinearEquation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the coefficient a: ");
        double a = sc.nextDouble();
        System.out.print("Enter the coefficient b: ");
        double b = sc.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("There are infinitely many solutions");
            } else {
                System.out.println("There is no solution");
            }
        } else {
            System.out.println(-b / a);
        }
    }

    public static void solveSystemEquation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coefficients for the first equation:");
        System.out.print("a: ");
        double a1 = scanner.nextDouble();
        System.out.print("b: ");
        double b1 = scanner.nextDouble();
        System.out.print("c: ");
        double c1 = scanner.nextDouble();

        System.out.println("Enter the coefficients for the second equation:");
        System.out.print("a: ");
        double a2 = scanner.nextDouble();
        System.out.print("b: ");
        double b2 = scanner.nextDouble();
        System.out.print("c: ");
        double c2 = scanner.nextDouble();

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            System.out.println("The system of equations has no unique solution.");
        } else {
            double x = (c1 * b2 - c2 * b1) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;

            System.out.printf("The solution is: x = %.2f, y = %.2f", x, y);
        }

        scanner.close();
    }

    public static void solveQuadraticEquation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the coefficient a: ");
        double a = sc.nextDouble();
        System.out.print("Enter the coefficient b: ");
        double b = sc.nextDouble();
        System.out.print("Enter the coefficient c: ");
        double c = sc.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("There are no real solutions");
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("The solution is: x = " + x);
        } else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The solutions are: x1 = " + x1 + ", x2 = " + x2);
        }
    }
}
