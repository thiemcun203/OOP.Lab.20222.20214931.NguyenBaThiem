package hust.soict.dsai.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
public class GarbageCollector {
    public static void main(String[] args){
    String filename = "/Users/nguyenbathiem/Documents/GitHub/OOP.Lab.20222.20214931.NguyenBaThiem/OtherProjects/src/hust/soict/dsai/garbage/myfile.exe"; // test.exe is the name or path to an executable file
    byte [] inputBytes = { 0 };
    long startTime,endTime;
    try {
        inputBytes = Files.readAllBytes(Paths.get(filename));
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    startTime = System.currentTimeMillis();	
    String outputString = "";
    for(byte b : inputBytes) {
        outputString += b;
    }
    // using stringbuilder
    StringBuilder outputStringBuilder = new StringBuilder();
    for(byte b : inputBytes) {
        outputStringBuilder.append(b);
        }
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
    // using stringbuffer
    startTime = System.currentTimeMillis();
    StringBuffer outputStringBuffer = new StringBuffer();
    for(byte b : inputBytes) {
        outputStringBuffer.append(b);
        }
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
}
}
