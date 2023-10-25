
package domination.mvc.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author karol
 */
public class ReservaSalaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sede = req.getParameter("sede");
        String fecha = req.getParameter("fecha");
        String horario = req.getParameter("horario");
        String sala = req.getParameter("sala");    
        
        //ojo porque acá hay que conectar con Capa DAO (responsable de interactuar con la fuente de datos (BDD). Abstrae y encapsula el acceso a los datos)
        //y con Capa de Servicio (Contiene la lógica del negocio. Es 1 abstracción -interface- que define operaciones de alto nivel)
        
        //------
        // Acá, una vez cargados los param con POST, redirigir a otra página o a la misma página pero como un GET: patrón Post/Redirect/Get (PRG)
        //resp.sendRedirect("rutaDeLaPaginaADondeRedirigir.jsp");
    
    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/reserva-sala.jsp").forward(req, resp);//redirige este servlet al JSP del form de reserva de sala        
    }
       
}
