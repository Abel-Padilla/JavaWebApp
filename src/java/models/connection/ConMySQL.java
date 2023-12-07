
package models.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConMySQL {
    
    /*
        Vamos a crear una conexion a MySQL y la vamos a 
        guardar en un atributo de tipo Connection
    */
    private Connection con;
    private final String DB_USUARIO  = "root";
    private final String DB_PASSWORD = "root";
    private final String DB_NOMBRE   = "t172_ejemplo_full";
    private final int DB_PUERTO      = 3306;
    private final String DB_SERVIDOR = "localhost";
    
    /*
        Creamos un constructor que permite la conexion 
        a MySQL con los datos de las constantes
    */
    public ConMySQL() {
        try {
            /*
            Creamos una instancia del driver de 
            MySQL
            */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            /*
            Guardamos la conexion en nuestro atributo 'con'
            */
            this.con = DriverManager
                .getConnection(
                    //driver, servidor, puerto, db
                    "jdbc:mysql://"+DB_SERVIDOR+":"+DB_PUERTO+"/"+DB_NOMBRE,
                    //Usuario MySQL
                    DB_USUARIO,
                    //Password MySQL
                    DB_PASSWORD
                );
            
        }
        catch(Exception e) {
            
            this.con = null;
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }
    
}
