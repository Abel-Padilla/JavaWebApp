
package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.bean.UsuarioBean;
import models.connection.ConMySQL;
import models.service.LoginService;
import helpers.AppHelper;

/**
 *
 * @author Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
 */
public class LoginDAO implements LoginService {
    
    /*
    Conexion a la base de datos
    */
    private ConMySQL conexion;
    
    /*
    Constructor
    */
    public LoginDAO() {
        this.conexion = new ConMySQL();
    }

    @Override
    public UsuarioBean read(UsuarioBean usuario) {
        try {
            String consulta = "SELECT u.idUsuario, "
                    + "u.nombre, u.username, u.password, "
                    + "u.tipo_usuario FROM usuario u "
                    + "WHERE u.username like binary ?";
            
            PreparedStatement ps = this.conexion.
                    getCon().prepareCall(consulta);
            
            /*
            Reemplazar los signos de interogación
            */
            ps.setString(1, usuario.getUsername());
            
            ResultSet rs = ps.executeQuery();
            
            /*
            Si la consulta tiene registros
            */
            if(rs.next()) {
                /*
                Mandamos los datos de regreso a la vista
                */
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTipoUsuario(rs.getInt("tipo_usuario"));
                
                return usuario;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
