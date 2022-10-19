package service;

import dao.ExcellDAO;
import dao.ExcellDAOImpl;
import entity.FileEntity;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileService {

    ExcellDAO excellDAO = new ExcellDAOImpl();

    public void insertArticlesInFile(String pathFactura, String pathResult) {

        File file = new File(pathFactura);
        List<FileEntity> articles = new LinkedList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(file.getName());
            System.out.println("Escribe el nombre del fichero resultado.");
            String fileName = sc.nextLine();

            File fileResult = new File(pathResult + fileName + ".txt");
            while (fileResult.exists()) {
                fileResult.delete();
            }
            fileResult.createNewFile();
            List<String> lines = excellDAO.readTextAndLoadInFile(file);
            String[] splitLines;
            for (String line : lines) {
                splitLines = line
                        .replace(",", ".")
                        .split(";");
                FileEntity article = excellDAO.setArticleInfo(splitLines);
                articles.add(article);
                System.out.println(excellDAO.printArticleInfo(articles));
                excellDAO.insertListIntoFile(articles, fileResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printInvoiceFile(String pathResult) {
        File[] files = excellDAO.listFiles(pathResult);
    }
}
