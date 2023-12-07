package controllers.admin;

import helpers.AppHelper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
 */
@WebServlet(name="PrincipalController", urlPatterns={"/admin/principal"})
public class PrincipalController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        /*
        -Si el usuario tiene sesiones y es administrador
         mostrar su nombre
        -Si tiene sesiones, pero NO es 
         adminsitrador, mandar al login con el mensaje: 
         "solo personal autorizado"
        -Si no tiene sesiones mandar al login con el 
        mensaje "acceso restringido"
        */
        HttpSession sesiones = request.getSession(false);
        
        /*
        Revisamos si tenemos acceso
        */
        if(AppHelper.tieneAcceso(sesiones, 1)) {
            /* creamos variables */
                request.setAttribute("titulo", "Inicio");
                request.setAttribute("nav", "NavInclude.jsp");
                request.setAttribute("body", "InicioInclude.jsp");
                /*
                Mostramos la vista principal
                */
                request.
                getRequestDispatcher("/WEB-INF/views/admin/MainView.jsp").
                forward(request, response);
            
        }
        
        /* si no hay sesiones */
        else {
            request.setAttribute("error", "Acceso restringido");
            request.getRequestDispatcher("/WEB-INF/views/LoginView.jsp").forward(request, response);
        }
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

}
