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
import models.bean.UsuarioBean;
import models.dao.UsuarioDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Administrador
 */
public class AgregarUsuarioController extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         request.setAttribute("nav", "NavInclude.jsp");
        request.setAttribute("body", "AgregarUsuarioInclude.jsp");
        request.getRequestDispatcher("/WEB-INF/views/admin/MainView.jsp").forward(request, response);

    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        out.print(request.getRequestURI());
        
        switch(request.getRequestURI()){
            case "/T-172_Ejemplo_DAII_Full/admin/usuarios/agregar":
                UsuarioDAO dao=new UsuarioDAO();
                UsuarioBean bean = new UsuarioBean();
                
                 if(ServletFileUpload.isMultipartContent(request)){//Revisar si el formulario es multipart
                    try{
                        List<FileItem>multiparts;//Crear un array list para guardar los valores de los campos como objetos
                    multiparts=new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);//Inicializar a multiparts
                    for(FileItem item : multiparts){//For each mejorado para recorrer la lista de campos disponibles en la vista
                        if(item.isFormField()){//Si es un campo de texto
                            if(item.getFieldName().equals("nombre")){//Si el campo de texto se llama nombre
                             
                                 bean.setNombre(item.getString());//Obtiene el valor del item guardado en el array list
                            }
                            
                             if(item.getFieldName().equals("fechanacimiento")){//Si el campo de texto se llama nombre
                             
                                 bean.setFechaNacimiento(item.getString());//Obtiene el valor del item guardado en el array list
                            }
                             
                               if(item.getFieldName().equals("sexo")){//Si el campo de texto se llama nombre
                             
                                 bean.setSexo(Integer.parseInt(item.getString()));//Obtiene el valor del item guardado en el array list
                            }
                               if(item.getFieldName().equals("callenumero")){
                                   bean.setCalleNumero(item.getString());
                               }
                               if(item.getFieldName().equals("callenumero")){
                                   bean.setCalleNumero(item.getString());
                               }
                                if(item.getFieldName().equals("coloniacp")){
                                   bean.setColoniaCP(item.getString());
                               }
                                 if(item.getFieldName().equals("ciudadestado")){
                                   bean.setCiudadEstado(item.getString());
                               }
                                  if(item.getFieldName().equals("username")){
                                   bean.setUsername(item.getString());
                               }
                                   if(item.getFieldName().equals("password")){
                                   bean.setPassword(AppHelper.convetirMD5(item.getString()));
                               }
                                    if(item.getFieldName().equals("tipousuario")){
                                   bean.setTipoUsuario(Integer.parseInt(item.getString()));
                               }
                                    
                               
                            
                            
                           
                        }
                        else{//Si entra aqui quiere decir que es un archivo
                        //Subir el archivo al servidor
                            String ruta ="C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Proyecto T-172\\CODIGO\\T-172 Ejemplo DAII Full\\web\\images\\usuarios\\";
                            String nombreArchivo=new File(item.getName()).getName();
                            File nuevoArchivo=new File(ruta+nombreArchivo);
                            bean.setImagenUsuario(nuevoArchivo.getName());
                            //Escribimos los cambios
                            item.write(nuevoArchivo);
                            
                            
                    }
                        
                    }
                    if(dao.comprobarExistencia(bean.getUsername())==0){
                      dao.create(bean);
                      response.sendRedirect(AppHelper.baseUrl()+"admin/usuarios");
                    }
                    else{
                        request.setAttribute("nav", "NavInclude.jsp");
                        request.setAttribute("body", "AgregarUsuarioInclude.jsp");
                        request.setAttribute("error", "El mail ya está en uso");
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