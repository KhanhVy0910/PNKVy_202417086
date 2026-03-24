/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import javax.swing.JOptionPane;
public class giaiPhuongTrinh {
    public void bac_1(double a, double b) {
    if (a == 0) {
        if (b == 0) {
            JOptionPane.showMessageDialog(null, "Phương trình vô số nghiệm\n");
        } else {
            JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm\n");
        }
    } else {
        double x = -b / a;
        JOptionPane.showMessageDialog(null, "Nghiệm: x = " + x+"\n");
    }
}
    public void bacNhatHaiAn(double a11, double a12, double a21, double a22, double b1, double b2) {
    double D  = a11 * a22 - a12 * a21;
    double D1 = b1  * a22 - b2  * a12;
    double D2 = a11 * b2  - a21 * b1;

    if (D != 0) {
        double x = D1 / D;
        double y = D2 / D;
        JOptionPane.showMessageDialog(null, "Nghiem duy nhat:\nx = " + x + "\ny = " + y);
    } else {
        if (D1 == 0 && D2 == 0) {
            JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem");
        } else {
            JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
        }
    }
}
    public void bac2(double a, double b, double c) {
    if (a == 0) {
        bac_1(b, c); // goi lai ham bac 1 neu a = 0
        return;
    }

    double delta = b * b - 4 * a * c;

    if (delta < 0) {
        JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
    } else if (delta == 0) {
        double x = -b / (2 * a);
        JOptionPane.showMessageDialog(null, "Nghiem kep: x = " + x);
    } else {
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        JOptionPane.showMessageDialog(null, "Hai nghiem phan biet:\nx1 = " + x1 + "\nx2 = " + x2);
    }
}
    public static void main(String[] args) {
            JOptionPane.showMessageDialog(null, "Che do:\n"
                                                  + "1. Giai phuong trinh bac nhat 1 an.\n"
                                                  +  "2.Giai he phuong trinh bac nhat 2 an.\n"
                                                   +"3.Giai phuong trinh bac 2.\n");
            String stropt = JOptionPane.showInputDialog(null, "Chon che do: ");
            int n = Integer.parseInt(stropt);
            giaiPhuongTrinh gpt = new giaiPhuongTrinh();
            if(n == 1){
                String stra,strb;
                stra = JOptionPane.showInputDialog(null,"Nhap a: ");
                strb = JOptionPane.showInputDialog(null,"Nhap b: ");
                double a,b;
                a = Double.parseDouble(stra);
                b = Double.parseDouble(strb);
                
                gpt.bac_1(a, b);
                System.exit(0);
            }
            if( n == 2) {
                String stra11,stra12,stra21,stra22,strb1,strb2;
                
                stra11 = JOptionPane.showInputDialog(null,"Nhap a11: ");
                stra12 = JOptionPane.showInputDialog(null,"Nhap a12: ");
                strb1 = JOptionPane.showInputDialog(null,"Nhap b1: ");
                
                stra21 = JOptionPane.showInputDialog(null,"Nhap a21: ");
                stra22 = JOptionPane.showInputDialog(null,"Nhap a22: ");
                strb2 = JOptionPane.showInputDialog(null,"Nhap b2: ");
                
                double a11 , a12, a21, a22, b1, b2;
                a11 = Double.parseDouble(stra11);
                a12 = Double.parseDouble(stra12);
                a21 = Double.parseDouble(stra21);
                a22 = Double.parseDouble(stra22);
                b1 = Double.parseDouble(strb1);
                b2 = Double.parseDouble(strb2);
                gpt.bacNhatHaiAn(a11, a12, a21, a22, b1, b2);
                System.exit(0);

            }
            if(n == 3) {
                String stra, strb, strc;
                stra = JOptionPane.showInputDialog(null,"Nhap a: ");
                strb = JOptionPane.showInputDialog(null,"Nhap b: ");
                strc = JOptionPane.showInputDialog(null,"Nhap c: ");
                
                double a,b,c;
                a = Double.parseDouble(stra);
                b = Double.parseDouble(strb);
                c = Double.parseDouble(strc);
                
                gpt.bac2(a, b, c);
                System.exit(0);
               
            }

    }
}
