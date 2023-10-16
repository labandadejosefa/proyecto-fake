<%-- 
    Document   : reg-cliente
    Created on : 21 sept 2023, 9:32:14
    Author     : giann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/estiloReg.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrarse</title>
    </head>

    <body>   
        
        <div class="elcontainer">
            
            <div>
                <img class="logo" src="img/logo.png" alt="logo">
                <del class="eltitulo">DO MI</del><b class="eltitulo rojo"> Nation</b>
            </div><br>
    
            <div class="form-container"> 
                <h2 class="fuentePrinc">Registrate completando los datos solicitados</h2>
                <form action="registrarse" method="POST" >
                    <h3 class="fuentePrincFondo">Datos Personales</h3><br>
                    <label class="fuenteMin" for="name">Nombre:</label> <input type="text" name="nomCliente" id="nombre">
                    <label class="fuenteMin" for="last-name">Apellido:</label> <input type="text" id="apellido" name="apeCliente">
                    <label class="fuenteMin" for="celular">Celular:</label> <input type="text" id="cel" name="celular">
                    <br><br>
                    
                    <h3 class="fuentePrincFondo">Domicilio</h3> <br><br>
                    <label class="fuenteMin" for="calle">Calle:</label> <input type="text" id="calle" name="calle">
                    <label class="fuenteMin" for="altura">altura:</label> <input type="text" id="altura" name="altura">
                    <label class="fuenteMin" for="localidad">Localidad:</label> <input type="text" id="localidad" name="localidad">
                    <br><br>        
                    
                    <label class="fuenteMin" for="partido">Partido:</label> <input type="text" id="partido" name="partido">        
                    <label class="fuenteMin" for="provincia">Provincia:</label> <input type="text" id="provincia" name="provincia">
                    <h3 class="fuentePrincFondo">Otros datos</h3><br>
                    <label class="fuenteMin" for="email">Correo Electrónico</label> <input type="text" id="email" name="email">        
                    <label class="fuenteMin" for="user">Nombre de usuario:</label> <input type="text" id="user" name="user">
                    <br><br>
                    
                    <label class="fuenteMin" for="pass">Contraseña:</label> <input type="password" id="pass" name="pass">
                    <label class="fuenteMin" for="pass">Confirme contraseña:</label> <input type="password" id="pass" name="pass">
                    <br><br><br><br>
                
                    <div class="centrarEnPag">
                        <button class ="botoncin" type="submit" >Enviar</button>
                        <button class ="botoncin" type="reset" >Limpiar Formulario</button>
                    </div>  <br>
                </form> 
            </div>
        </div>    
    </body>
</html>