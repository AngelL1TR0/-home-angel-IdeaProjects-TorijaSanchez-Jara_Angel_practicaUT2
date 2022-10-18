package service;

import dao.ExcellDAO;
import dao.ExcellDAOImpl;

import java.io.File;

public class ExcellService {

    ExcellDAO excellDAO = new ExcellDAOImpl();
    public void leeFichero(String path) {
        File file = new File(path);
        excellDAO.readText(file);
    }

    public void creaFichero(String path) {
    }

    public void creaExcell(String path) {
    }
}
