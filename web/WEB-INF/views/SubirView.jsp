<%-- 
    Document   : SubirView
    Created on : Nov 1, 2017, 10:55:28 AM
    Author     : Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
--%>

<%@page import="helpers.AppHelper"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en"> 
    <head>
        <meta charset="utf-8">
        <title>SubirView</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no,user-scalable=0, minimum-scale=1,maximum-scale=1"/>
        <meta name="description" content="SubirView">
        <meta name="author" content="Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>">
        <link rel="stylesheet" href="<%=AppHelper.baseUrl()%>css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <form class="row" method="post" 
                  action="<%=AppHelper.baseUrl()%>subir/imagen" 
                  enctype="multipart/form-data">
                
                <div class="col-sm-12">
                    <h3>Agregar imagen</h3>
                </div>
                
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="imagen" class="control-label">Imagen</label>
                        <input type="file" name="imagen" id="imagen" class="form-control" />
                    </div>
                </div>
                
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="descripcion" class="control-label">Descripción</label>
                        <textarea name="descripcion" id="descripcion" class="form-control" required rows="3"></textarea>
                    </div>
                </div>
                
                <div class="col-sm-12">
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Subir </button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
