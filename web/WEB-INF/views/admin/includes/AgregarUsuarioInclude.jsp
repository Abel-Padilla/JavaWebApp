<%-- 
    Document   : AgregarUsuarioInclude
    Created on : 17/11/2017, 07:01:53 PM
    Author     : Administrador
--%>

<%@page import="helpers.AppHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<%=AppHelper.baseUrl()%>js/jquery-3.2.1.min.js"></script>
        <script src="<%=AppHelper.baseUrl()%>js/bootstrap.min.js"></script>
<!DOCTYPE html>
<form action="<%=AppHelper.baseUrl()%>admin/usuarios/agregar" method="post" enctype="multipart/form-data">
<div class="jumbotron" style="margin: 10%">
    <div class="panel-title">
        <h2>Registra un usuario</h2>
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
            Datos del usuario
        </h4>
    
    </div>
    <div class="panel-body">
    <div class="col-sm-6">
        <input type="text" class="form-control" required placeholder="Nombre" name="nombre">
    </div>
        <div class="col-sm-3">
            <input type="date" class="form-control" required placeholder="dd/mm/aaaa" name="fechanacimiento">
            <label> Fecha de Nacimiento</label>
        </div>
        <div class="col-sm-3">
            <select class="form-control" name="sexo">
                <option value="0" > Seleccionar sexo</option>
                <option value="1" >Mujer
                </option>
                <option value="2" >Hombre
                    
                </option>
            </select>
        </div>
        
        <div class="col-sm-4">
            <input type="text" class="form-control" required placeholder="Calle y número" name="callenumero">
            <label>Calle y numero</label>
        </div>
        <div class="col-sm-4">
            <input type="text" class="form-control" required placeholder="Colonia CP" name="coloniacp">
            <label>Colonia CP</label>
        </div>
        <div class="col-sm-4">
            <input type="text" class="form-control" required placeholder="Ciudad Estado" name="ciudadestado">
            <label>Ciudad Estado</label>
        </div> 
        <div class="col-sm-6">
            <input type="email" class="form-control" required placeholder="E-mail" name="username">
            <label>Username</label>
        </div>
        <div class="col-sm-6">
            <input type="password" class="form-control" required placeholder="Password" name="password">
            <label>Clave de acceso</label>
        </div>
        <div class="col-sm-4">
            <select class="form-control" name="tipousuario">
                <option value="0"> 
                    Selecciona tipo de usuario
                </option>
                <option value="1">
                    Super Administrador
                </option>
                <option value="2">
                    Empleado
                </option>
                
            </select>
            <label>
                Tipo de usuario
            </label>
        </div>
        
    <div class="col-sm-6">
        <input type="file" name="imagen">
        <label>Imagen del perfil</label>
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
