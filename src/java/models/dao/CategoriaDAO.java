/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.bean.CategoriaBean;
import models.connection.ConMySQL;
import models.service.CategoriaService;

/**
 *
 * @author kame
 */
public class CategoriaDAO implements CategoriaService{
    private ConMySQL conexion;

    @Override
    public boolean create(CategoriaBean categoria) {
    try{
        this.conexion=new ConMySQL();
        String query = "insert into categoria values (null,'"+categoria.getNombre()+"','"+categoria.getImagen()+"',1)";
        System.out.println(query);
        PreparedStatement ps;
        ps=(PreparedStatement) this.conexion.getCon().prepareStatement(query);
        int rs =ps.executeUpdate(query);
        System.out.println(query);
        return true;
    }
    catch(Exception e){
       e.printStackTrace();
    }
    return false;  
    }

    @Override
    public ArrayList<CategoriaBean> read(CategoriaBean categoria) {
        try{
            this.conexion = new ConMySQL();
            String consulta ="select * from categoria WHERE estatus =1";
            PreparedStatement ps;
           ps = (PreparedStatement) this.conexion.getCon().prepareStatement(consulta);
            //Ejecutamos la consulta y guardamos la consulta 
          ResultSet  rs=ps.executeQuery();
          
          ArrayList<CategoriaBean> categorias= new ArrayList<CategoriaBean>();
          //Mientras la consulta tenga resgistros
                    while(rs.next()){
                        //creamos una categoria, para sacar los datos de la categoria de la BD
                        categoria = new CategoriaBean();
                        categoria.setCategoria(rs.getInt("id_Categoria"));
                        categoria.setNombre(rs.getString("nombre"));
                        categoria.setImagen(rs.getString("imagen_categoria"));
                        categoria.setEstatus(rs.getInt("estatus"));
                        
                        //Agregamos esta categoria al arreglo de categorias
                        categorias.add(categoria);

                    }
                    //Cerramos la conexion a la base de datlos
                    this.conexion.getCon().close();
                    return categorias;
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public CategoriaBean read(int idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CategoriaBean categoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int comprobarExistencia(String nombre) {
        int coincidencias=0;
        try{
            this.conexion=new ConMySQL();
            String query="SELECT * FROM categoria where nombre like '"+nombre+"'";
              PreparedStatement ps = (PreparedStatement) this.conexion.getCon().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                coincidencias++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return coincidencias;
    }
    
}
