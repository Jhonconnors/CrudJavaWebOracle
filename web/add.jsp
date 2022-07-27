<%-- 
    Document   : add
    Created on : 19-07-2022, 13:48:45
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
            <h3>Agregar Personas</h3>
        </div>
        <div>
            <form accion="Controlador" method="POST">
                ID: <br>
                <input type="text" name="txtid"> <br>
                NOMBRES: <br> 
                <input type="text" name="txtnom"> <br>
                CORREO: <br>
                <input type="email" name="txtcorreo"> <br>
                TELEFONO: <br>
                <input type="text" name="txttelefono"> <br>
                <input type="submit" name="accion" value="Guardar">
            </form>
        </div>
    </center>  
      
    </body>
</html>
