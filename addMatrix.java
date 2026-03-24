import java.util.Scanner;

public class addMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước ma trận
        System.out.print("Nhap so hang: ");
        int rows = scanner.nextInt();
        System.out.print("Nhap so cot: ");
        int cols = scanner.nextInt();

        int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[rows][cols];
        int[][] matrixC = new int[rows][cols];

        // Nhập ma trận A
        System.out.println("\nNhap Matrix A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // Nhập ma trận B
        System.out.println("\nNhap Matrix B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Cộng hai ma trận
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        // In ma trận A
        System.out.println("\nMatrix A:");
        printMatrix(matrixA, rows, cols);

        // In ma trận B
        System.out.println("\nMatrix B:");
        printMatrix(matrixB, rows, cols);

        // In ma trận kết quả C = A + B
        System.out.println("\nMatrix C = A + B:");
        printMatrix(matrixC, rows, cols);

        scanner.close();
    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            System.out.print("  [ ");
            for (int j = 0; j < cols; j++) {
                System.out.printf("%6d ", matrix[i][j]);
            }
            System.out.println("]");
        }
    }
}
