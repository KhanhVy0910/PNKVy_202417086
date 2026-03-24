import java.util.Arrays;
import java.util.Scanner;

public class sortArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] my_array1 = new int[n];
        
        for (int i = 0; i < n; i++) {
            my_array1[i] = scanner.nextInt();
        }

        System.out.println("\nPre array:");
        System.out.println(Arrays.toString(my_array1));

        long sum = 0;
        for (int val : my_array1) {
            sum += val;
        }
        double average = (double) sum / n;

        // Sắp xếp mảng
        Arrays.sort(my_array1);

        // In mảng sau khi sắp xếp
        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(my_array1));

        System.out.println("\nSum     = " + sum);
        System.out.printf("TB = %.2f%n", average);

        scanner.close();
    }
}