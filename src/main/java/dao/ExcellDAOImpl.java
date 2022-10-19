package dao;

import entity.FileEntity;
import entity.FileEntityName;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class ExcellDAOImpl implements ExcellDAO {

    @Override
    public List<String> readTextAndLoadInFile(File file) throws IOException {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            List<String> text = new LinkedList<>();
            boolean lineN1 = true;
            while ((line = br.readLine()) != null) {
                if (lineN1) {
                    lineN1 = false;
                    continue;
                }
                text.add(line);
            }
            return text;
        }
    }

    @Override
    public void insertListIntoFile(List<FileEntity> articles, File file) throws IOException {
        try (OutputStreamWriter outputStreamWriter =
                     new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.ISO_8859_1);
             PrintWriter pw = new PrintWriter(outputStreamWriter)) {
            for (int i = 0; i < articles.size(); i++) {
                pw.println(printArticleInfo(articles));
            }
        }
    }

    @Override
    public String printArticleInfo(List<FileEntity> articles) {
        String info = "";

        for (int i = 0; i < articles.size(); i++) {
            double cost = articles.get(i).getDerivedCosts() +
                    articles.get(i).getProductionCosts() +
                    articles.get(i).getTaxes();
            double profits = articles.get(i).getSellPrice() - cost;


            info = "Articulo: " + articles.get(i).getArticle() + "\n" +
                    "Tipo: " + articles.get(i).getType() + "\n" +
                    "Precio de venta: " + articles.get(i).getSellPrice() + "\n" +
                    "Coste: " + cost + "\n" +
                    "Beneficio: " + profits + "\n" +
                    "==================================";

        }
        return info;
    }

    @Override
    public FileEntity setArticleInfo(String[] splitInfo) {
        FileEntity article = new FileEntity();

        article.setArticle(splitInfo[0]);
        article.setType(splitInfo[1]);
        article.setDate(splitInfo[2]);
        article.setSellPrice(Double.parseDouble(splitInfo[3]));
        article.setDerivedCosts(Double.parseDouble(splitInfo[4]));
        article.setProductionCosts(Double.parseDouble(splitInfo[5]));
        article.setTaxes(Double.parseDouble(splitInfo[6]));

        return article;
    }

// EJERCICIO 2.

    @Override
    public File[] listFiles(String directory) {
        File path = new File(directory);
        return path.listFiles();
    }

    /*
    public FileEntity getArticlesNumber(List<FileEntity> fileEntities) {
        int articlesNum = 0;
        for (FileEntity fileEntity : fileEntities) {

        }
        return fileEntity;
    }

     */
}
