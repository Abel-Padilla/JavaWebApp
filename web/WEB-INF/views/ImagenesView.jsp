<%-- 
    Document   : ImagenesView
    Created on : Nov 1, 2017, 12:35:01 PM
    Author     : Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
--%>

<%@page import="helpers.AppHelper"%>
<%@page import="models.bean.ImagenBean"%>
<%@page import="models.bean.UsuarioBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <meta charset="utf-8">
        <title>ImagenesView</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no,user-scalable=0, minimum-scale=1,maximum-scale=1"/>
        <meta name="description" content="ImagenesView">
        <meta name="author" content="Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>">
        <link rel="stylesheet" href="css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <table class="table table-bordered table-hover table-responsive">
                        <tr>
                            <th>Imagen</th>
                            <th colspan="2">Descripción</th>
                        </tr>
                        
                        <%
                            ArrayList<ImagenBean> imagenes = (ArrayList<ImagenBean>) request.getAttribute("imagenes");
                            if(imagenes != null) {
                                for(int i = 0; i < imagenes.size(); i++) {
                                    %>
                                    <tr>
                                        <td class="col-sm-4">
                                            <img src="<%=AppHelper.baseUrl()%>images/subidas/<%=imagenes.get(i).getImagen()%>" class="img img-responsive" />
                                        </td>
                                        <td class="col-sm-5"><%=imagenes.get(i).getDescripcion()%></td>
                                        <td class="col-sm-3">
                                            <a href="<%=AppHelper.baseUrl()%>editar/imagen?id=<%=imagenes.get(i).getImagen()%>" class="btn  btn-primary">Editar</a>
                                            <a class="btn  btn-danger">Eliminar</a>
                                        </td>
                                    </tr>
                                    <%
                                }
                            }
                            
                        %>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
