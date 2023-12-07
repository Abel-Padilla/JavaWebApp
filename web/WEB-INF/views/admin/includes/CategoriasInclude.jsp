<%-- 
    Document   : CategoriasInclude
    Created on : Nov 10, 2017, 11:55:48 AM
    Author     : Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
--%>
<%@page import="helpers.AppHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.bean.CategoriaBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<% List<CategoriaBean> categorias=(ArrayList <CategoriaBean>) request.getAttribute("categorias");%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Categorías</h1> 
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-sm-12">
        <table class="table table-responsive table-bordered table-striped table-hover">
            <tr>
                <th>#</th>
                <th>Nombre</th>
                <th>Imagen</th>
                <th>Acciones</th>
            </tr>
            <% if (categorias != null) {
                for(CategoriaBean categoria : categorias) { %>
                    <tr>
                        <td><%=categoria.getCategoria()%></td>
                        <td><%=categoria.getNombre()%></td>
                        <td><img src=../images/categorias/<%=categoria.getImagen()%> style="width:200px;text-align:center"></td>
                        <td>
                            <div class="btn-group">
                                <a href="#" class="btn btn-warning">
                                    <i class="fa fa-pencil"></i> 
                                </a>
                                <a href="#" class="btn btn-danger">
                                    <i class="fa fa-trash"></i>
                                </a>
                            </div>
                        </td>
                    </tr>
                <% }
            } %>
        </table>
    </div>
</div>