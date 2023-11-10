
package domination.mvc.model.DAO;

import domination.mvc.model.Reserva;
import domination.mvc.model.Usuario;
import domination.mvc.model.UtilExceptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karol
 */
public class ReservaDAO implements DAO<Reserva, Integer>{
    
    private Timestamp fechaHoraATimestamp(LocalDateTime datetime){       
       return Timestamp.valueOf(datetime);
    }
    
    
    @Override
    public void add(Reserva reserva) {                
        String query = "INSERT INTO reserva (objeto, usuario, fechaHora, finReserva, horas) VALUES (?,?,?,?,?)";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            ps.setObject(1, reserva.getObjetoReserva()); //ver cómo se guardan en BDD (si por "objeto" o por nombre/id
            ps.setObject(2, reserva.getUsuarioReserva()); //ver cómo se guardan en BDD (si por "objeto" o por nombre/id
            ps.setTimestamp(3, fechaHoraATimestamp(reserva.getFechaYHora()));
            ps.setTimestamp(4, fechaHoraATimestamp(reserva.getFinReserva()));
            ps.setInt(5, reserva.getCantidadHoras());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }                       
    }
    
    @Override
    public void update(Reserva reserva)  {
        String query = "UPDATE reserva SET objeto = ?, usuario = ?, fechaHora = ?, finReserva = ?, horas = ? WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            ps.setObject(1, reserva.getObjetoReserva()); //ver cómo se guardan en BDD (si por "objeto" o por nombre/id
            ps.setObject(2, reserva.getUsuarioReserva()); //ver cómo se guardan en BDD (si por "objeto" o por nombre/id
            ps.setTimestamp(3, fechaHoraATimestamp(reserva.getFechaYHora()));
            ps.setTimestamp(4, fechaHoraATimestamp(reserva.getFinReserva()));
            ps.setInt(5, reserva.getCantidadHoras());
            ps.setInt(6, reserva.getIdReserva()); //no tengo muy claro qué onda ese attr idReserva de clase Reserva. Cómo lo relacionamos con el id posta de la tabla? 
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
   
    @Override
    public void delete(Integer idReserva) {
        String query = "DELETE FROM reserva WHERE id = ?";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, idReserva);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }       
    }
    
    
    @Override
    public List<Reserva> getAll() {
        List<Reserva> reservas = new ArrayList<>();
        String query = "SELECT * FROM reserva";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                query = ""; //********metí esta línea momentáneamente, para que no hubiera error 
                //reservas.add(rsRowToReserva(rs));
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return reservas;
    }
    
    // ESTE ES EL MÉTODO QUE HIZO DARME CUENTA DE LA CONFUNSIÓN ENTRE tipos de datos de los atributos de las clases "posta", y de cómo se gardarán en la BDD
    /*
    private Reserva rsRowToRecerva(ResultSet rs) throws SQLException{
        return new Reserva(
                rs.getInt("idReserva"),
                rs.getObject("objeto", Usuario),
                
                )
    }
    */

    @Override
    public Reserva getById(Integer idReserva) {
        Reserva reservaEncontrada = null;
        //ACÁ HAY QUE CAMBIAR POR LA LÓGICA PARA LA BÚSQUEDA POR ID, VIA BDD.         
        return reservaEncontrada;
    }        
    
    
}
