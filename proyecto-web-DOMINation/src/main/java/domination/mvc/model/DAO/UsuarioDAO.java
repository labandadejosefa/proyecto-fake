
package domination.mvc.model.DAO;

import domination.mvc.model.Usuario;
import domination.mvc.model.UtilExceptions;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karol
 */
public class UsuarioDAO implements DAO<Usuario, Integer>{
    private static int contador = 1; // Simula un id autoincremental de base de datos
    private List<Usuario> usuarios;

    public UsuarioDAO() {
        this.usuarios = new ArrayList<>();
    }
        
    @Override
    public void create(Usuario usuario) {        
        //ACÁ HAY QUE AGREGAR LA LÓGICA PARA LA MODIFICACIÓN VIA BDD. 
    }

    @Override
    public void add(Usuario usuario) throws Exception {
       UtilExceptions.checkObjetoValido(usuario, "La reserva a agregar, no pude ser nula"); 
       usuarios.add(usuario);
       contador++;
       //SEGURAMENTE ESTE MÉTODO DESAPAREZCA, AL AGREGAR LA LÓGICA PARA LA MANIPULACION VIA BDD
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        //ACÁ HAY QUE AGREGAR LA LÓGICA PARA LA MODIFICACIÓN VIA BDD. 
    }

    @Override
    public void delete(Integer id) {
        UtilExceptions.checkNumeroPositivo(id, "El id del usuario a eliminar, no puede ser nulo o negativo");
        //ACÁ HAY QUE AGREGAR LA LA LÓGICA PARA LA ELIMINACIÓN VIA BDD.
    }

    @Override
    public List<Usuario> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //ACÁ HAY QUE AGREGAR LA LÓGICA PARA mostrar la lista VIA BDD. 
    }

    @Override
    public Usuario getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //ACÁ HAY QUE CAMBIAR POR LA LÓGICA PARA LA BÚSQUEDA POR ID, VIA BDD.         
    }
    
    
    
}
