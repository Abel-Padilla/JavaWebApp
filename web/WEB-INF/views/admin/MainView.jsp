<%-- 
    Document   : MainView.jsp
    Created on : Oct 31, 2017, 8:34:50 AM
    Author     : Raul Zavaleta <raul.zavaletazea@gmail.com at kiapp.mx>
--%>

<%@page import="helpers.AppHelper"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%
    /*
    Tomamos los valores de las rutas
    de los includes
    */
    String urlNav  = "includes/"+request.getAttribute("nav").toString();
    String urlBody = "includes/"+request.getAttribute("body").toString();
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=AppHelper.baseUrl()%>vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=AppHelper.baseUrl()%>vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=AppHelper.baseUrl()%>dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=AppHelper.baseUrl()%>vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
    <div id="wrapper">
        <!-- Navigation -->
        <jsp:include page="<%=urlNav%>" flush="true" />

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <jsp:include page="<%=urlBody%>" flush="true" />
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=AppHelper.baseUrl()%>vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=AppHelper.baseUrl()%>vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=AppHelper.baseUrl()%>vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=AppHelper.baseUrl()%>dist/js/sb-admin-2.js"></script>

</body>

</html>
