/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto.web.domination.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author giann
 */
@WebServlet(name = "RegistroServlet", value = "/registrarse")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Error 405 - Generado por el objeto super.doPost
        String nombre = req.getParameter("nomCliente");
        String apellido = req.getParameter("apeCliente");
        String DNI = req.getParameter("DNI");
        String celular = req.getParameter("celular");
        String calle = req.getParameter("calle");
        String altura = req.getParameter("altura");
        String localidad = req.getParameter("localidad");
        String partido = req.getParameter("partido");
        String provincia = req.getParameter("provincia");
        String email = req.getParameter("email");
        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(DNI);
        System.out.println(celular);
        System.out.println(calle);
        System.out.println(altura);
        System.out.println(localidad);
        System.out.println(partido);
        System.out.println(provincia);
        System.out.println(email);
        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Error 405 - Generado por el objeto super.doGet

        req.getRequestDispatcher("pages/reg-cliente.jsp").forward(req, resp);//redirige el servlet a el JSP del form.
        //req.getRequestDispatcher("css/estiloReg.css").forward(req, resp); <-- no sirve.
    }
    
}
