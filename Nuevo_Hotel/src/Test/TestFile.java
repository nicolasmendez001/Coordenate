package Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestFile {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("d:/Pruebas/test.xyz","rw");
            randomAccessFile.writeUTF("lola");
            randomAccessFile.writeUTF("pepe");
            randomAccessFile.close();
            
            randomAccessFile = new RandomAccessFile("d:/Pruebas/test.xyz","r");
            System.out.println("Leido : "+randomAccessFile.readUTF());
            System.out.println("Leido : "+randomAccessFile.readUTF());
            randomAccessFile.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
