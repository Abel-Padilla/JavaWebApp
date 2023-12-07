<%-- 
    Document   : AgregarCategoriaView
    Created on : 16/11/2017, 07:59:19 PM
    Author     : Administrador
--%>

<%@page import="helpers.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="<%=AppHelper.baseUrl()%>admin/categorias/agregar" method="post" enctype="multipart/form-data">
<div class="jumbotron" style="margin: 10%">
    <div class="panel-title">
        <h2>Registra una categoría</h2>
    </div>
     <!--MENSAJE DE ERROR SI SE PRESENTAN DUPLICADOS--->
     <% if (request.getAttribute("error") != null) { %>
                        <div class="col-sm-4 col-sm-offset-4">
                            <div class="alert alert-danger fade in alert-dismissable">
                                <a href="#" class="close" data-dismiss="alert">x</a>
                                <strong>¡Error!</strong> 
                                <%=request.getAttribute("error")%>
                            </div>
                        </div>
                    <% } %>
                    <!-- **************** -->
    <hr>
    <div class="col-sm-12">
        <h4>
            Datos de la categoría
        </h4>
    
    </div>
    <div class="panel-body">
    <div class="col-sm-6">
        <input type="text" class="form-control" required placeholder="Nombre de la categoría" name="nombre">
    </div>
    <div class="col-sm-6">
        <input type="file" name="imagen">
    </div>
        <div class="col-sm-12">
            <label>
                &nbsp;
            </label>  
        </div>
        <div class="col-sm-12">
            <input type="submit" class="btn btn-success btn-group-justified" value="Guardar">
        </div>
  
    </div>
</div>
  </form>
