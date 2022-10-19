package app;

import service.ExcellService;

public class Ejercicio1 {

    private final static String PATH_FACTURA = "src/main/resources/invoice_202009.csv";
    private final static String PATH_RESULT = "src/main/resources/";

    public static void main(String[] args) {
        ExcellService fileService = new ExcellService();
        fileService.insertArticlesInFile(PATH_FACTURA, PATH_RESULT);
    }
}

