/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import javax.swing.JOptionPane;
public class DoubleNumber {
    public double sum(double a, double b) {
        return a + b;
    }
    public double diff(double a, double b) {
        return a - b;
    }
    public double prod(double a, double b) {
        return a*b;
    }
    public double quot(double a, double b) {
        return a/b;
    }
    public static void main(String[] args) {
        String strNum1, strNum2;
        
        strNum1 = JOptionPane.showInputDialog(null, "Please enter first number: ");
        strNum2 = JOptionPane.showInputDialog(null, "Please enter second number: ");
        
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        
        DoubleNumber dn = new DoubleNumber();
        double Tong = dn.sum(num1,num2);
        double Hieu = dn.diff(num1,num2);
        double Tich = dn.prod(num1, num2);
        double Thuong = dn.quot(num1, num2);
        JOptionPane.showMessageDialog(null, "Sum: " + Tong 
                                     + "\nHieu: " + Hieu
                                     +"\nTich: " + Tich
                                     +"\nThuong: "+ Thuong
        
        );
        
    }
}
