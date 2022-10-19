package app;

import service.ExcellService;
import service.FileService;

public class Ejercicio1 {

    private final static String PATH_FACTURA = "src/main/resources/invoice_202009.csv";
    private final static String PATH_RESULT = "src/main/resources/";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.insertArticlesInFile(PATH_FACTURA, PATH_RESULT);
    }
}

