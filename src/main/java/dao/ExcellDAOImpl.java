package dao;

import entity.FileEntity;
import entity.FileEntityName;

import java.io.*;
import java.util.Arrays;

public class ExcellDAOImpl implements ExcellDAO{

    public static final String SEPARADOR = ";";
    @Override
    public void readText(File file) {
        BufferedReader bufferLectura = null;
        try {
            bufferLectura = new BufferedReader(new FileReader(file.getPath()));
            String linea = bufferLectura.readLine();

            FileEntityName fileEntityName = new FileEntityName(file.getName());
            FileEntity fileEntity = new FileEntity();



            System.out.println("Contenido del archivo " + file.getName() + ":\n");

            while (linea != null) {

                System.out.println(fileEntityName.toString());
                fileEntity.toString();

                String[] campos = linea.split(SEPARADOR);

                System.out.println(Arrays.toString(campos));

                linea = bufferLectura.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isEOF(RandomAccessFile randomAccessFile) throws IOException {
        return randomAccessFile.length() == randomAccessFile.getFilePointer();
    }
}
