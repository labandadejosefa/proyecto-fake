/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domination.mvc.servlets;
import domination.mvc.model.Domicilio;
import domination.mvc.model.Usuario;
import domination.mvc.model.UsuarioCliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giann
 */
/*@WebServlet(name = "RegistroServlet", value = "/registrarse")*/
public class RegistroServlet extends HttpServlet {
    private List<Usuario> usuarios; 

    public RegistroServlet() {
        usuarios = new ArrayList<>();
    }
    
    public Usuario user(String nomUsuario, String nombre, String apellido, String email, 
            String password, String celular, Domicilio dom){
        Usuario u= null;
        if (nomUsuario != null && nombre != null && apellido != null && email != null && password != null && celular != null && dom != null) {
            u = new UsuarioCliente(1,nomUsuario,nombre,apellido,email,password,celular,dom);
        }
        return u;
    }
    
    public Domicilio domUser(String calle, String alt, String partido, String provincia, String localidad){
        Domicilio dom = null;
        if (calle != null && alt != null && partido != null && provincia != null && localidad != null) {
            dom = new Domicilio(provincia,partido,localidad,calle,alt);
        }
        return dom;
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Error 405 - Generado por el objeto super.doGet
        try{
            String destino;
            String pathInfo = req.getPathInfo();
            
            pathInfo = pathInfo == null ? "" : pathInfo;
            
            req.getRequestDispatcher("pages/reg-cliente.jsp").forward(req, resp);//redirige el servlet primero a el JSP del form de registro.

            HttpSession laSesion= req.getSession();
            laSesion.setAttribute("registroExitoso", true);
            //req.getRequestDispatcher("css/estiloReg.css").forward(req, resp); <-- no sirve.
        }catch (Exception ex){
            resp.sendError(500);
        }
    
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        //Error 405 - Generado por el objeto super.doPost
        try{
            String nombre = req.getParameter("nomCliente");
            String apellido = req.getParameter("apeCliente");
            String celular = req.getParameter("celular");
            String calle = req.getParameter("calle");
            String altura = req.getParameter("altura");
            String localidad = req.getParameter("localidad");
            String partido = req.getParameter("partido");
            String provincia = req.getParameter("provincia");
            String email = req.getParameter("email");
            String username = req.getParameter("user");
            String password = req.getParameter("pass");
            Domicilio dom;

            dom = domUser(calle,altura,partido,provincia,localidad);
            usuarios.add(user(username,nombre,apellido,email,password,celular,dom));

            System.out.println(nombre);
            System.out.println(apellido);
            System.out.println(celular);
            System.out.println(calle);
            System.out.println(altura);
            System.out.println(localidad);
            System.out.println(partido);
            System.out.println(provincia);
            System.out.println(email);
            System.out.println(username);
            System.out.println(password);
            resp.sendRedirect("pages/felicitacion.jsp");
        } catch (Exception ex){
            resp.sendError(500);
        }
        
    }

    
}
