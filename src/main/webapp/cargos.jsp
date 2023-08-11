<%-- 
    Document   : cargos.jsp
    Created on : 21/09/2022, 08:28:00 PM
    Author     : jhons
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
HttpSession misession= (HttpSession) request.getSession();
String usuario= (String) misession.getAttribute("usuario");
String estado= (String) misession.getAttribute("estado");
if(misession == null || misession.getAttribute("usuario") == null){
      out.print("<link rel=\"stylesheet\" \n"
                + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
      out.println("<center>");           
      out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
      out.println("<a class='btn btn-primary' href='/WebJava04/login.jsp'>Ir a pagina de acceso</a>");
      out.println("</center>");
      return;
  }    
%>

<%
  String driver = "com.mysql.cj.jdbc.Driver";
  String url   = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
  String user   = "root";
  String pass   = "123456";
  
  Class.forName(driver);
  Connection xcon = DriverManager.getConnection(url, user, pass);
  
  String sql = "select * from cargos";
  Statement stm = xcon.createStatement();
  ResultSet rs = stm.executeQuery(sql);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargos JSP</title>
        <link rel="stylesheet" 
              href="webjars/bootstrap/5.1.0/css/bootstrap.min.css" type="text/css" />
    </head>
    <body>
        <div class="container">
            <h3>Usuario Logeado: <b><% out.print(usuario); %></b></h3>
            <h3>Estado: <b><% out.print(estado); %></b></h3>
            <h3><a class='btn btn-danger' href="/WebJava04/ServletSesion">Cerrar Sesion</a></h3>
            <h1>Listado de Cargos</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">CODIGO</th>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">CARGO</th>
                        <th scope="col">ESTADO</th>
                    </tr>
                </thead>
                <tbody>
                    <% int cont = 1;
                        while (rs.next()) {
                        if(cont%2==0){
                            out.print("<tr class='table-info'>");
                            out.print("<td>" + rs.getString(1) + "</td>");
                            out.print("<td>" + rs.getString(2) + "</td>");
                            out.print("<td>" + rs.getString(3) + "</td>");
                            out.print("<td>" + rs.getString(4) + "</td>");
                            out.print("</tr>");
                        }else{
                            out.print("<tr class='table-warning'>");
                            out.print("<td>" + rs.getString(1) + "</td>");
                            out.print("<td>" + rs.getString(2) + "</td>");
                            out.print("<td>" + rs.getString(3) + "</td>");
                            out.print("<td>" + rs.getString(4) + "</td>");
                            out.print("</tr>");
                        }
                        cont = cont+1;
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
