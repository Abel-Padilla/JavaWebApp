/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import models.bean.CategoriaBean;
import models.dao.CategoriaDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Administrador
 */
public class AgregarCategoriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("nav", "NavInclude.jsp");
        request.setAttribute("body", "AgregarCategoriaInclude.jsp");
        request.getRequestDispatcher("/WEB-INF/views/admin/MainView.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        switch(request.getRequestURI()){
            case "/T-172_Ejemplo_DAII_Full/admin/categorias/agregar"://Si URI es correcto
                CategoriaBean bean;//Crear bean
                CategoriaDAO dao;//Crear dao
                
                bean=new CategoriaBean();//Inicializar bean
                dao=new CategoriaDAO();//Inicializar dao
                
               
                
                if(ServletFileUpload.isMultipartContent(request)){//Revisar si el formulario es multipart
                    try{
                        List<FileItem>multiparts;//Crear un array list para guardar los valores de los campos como objetos
                    multiparts=new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);//Inicializar a multiparts
                    for(FileItem item : multiparts){//For each mejorado para recorrer la lista de campos disponibles en la vista
                        if(item.isFormField()){//Si es un campo de texto
                            if(item.getFieldName().equals("nombre")){//Si el campo de texto se llama nombre
                             
                                 bean.setNombre(item.getString());//Obtiene el valor del item guardado en el array list
                            }
                            
                           
                        }
                        else{//Si entra aqui quiere decir que es un archivo
                        //Subir el archivo al servidor
                            String ruta ="C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Proyecto T-172\\CODIGO\\T-172 Ejemplo DAII Full\\web\\images\\categorias\\";
                            String nombreArchivo=new File(item.getName()).getName();
                            File nuevoArchivo=new File(ruta+nombreArchivo);
                            bean.setImagen(nuevoArchivo.getName());
                            //Escribimos los cambios
                            item.write(nuevoArchivo);
                            
                    }
                        
                    }
                    if(dao.comprobarExistencia(bean.getNombre())==0){
                      dao.create(bean);
                      response.sendRedirect(AppHelper.baseUrl()+"admin/categorias");
                    }
                    else{
                        request.setAttribute("nav", "NavInclude.jsp");
                        request.setAttribute("body", "AgregarCategoriaInclude.jsp");
                        request.setAttribute("error", "La categoría ya existe!");
                        request.getRequestDispatcher("/WEB-INF/views/admin/MainView.jsp").forward(request, response);
                        
                    }
                    }
                    catch(Exception e){
                    e.printStackTrace();
                }
                }
                
        }
        
    }
}

