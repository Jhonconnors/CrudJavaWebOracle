<%-- 
    Document   : edit
    Created on : 19-07-2022, 15:02:50
    Author     : J Connors
--%>

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
            <h3>Actualizar Personas</h3>
        </div>
        <div>
            <form accion="Controlador" method="POST">
                ID: <br>
                <input type="text" name="txtid" value="${persona.getId() }"> <br>
                NOMBRES: <br> 
                <input type="text" name="txtnom" value="${persona.getNom() }"> <br>
                CORREO: <br>
                <input type="email" name="txtcorreo" value="${persona.getCorreo() }"> <br>
                TELEFONO: <br>
                <input type="text" name="txttelefono" value="${persona.getTel() }"> <br>
                <input type="submit" name="accion" value="Actualizar">
            </form>
        </div>
    </center>  
    </body>
</html>
