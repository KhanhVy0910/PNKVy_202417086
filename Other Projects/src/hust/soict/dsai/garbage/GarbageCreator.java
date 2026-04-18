package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe"; // Tên file lớn bất kỳ
        byte[] inputBytes = {0};
        long startTime, endTime;
        
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            
            // TẠO GARBAGE - Nối chuỗi bằng +
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char)b;
            }
            
            endTime = System.currentTimeMillis();
            System.out.println("Time with + operator: " + 
                (endTime - startTime) + " ms");
            
        } catch (IOException e) {
            System.out.println("File not found: " + filename);
        }
    }
}