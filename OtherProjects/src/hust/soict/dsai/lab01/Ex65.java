package hust.soict.dsai.lab01;
// write a java programe to sort a numeric array and 
// calculate the sum and average value of array elements
import java.util.Arrays;
import java.util.Scanner;

public class Ex65 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        double[] array = new double[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextDouble();
        }

        Arrays.sort(array);

        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }

        double average = sum / size;

        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);
    }
}
