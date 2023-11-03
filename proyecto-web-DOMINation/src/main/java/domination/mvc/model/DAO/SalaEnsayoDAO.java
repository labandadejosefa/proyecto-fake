
package domination.mvc.model.DAO;

import domination.mvc.model.Reserva;
import domination.mvc.model.SalaEnsayo;
import domination.mvc.model.UtilExceptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karol
 */
public class SalaEnsayoDAO implements DAO<SalaEnsayo, Integer>, IDisponibleDAO {
    private static int contador = 1; // Simula un id autoincremental de base de datos
    private List<SalaEnsayo> salas; // Listado de salas de ensayo. Después: HAY QUE CONSULTAR TABLA SALAENSAYO VIA BDD
    private List<Reserva> reservas; //esta lista acá: para hacer una reserva, hay que consultar cuál su objeto reservable. Después: HAY QUE CONSULTAR DISPONIBLIDLAD VIA BDD

    public SalaEnsayoDAO() {
        this.salas = new ArrayList();
        this.reservas = new ArrayList();
    }
        
    public void mostrarOfertaHoraria(){
        //ESTE MÉTODO DEBERÍA TRABAJAR CON LAS TABLAS RESERVA Y SALADEENSAYO SIMULTÁNEAMENTE. Creo.
    }
        
    @Override
    public void add(SalaEnsayo sala){
        String query = "INSERT INTO sala (nombre, precioHora) VALUES (?, ?"; //VERIFICAR LOS CAMPOS QUE TIENE EN VERDAD LA TABLA!!!
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement prepStatement = con.prepareStatement(query)){
            prepStatement.setString(1, sala.getNombre());
            prepStatement.setDouble(2, sala.getPrecioHora());
            //prepStatement.setT
            prepStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
    @Override
    public void update(SalaEnsayo sala)  {
        String query = "UPDATE sala SET nombre = ?, precioHora = ? WHERE id = ? ";
        try (Connection con= ConnectionPool.getInstance().getConnection(); PreparedStatement prepStatement = con.prepareStatement(query)){
            prepStatement.setString(1, sala.getNombre());
            prepStatement.setDouble(2, sala.getPrecioHora());
            prepStatement.setInt(3, sala.getId());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }    
    }

    @Override
    public void delete(Integer idSala) {
        String query = "DELETE FROM sala WHERE id = ?"; 
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement prepStatement = con.prepareStatement(query)){
            prepStatement.setInt(1, idSala);
            prepStatement.executeUpdate();            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }        
 
    @Override
    public List<SalaEnsayo> getAll() {
        List<SalaEnsayo> salas = new ArrayList<>();
        String query = "SELECT * FROM sala";
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement prepStatement = con.prepareStatement(query); ResultSet resultSet = prepStatement.executeQuery()){
            while (resultSet.next()) {
                salas.add(rsRowToSalaEnsayo(resultSet));                
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return salas;        
    }
    
    private SalaEnsayo rsRowToSalaEnsayo(ResultSet rs) throws SQLException
    {
        return new SalaEnsayo(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getDouble("precioHora") //VERIFICAR Y/O AGREGAR ESTE ATRIBUTO EN LA TABLA DE SALA. ESTÁ EN LA CLASE SALAENSAYO! Y lo usa reserva xa hacer cuentas.                
        );
    }    
   
    @Override
    public SalaEnsayo getById(Integer idSala) {
        String query = "SELECT * FROM sala WHERE id = ?";        
        SalaEnsayo salaEncontrada = null;
        try (Connection con = ConnectionPool.getInstance().getConnection(); PreparedStatement prepStatement = con.prepareStatement(query)){
            prepStatement.setInt(1, idSala);
            try (ResultSet resultSet = prepStatement.executeQuery()){
                if (resultSet.next()) {
                    salaEncontrada = rsRowToSalaEnsayo(resultSet);
                }                
            }             
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }        
        return salaEncontrada;        
    }        

    //******************************* TRADUCIR ESTE MÉTODO estaDisponible() a lógica de BDD ***************************************************
    @Override
    public boolean estaDisponible(Object obj, LocalDateTime fechaYHora, int cantidadHoras) {
        SalaEnsayo sala = (SalaEnsayo) obj; //downcasting -quiero ver a 'obj' como una instancia de SalaEnsayo
        Duration duracionDeseada = Duration.ofHours(cantidadHoras);
        int i = 0;         
        boolean estaDisp = false;
        while (i<reservas.size() && reservas.get(i).getObjeto() != sala) {            
            i++;
        }
        if (i<reservas.size()) {            
            estaDisp = fechaYHora.plus(duracionDeseada).isBefore(reservas.get(i).getFechaYHora()) || fechaYHora.isAfter(reservas.get(i).getFinReserva()); //esto daría el true
        }
        return estaDisp; 
        //Así como está, SÓLO responde por el instante consultado. No muestra oferta horaria del objeto deseado        
        
    }
    
    
    public boolean isDisponible(LocalDateTime fechaYHora, int cantidadHoras){
        boolean isDisponible = false;
        
        
        return isDisponible;
    }
        
}
