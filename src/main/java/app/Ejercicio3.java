package app;

import service.ExcellService;

import java.io.IOException;

public class Ejercicio3 {

    private static final String PATH = "src/main/resources/ShopInfo.xlsx";
    private static final String NEW_PATH = "src/main/resources/result_invoice_202009.txt";
    public static void main(String[] args) throws IOException {
        ExcellService excellService = new ExcellService();
        excellService.createExcelFile(PATH, NEW_PATH);

    }
}
