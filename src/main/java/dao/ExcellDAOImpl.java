package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExcellDAOImpl implements ExcellDAO{
    @Override
    public void readText(File file) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            System.out.printf("Lectura del fichero %s: \n", file.getName());
            while((line=br.readLine())!=null) {
               file.toString();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
