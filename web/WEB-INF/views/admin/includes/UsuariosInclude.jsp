<%-- 
    Document   : CategoriasInclude
    Created on : Nov 10, 2017, 11:55:48 AM
    Author     : Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
--%>
<%@page import="helpers.AppHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.bean.UsuarioBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<% List<UsuarioBean> usuarios=(ArrayList <UsuarioBean>) request.getAttribute("usuarios");%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Usuarios</h1> 
    </div>
    <!-- /.col-lg-12 --
    +--------------------+------------------+------+-----+---------+----------------+
| Field              | Type             | Null | Key | Default | Extra          |
+--------------------+------------------+------+-----+---------+----------------+
| idUsuario          | int(11) unsigned | NO   | PRI | NULL    | auto_increment |
| nombre             | varchar(120)     | NO   |     |         |                |
| fecha_nacimiento   | date             | NO   |     | NULL    |                |
| sexo               | tinyint(1)       | NO   |     | NULL    |                |
| calle_numero       | varchar(120)     | NO   |     |         |                |
| colonia_cp         | varchar(120)     | NO   |     |         |                |
| ciudad_estado      | varchar(120)     | NO   |     |         |                |
| username           | varchar(70)      | NO   |     |         |                |
| password           | varchar(120)     | NO   |     |         |                |
| tipo_usuario       | tinyint(1)       | NO   |     | NULL    |                |
| imagen_usuario     | varchar(150)     | YES  |     | NULL    |                |
| fecha_creacion     | datetime         | NO   |     | NULL    |                |
| fecha_modificacion | datetime         | NO   |     | NULL    |                |
+--------------------+------------------+------+-----+---------+----------------+>
</div>
<!-- /.row -->
<div class="row">
    <div class="col-sm-12">
        <table class="table table-responsive table-bordered table-striped table-hover">
            <tr>
                <th>#</th>
                <th>Nombre</th>
                <th>Fecha de Nacimiento</th>
                <th>Sexo</th>
                <th>Calle Numero</th>
                <th>Colonia CP</th>
                <th>Ciudad estado</th>
                <th>Username</th>
                <th>Password</th>
                <th>Tipo de usuario</th>
                <th>Imagen</th>
                <th>Fecha de creacion</th>
                <th>Fecha de modificacion</th>
                <th>Acciones</th>
            </tr>
            <% if (usuarios != null) {
                for(UsuarioBean usuario : usuarios) { %>
                    <tr>
                        <td><%=usuario.getIdUsuario()%></td>
                        <td><%=usuario.getNombre()%></td>
                        <td><%=usuario.getFechaNacimiento()%></td>
                        <td><%=usuario.getSexo()%></td>
                        <td><%=usuario.getCalleNumero()%></td>
                        <td><%=usuario.getColoniaCP()%></td>
                        <td><%=usuario.getCiudadEstado()%></td>
                        <td><%=usuario.getUsername()%></td>
                        <td><%=usuario.getPassword()%></td>
                        <td><%=usuario.getTipoUsuario()%></td>
                        <td><img src=../images/usuarios/<%=usuario.getImagenUsuario()%> style="width:200px;text-align:center"></td>
                        <td><%=usuario.getFechaCreacion()%></td>
                        <td><%=usuario.getFechaModificacion()%></td>
                        
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