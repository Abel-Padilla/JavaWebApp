package models.service;

import java.util.ArrayList;
import models.bean.CategoriaBean;

public interface CategoriaService {
    //CRUD
    public boolean create(CategoriaBean categoria);
    public ArrayList<CategoriaBean> read(CategoriaBean categoria);
    public CategoriaBean read(int idCategoria);
    public boolean update(CategoriaBean categoria);
    public boolean delete(int idCategoria);
    public int comprobarExistencia(String nombre);
}
