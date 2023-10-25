<%-- 
    Document   : reserva
    Created on : Oct 19, 2023, 5:42:59 AM
    Author     : karol
--%>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%--<link rel="stylesheet" href="../css/estiloReserva.css"> --%>
        <link rel="stylesheet" href="<c:url value="/css/estiloReserva.css"/>"> 
        <title>Reserva de sala</title>        
        <%--https://www.freecodecamp.org/espanol/news/como-construir-una-forma-de-registro-con-etiquetas-flotantes-y-transiciones-usando-solamente/ --%>
    </head>
    <body>
        <div class = "formReserva">
            <form action="ReservaServlet" class="formbox" method="post">
                <h1 class="title">Fazer reserva</h1>
                <%-- Elección de Sede --%>
                <div class="inputContainer">
                    <label for="sede">Sede:</label>
                    <select id="sede" name="sede">
                        <option value="sede1">Sede 1</option>
                        <option value="sede2">Sede 2</option>
                        <option value="sede2">Sede 3</option>
                        <option value="sede2">Sede 4</option>
                        <!-- ... -->
                    </select>
                </div>
                <%-- Elección de fecha --%>
                <div class="inputContainer">
                    <label for="fecha">Fecha:</label>
                    <fmt:formatDate var="currentDate" value="${now}" pattern="yyyy-MM-dd" />
                    <c:set var="now" value="<%= new java.util.Date() %>" />
                    <input type="date" id="fecha" name="fecha" min="${currentDate}">
                </div>
                <%-- Elección de horario --%>
                <div class="inputContainer">
                    <label for="horario">Horario:</label>
                    <select id="horario" name="horario">
                        <option value="10:00">10:00</option>
                        <option value="11:00">11:00</option>
                        <option value="11:00">12:00</option>
                        <option value="11:00">14:00</option>
                        <option value="11:00">15:00</option>
                        <option value="11:00">16:00</option>
                        <option value="11:00">17:00</option>
                        <option value="11:00">18:00</option>
                        <option value="11:00">19:00</option>
                        <option value="11:00">20:00</option>
                        <option value="21:00">21:00</option>
                        <option value="22:00">22:00</option>
                    </select>
                </div>
                <%-- Elección de Sala (esto eventualmente sería dinámico basado en disponibilidad de sede, fecha y hora)--%>
                <div class="inputContainer">
                    <label for="sala">Sala:</label>
                    <select id="sala" name="sala">
                        <option value="salaA">Sala A</option>
                        <option value="salaB">Sala B</option>                    
                        <option value="salaB">Sala C</option>
                    </select>
                </div>

                <div>
                    <input type="submit" value="Reservar">
                </div>
            </form>  
        </div>
    </body>
</html>


