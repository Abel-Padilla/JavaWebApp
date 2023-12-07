/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import models.bean.UsuarioBean;
import models.dao.UsuarioDAO;

/**
 *
 * @author Administrador
 */
@WebServlet(name="UsuarioController", urlPatterns={"/admin/usuarios"})
public class UsuarioController extends HttpServlet {
private UsuarioDAO usuarioDAO;
private UsuarioBean usuarioBean;

public UsuarioController(){
    usuarioDAO=new UsuarioDAO();
    usuarioBean=new UsuarioBean();
}


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession sesiones=request.getSession(false);
        if(AppHelper.tieneAcceso(sesiones, 1)){
            switch(request.getServletPath()){
                case "/admin/usuarios":
                    request.setAttribute("usuarios", usuarioDAO.read(null));
                    //agregar los oncludes
                    request.setAttribute("nav", "NavInclude.jsp");
                    request.setAttribute("body", "UsuariosInclude.jsp");
                    
                    request.getRequestDispatcher("/WEB-INF/views/admin/MainView.jsp").forward(request, response);                            
                break;
                
                case "/admin/usuarios/agregar":
                    request.setAttribute("nav", "NavInclude.jsp");
                    request.setAttribute("body", "AgregarUsuarioInclude.jsp");                    
                    request.getRequestDispatcher("/WEB-INF/views/admin/MainView.jsp").forward(request, response);                    
                    break;
            }
            
        }
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
      
    }

}