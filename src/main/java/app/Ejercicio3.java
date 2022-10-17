package app;

import service.ExcellService;

public class Ejercicio3 {

    private static final String PATH = "\"C:\\Users\\angel\\Downloads\\invoice_202009.csv\"";

    public static void main(String[] args) {
        ExcellService excellService = new ExcellService();
        excellService.creaExcell(PATH);

    }
}
