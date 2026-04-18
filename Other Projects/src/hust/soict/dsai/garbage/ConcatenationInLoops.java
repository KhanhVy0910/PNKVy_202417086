package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        
        // Test 1: String concatenation with +
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("String + operator: " + 
            (System.currentTimeMillis() - start) + " ms");
        
        // Test 2: StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("StringBuffer: " + 
            (System.currentTimeMillis() - start) + " ms");
        
        // Test 3: StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sBuilder.append(r.nextInt(2));
        }
        s = sBuilder.toString();
        System.out.println("StringBuilder: " + 
            (System.currentTimeMillis() - start) + " ms");
    }
}