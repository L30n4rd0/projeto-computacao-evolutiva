package ufrpe.ppgia.ce.util;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class FileManager {
 
    public static String readFile(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = buffRead.readLine(), conteudo = "";
        
        while (linha != null) {
        	conteudo += linha;
            linha = buffRead.readLine();
        }
        buffRead.close();
        
        return conteudo;
    }
 
    public static void writeFile(String filePath, String content, boolean appendEnable) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(filePath, appendEnable));
        
        buffWrite.write(content);
        buffWrite.close();
    }
 
}