<%-- 
    Document   : NavInclude
    Created on : Nov 7, 2017, 8:36:54 AM
    Author     : Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
--%>
<%@page import="helpers.AppHelper"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%
    HttpSession sesiones = request.getSession();
%>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html">¡Hola <%=sesiones.getAttribute("nombre")%>!</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="#"><i class="fa fa-user fa-fw"></i> Mi cuenta</a>
                </li>
                <li class="divider"></li>
                <li><a href="<%=AppHelper.baseUrl()%>logout"><i class="fa fa-sign-out fa-fw"></i> Salir</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li>
                    <a href="<%=AppHelper.baseUrl()%>admin/principal">
                        <i class="fa fa-home fa-fw"></i> 
                        Inicio
                    </a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-users fa-fw"></i> Usuarios<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="<%=AppHelper.baseUrl()%>admin/usuarios/agregar">
                                <i class="fa fa-plus-circle"></i>   
                                Agregar usuario
                            </a>
                        </li>
                        <li>
                            <a href="<%=AppHelper.baseUrl()%>admin/usuarios">
                                <i class="fa fa-pencil-square-o"></i>   
                                Gestionar usuarios
                            </a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-cubes fa-fw"></i> Productos<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="flot.html">
                                <i class="fa fa-plus-circle"></i>   
                                Agregar producto
                            </a>
                        </li>
                        <li>
                            <a href="morris.html">
                                <i class="fa fa-pencil-square-o"></i>   
                                Gestionar productos
                            </a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-bookmark fa-fw"></i> Categorías<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="<%=AppHelper.baseUrl()%>admin/categorias/agregar">
                                <i class="fa fa-plus-circle"></i>   
                                Agregar categoría
                            </a>
                        </li>
                        <li>
                            <a href="<%=AppHelper.baseUrl()%>admin/categorias">
                                <i class="fa fa-pencil-square-o"></i>   
                                Gestionar categorías
                            </a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="tables.html"><i class="fa fa-star fa-fw"></i> Clientes</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-line-chart fa-fw"></i> Resportes<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="panels-wells.html">
                                <i class="fa fa-money"></i>
                                Reporte de ventas
                            </a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="<%=AppHelper.baseUrl()%>salir"> <i class="fa fa-sign-out"></i> Salir</a> 
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>