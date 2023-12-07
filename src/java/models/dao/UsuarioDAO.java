/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.bean.UsuarioBean;
import models.connection.ConMySQL;
import models.service.UsuarioService;

/**
 *
 * @author Administrador
 */
public class UsuarioDAO implements UsuarioService{
    private ConMySQL conexion;
    
 
    @Override
    public boolean create(UsuarioBean usuario) {
        try{
            this.conexion=new ConMySQL();
            String query="insert into usuario values (null,'"+usuario.getNombre()+"','"+usuario.getFechaNacimiento()+"',"+usuario.getSexo()+",'"+usuario.getCalleNumero()+"','"+usuario.getColoniaCP()+"','"+usuario.getCiudadEstado()+"','"+usuario.getUsername()+"','"+usuario.getPassword()+"',"+usuario.getTipoUsuario()+",'"+usuario.getImagenUsuario()+"',"+"now(),now())";
            System.out.println(query);
            PreparedStatement ps;
            ps=(PreparedStatement)this.conexion.getCon().prepareStatement(query);
            int rs = ps.executeUpdate(query);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
      
    }

    @Override
    public ArrayList<UsuarioBean> read(UsuarioBean usuario) {
       try{
            this.conexion = new ConMySQL();
            String consulta ="select * from usuario";
            PreparedStatement ps;
           ps = (PreparedStatement) this.conexion.getCon().prepareStatement(consulta);
            //Ejecutamos la consulta y guardamos la consulta 
           ResultSet  rs=ps.executeQuery();
          
          ArrayList<UsuarioBean> usuarios= new ArrayList<UsuarioBean>();
          //Mientras la consulta tenga resgistros
                    while(rs.next()){
                        //creamos una categoria, para sacar los datos de la categoria de la BD
                        usuario = new UsuarioBean();
                        usuario.setIdUsuario(rs.getInt("idUsuario"));
                        usuario.setNombre(rs.getString("nombre"));
                        usuario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                        usuario.setSexo(rs.getInt("sexo"));
                        usuario.setCalleNumero(rs.getString("calle_numero"));
                        usuario.setColoniaCP(rs.getString("colonia_cp"));
                        usuario.setCiudadEstado(rs.getString("ciudad_estado"));
                        usuario.setUsername(rs.getString("username"));
                        usuario.setPassword(rs.getString("password"));
                        usuario.setTipoUsuario(rs.getInt("tipo_usuario"));
                        usuario.setImagenUsuario(rs.getString("imagen_usuario"));
                        usuario.setFechaCreacion(rs.getString("fecha_creacion"));
                        usuario.setFechaModificacion(rs.getString("fecha_modificacion"));
                        
                       
                        
                        //Agregamos esta categoria al arreglo de categorias
                        usuarios.add(usuario);

                    }
                    //Cerramos la conexion a la base de datlos
                    this.conexion.getCon().close();
                    return usuarios;
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UsuarioBean read(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UsuarioBean usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int comprobarExistencia(String mail) {
        int coincidencias=0;
        try{
            
            this.conexion=new ConMySQL();
            String query = "SELECT * from usuario where username like binary '"+mail+"'";
            PreparedStatement ps = this.conexion.getCon().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                coincidencias++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Coincidencias de mail en la base de datos:  "+coincidencias);
        return coincidencias;
    }
    
    
    
}
