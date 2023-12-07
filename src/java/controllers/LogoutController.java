package controllers;

import helpers.AppHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
 */
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
         /*
        Creamos las sesiones
        */
        HttpSession sesiones = request.getSession(false);
        
        /* Si hay sesiones, las borramos */
        if (sesiones!= null) {
            sesiones.invalidate();
        }
        
        /* Redireccionamos al Login */
        response.sendRedirect(AppHelper.baseUrl()+"login");
      
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

}
