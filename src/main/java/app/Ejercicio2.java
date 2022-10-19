package app;

import service.ExcellService;
import service.FileService;

public class Ejercicio2 {

    private static final String PATH_RESULT = "/src/main/resources/";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.printInvoiceFile(PATH_RESULT);
    }
}
