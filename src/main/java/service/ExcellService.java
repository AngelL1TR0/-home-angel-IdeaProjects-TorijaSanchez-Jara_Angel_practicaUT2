package service;

import dao.ExcellDAO;
import dao.ExcellDAOImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExcellService {

    ExcellDAO excellDAO = new ExcellDAOImpl();
    public void leeFichero(String path) {
        File file = new File(path);
        if (file.exists()){
            excellDAO.readText(file);
        }
    }

    public void creaFichero(String path) {
    }

    public void creaExcell(String path) {
    }
}
