package app;

import service.ExcellService;

public class Ejercicio2 {

    private static final String PATH = "/home/angel/Descargas/invoice_202009.csv";

    public static void main(String[] args) {
        ExcellService excellService = new ExcellService();
        excellService.creaFichero(PATH);

    }
}
