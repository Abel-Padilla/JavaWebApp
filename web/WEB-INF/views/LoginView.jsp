<%-- 
    Document   : LoginView
    Created on : Oct 16, 2017, 10:37:09 AM
    Author     : Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
--%>

<%@page import="helpers.AppHelper"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <meta charset="utf-8">
        <title>LoginView</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no,user-scalable=0, minimum-scale=1,maximum-scale=1"/>
        <meta name="description" content="LoginView">
        <meta name="author" content="Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>">
        <link rel="stylesheet" href="<%=AppHelper.baseUrl()%>css/bootstrap.min.css" />
        <!-- Referencias a JavaScript de jQuery y Bootstrap -->
        <script src=""></script>
        <script src="<%=AppHelper.baseUrl()%>js/jquery-3.2.1.min.js"></script>
        <script src="<%=AppHelper.baseUrl()%>js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <form class="row" method="post" action="<%=AppHelper.baseUrl()%>login/auth">
                    <div class="col-sm-12">
                        <h3 class="text-center">Iniciar Sesión</h3>
                    </div>
                    
                    <div class="col-sm-12 text-center" style="margin-bottom: 20px;">
                        <img src="<%=AppHelper.baseUrl()%>images/ninja.png" 
                             alt="Iniciar sesión" 
                             class="img img-circle"
                             style="margin: auto !important;" />
                    </div>
                             
                    <!-- Mensaje de error -->
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
                    
                    <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
                        <div class="form-group">
                            <input type="text" 
                                   name="username" 
                                   id="username" 
                                   class="form-control" 
                                   placeholder="Usuario" 
                                   value="admin@admin.com"
                                   required />
                        </div>
                    </div>
                    
                    <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
                        <div class="form-group">
                            <input type="password" 
                                   name="password" 
                                   id="password" 
                                   class="form-control" 
                                   placeholder="Contraseña" 
                                   value="1234ABCD"
                                   required />
                        </div>
                    </div>
                    <div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
                        <div class="form-group">
                            <button class="btn btn-warning" type="submit">
                                Iniciar Sesión
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
