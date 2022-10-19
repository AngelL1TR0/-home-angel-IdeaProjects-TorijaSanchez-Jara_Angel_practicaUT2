package dao;

import entity.FileEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ExcellDAO {
    List<String> readTextAndLoadInFile(File file) throws IOException;

    void insertListIntoFile(List<FileEntity> articles, File file) throws IOException;

    String printArticleInfo(List<FileEntity> articles);

    FileEntity setArticleInfo(String[] splitInfo);

    File[] listFiles(String directory);
}
