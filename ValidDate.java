/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package validdate;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

public class ValidDate {
    
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public static int getMonthNumber(String input) {
        switch (input.toLowerCase()) {
            case "january": case "jan.": case "jan": case "1": return 1;
            case "february": case "feb.": case "feb": case "2": return 2;
            case "march": case "mar.": case "mar": case "3": return 3;
            case "april": case "apr.": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun": case "6": return 6;
            case "july": case "jul": case "7": return 7;
            case "august": case "aug.": case "aug": case "8": return 8;
            case "september": case "sept.": case "sep": case "9": return 9;
            case "october": case "oct.": case "oct": case "10": return 10;
            case "november": case "nov.": case "nov": case "11": return 11;
            case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1;
        }
    }
    
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            case 4: case 6: case 9: case 11: return 30;
            case 2: return isLeapYear(year) ? 29 : 28;
            default: return -1;
        }
    }
    
    public static boolean isValidYear(String yearInput) {
        if (!yearInput.matches("\\d+")) return false;
        if (yearInput.length() > 1 && yearInput.startsWith("0")) return false;
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int monthNumber = -1;
        int year = -1;
        
        // Nhập tháng
        while (monthNumber == -1) {
            System.out.print("Enter month: ");
            String monthInput = scanner.nextLine().trim();
            monthNumber = getMonthNumber(monthInput);
            if (monthNumber == -1) {
                System.out.println("Invalid month! Please enter again.");
            }
        }
        
        while (year == -1) {
            System.out.print("Enter year: ");
            String yearInput = scanner.nextLine().trim();
            if (isValidYear(yearInput)) {
                year = Integer.parseInt(yearInput);
            } else {
                System.out.println("Invalid year!");
            }
        }
        
        int days = getDaysInMonth(monthNumber, year);
        System.out.println("\nResult: Month " + monthNumber + "/" + year +
                " has " + days + " days." +
                (isLeapYear(year) ? " (" + year + " is a leap year)" : " (" + year + " is a common year)"));
        
        scanner.close();
    }
}
