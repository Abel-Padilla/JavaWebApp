package controllers.admin;

import helpers.AppHelper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.bean.CategoriaBean;
import models.dao.CategoriaDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author goyor
 */
public class CategoriaController extends HttpServlet {
    
    private CategoriaDAO categoriaD;
    private CategoriaBean categoriaB;
    
   public CategoriaController(){
       categoriaD=new CategoriaDAO();
       categoriaB=new CategoriaBean();
   }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession sesiones=request.getSession(false);
        if(AppHelper.tieneAcceso(sesiones, 1)){
            switch(request.getServletPath()){
                case "/admin/categorias":
                    request.setAttribute("categorias", categoriaD.read(null));
                    //agregar los oncludes
                    request.setAttribute("nav", "NavInclude.jsp");
                    request.setAttribute("body", "CategoriasInclude.jsp");
                    
                    request.getRequestDispatcher("/WEB-INF/views/admin/MainView.jsp").forward(request, response);                            
                break;
                
                case "/admin/categorias/agregar":
                    request.setAttribute("nav", "NavInclude.jsp");
                    request.setAttribute("body", "AgregarCatInclude.jsp");                    
                    request.getRequestDispatcher("/WEB-INF/views/admin/MainView.jsp").forward(request, response);                    
                    break;
            }
            
        }

        
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
       
}
    
    
}