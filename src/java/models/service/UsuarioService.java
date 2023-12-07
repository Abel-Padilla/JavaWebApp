/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.service;

import java.util.ArrayList;
import models.bean.UsuarioBean;

/**
 *
 * @author Administrador
 */
public interface UsuarioService {
     public boolean create(UsuarioBean usuario);
    public ArrayList<UsuarioBean> read(UsuarioBean usuario);
    public UsuarioBean read(int idUsuario);
    public boolean update(UsuarioBean usuario);
    public boolean delete(int idUsuario);
    public int comprobarExistencia(String mail);
    
}
