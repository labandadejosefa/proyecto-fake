/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domination.mvc.servlets;


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
@WebServlet(name = "LoginServlet", value = "/ingresar")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ////        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Error 405 - Generado por el objeto super.doPost
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        System.out.println(email);
        System.out.println(password);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Error 405 - Generado por el objeto super.doGet

        req.getRequestDispatcher("pages/login.jsp").forward(req, resp);//redirige el servlet a el JSP del form.
        //req.getRequestDispatcher("css/estiloReg.css").forward(req, resp); <-- no sirve.
    }
}
