<%-- 
    Document   : index
    Created on : 18-07-2022, 23:47:05
    Author     : J Connors
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div>
            <h3>Personas</h3>
            <form action="Controlador" method="POST">
                <input type="submit" name="accion" value="Listar">
                <input type="submit" name="accion" value="Nuevo">
            </form>
        </div>
        
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRES</th>
                        <th>CORREO</th>
                        <th>TELEFONO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                
                <tbody>
                    <c:forEach var="dato" items="${datos}">
                    <tr>
                        <td>${dato.getId()}</td>
                        <td>${dato.getNom()}</td>
                        <td>${dato.getCorreo()}</td>
                        <td>${dato.getTel()}</td>
                        <td>
                            <form accion="Controlador" method="POST">
                                <input type="hidden" name="id" value="${dato.getId()}">
                                <input type="submit" name="accion" value="Editar">
                                <input type="submit" name="accion" value="Delete">
                            </form>
                        </td>
                        
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            
        </div>
    </center>
    </body>
</html>
