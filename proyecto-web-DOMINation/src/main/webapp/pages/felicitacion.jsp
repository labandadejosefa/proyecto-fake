<%-- 
    Document   : felicitacion
    Created on : 24 sept 2023, 16:48:17
    Author     : giann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario creado</title>
        <link rel="stylesheet" href="css/esiloFelic.css">
    </head>
<body>
    <div class="container-texto">
        <h1 class="fuentePrincFondo">Felicitaciones ${param.nomCliente}! </h1>
        <div class="parrafin">
            <p1>Tu cuenta ha sido creada exitosamente! <br> Ya podes ingresar a la web
                con tu usuario y contraseña para consultar el próximo lugar donde
                vas a alquilar tu sala.</p1>
        </div>
        <br><br>
        <div class="botoncin">
            <a href="#"><button type="proyecto-web-DOMINation">Volver al inicio</button></a>&nbsp;&nbsp;
            <a href="#"><button type="ingresar">ingresar</button></a>
        </div>
    </div><br>
</body>
</html>
