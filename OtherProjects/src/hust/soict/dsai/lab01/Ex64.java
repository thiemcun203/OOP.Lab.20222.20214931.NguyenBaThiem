package hust.soict.dsai.lab01;

import java.util.Scanner;

public class Ex64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month=0, year=0;
        String monthStr;
        boolean validInput = false;

        do {
            System.out.print("Enter the month (1-12 or name of the month): ");
            monthStr = scanner.nextLine().toLowerCase().trim();

            switch (monthStr) {
                case "1":
                case "jan":
                case "jan.":
                case "january":
                    month = 1;
                    validInput = true;
                    break;
                case "2":
                case "feb":
                case "feb.":
                case "february":
                    month = 2;
                    validInput = true;
                    break;
                case "3":
                case "mar":
                case "mar.":
                case "march":
                    month = 3;
                    validInput = true;
                    break;
                case "4":
                case "apr":
                case "apr.":
                case "april":
                    month = 4;
                    validInput = true;
                    break;
                case "5":
                case "may":
                    month = 5;
                    validInput = true;
                    break;
                case "6":
                case "jun":
                case "jun.":
                case "june":
                    month = 6;
                    validInput = true;
                    break;
                case "7":
                case "jul":
                case "jul.":
                case "july":
                    month = 7;
                    validInput = true;
                    break;
                case "8":
                case "aug":
                case "aug.":
                case "august":
                    month = 8;
                    validInput = true;
                    break;
                case "9":
                case "sep":
                case "sept.":
                case "september":
                    month = 9;
                    validInput = true;
                    break;
                case "10":
                case "oct":
                case "oct.":
                case "october":
                    month = 10;
                    validInput = true;
                    break;
                case "11":
                case "nov":
                case "nov.":
                case "november":
                    month = 11;
                    validInput = true;
                    break;
                case "12":
                case "dec":
                case "dec.":
                case "december":
                    month = 12;
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (!validInput);

        validInput = false;
        do {
            System.out.print("Enter the year: ");
            try {
                year = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid year.");
            }
        } while (!validInput);

        int numDays = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    numDays=29;}
                else{
                    numDays=28;
                }

            }
        System.out.print(numDays);
    }
}
