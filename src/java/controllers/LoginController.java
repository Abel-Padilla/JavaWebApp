package controllers;

import helpers.AppHelper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.bean.UsuarioBean;
import models.dao.LoginDAO;

/**
 *
 * @author Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        /*
        Cargamos la vista de login
        */
        PrintWriter out = response.getWriter();
        
        request.getRequestDispatcher("WEB-INF/views/LoginView.jsp").forward(request, response);
      
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        /*
        Tomamos la URL
        */
        PrintWriter out = response.getWriter();
        switch(request.getServletPath()) {
            case "/login/auth": 
                out.println("En el Login");
                
                /*
                Tenemos el usuario y la contraseña 
                dorectamente en la variable request
                */
                UsuarioBean usuario = new UsuarioBean();
                usuario.setUsername(request.getParameter("username"));
                usuario.setPassword(request.getParameter("password"));
                
                /*
                Comparamos al usuario en la base de datos
                */
                LoginDAO login = new LoginDAO();
                usuario = login.read(usuario);
                
                /*
                Si el usuario existe en la bd
                */
                if (usuario != null) {
                    out.println("Usuario correcto");
                    /*Tomamos el password de la vista*/
                    String password = request.getParameter("password");
                    /*Encriptamos  el password de la vista*/
                    password = AppHelper.convetirMD5(password);
                    
                    /*
                    Si las contraseñas son iguales 
                    */
                    if (password.equals(usuario.getPassword())) {
                        
                        /*Creamos una variable de sesiones*/
                        HttpSession sesiones = request.getSession(false);
                        
                        /*agregamos las sesiones*/
                        sesiones.setAttribute("idUsuario", usuario.getIdUsuario());
                        sesiones.setAttribute("username", usuario.getUsername());
                        sesiones.setAttribute("nombre", usuario.getNombre());
                        sesiones.setAttribute("tipoUsuario", usuario.getTipoUsuario());
                        
                        /*
                        Evaluamos el tipo de usuario
                        */
                        switch(usuario.getTipoUsuario()) {
                            case 1 : 
                                out.println("Bienvenido Admin");
                                /*Redireccionar a Administrador*/
                                response.sendRedirect(AppHelper.baseUrl()+"admin/principal");
                                break;
                                
                            case 2 : 
                                out.println("Hola Empleado");
                                response.sendRedirect(AppHelper.baseUrl()+"tienda/principal");
                                break;
                            
                            case 3 : 
                                out.println("Hola cliente");
                                response.sendRedirect("clientes/principal");
                                break;
                        }
                        
                    }
                    /*Cuando las contraseñas son incorrectas*/
                    else {
                        /*Vamos a Agregar un mensaje para 
                        enviar a la vista*/
                        request.
                        setAttribute("error", 
                                "Usuario/Contraseña incorrectos");
                        request.
                            getRequestDispatcher("/WEB-INF/views/LoginView.jsp")
                            .forward(request, response);
                    }
                    
                }
                
                /*
                Si no existe
                */
                else {
                    request.
                        setAttribute("error", 
                                "Usuario/Contraseña incorrectos");
                        request.
                            getRequestDispatcher("/WEB-INF/views/LoginView.jsp")
                            .forward(request, response);
                }
                
                break;
        }

    }

}
