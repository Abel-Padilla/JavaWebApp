
package helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
 */

/*
Las clases final no se pueden heredar 
*/
public final class AppHelper {
    
    /*
    Singleton
    */
    private AppHelper() {
        
    }
    
    /*
    Los helpers son clases que contienen funcionalidades
    que no se pueden ligar directamente ni aun modelo, 
    ni a una vista ni a un controlador
    
    Todos los metodos dentro de un helper 
    DEBEN SER ESTATICOS
    */
    public static String convetirMD5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(text.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Metodo que retorna la url absoluta 
     * del proyecto
     */
    public static String baseUrl() {
        return "http://localhost:8080/T-172_Ejemplo_DAII_Full/";
    }
    
    /**
     * 
     * @param sesiones las sesione sinvocadas en el controlador
     * @param tipoUSuario el tipo de usuario
     * @return verdadero cuando el usuario tiene acceso con sesiones
     *         y falso cuando no tiene acceso
     */
    public static boolean tieneAcceso(HttpSession sesiones, int tipoUSuario) {
        if (sesiones != null) {
            if (sesiones.getAttribute("tipoUsuario").equals(tipoUSuario)) {
                return true;
            }   
        }
        return false;
    }
    
    public static String defaultController () {
        return "login";
    }
    
    public static String urlImagenCategorias(){
        return "C:/Users/Administrador/Documents/NetBeansProjects/Proyecto T-172/CODIGO/T-172 Ejemplo DAII Full/web/images/categorias/";
    }
    
}
