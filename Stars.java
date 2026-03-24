/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stars;
import java.util.Scanner;
public class Stars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n: ");
        
        int n = sc.nextInt();
        int space = n - 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i * 2 - 1; j ++){
                System.out.print("*");
            }
            System.out.print("\n");
            space--;       
        }
        
        
    }
    
}
