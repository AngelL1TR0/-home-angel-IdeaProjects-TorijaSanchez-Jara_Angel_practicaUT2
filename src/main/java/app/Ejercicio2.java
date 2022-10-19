package app;

import service.ExcellService;

public class Ejercicio2 {

    private static final String PATH_RESULT = "/src/main/resources/";

    public static void main(String[] args) {
        ExcellService fileService = new ExcellService();
        fileService.printInvoiceFile(PATH_RESULT);
    }
}
