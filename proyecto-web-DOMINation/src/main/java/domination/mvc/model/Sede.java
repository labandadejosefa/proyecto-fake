
package domination.mvc.model;

import java.util.ArrayList;

/**
 *
 * @author giann
 */
public class Sede {
    private Domicilio dom;
    //private ArrayList<SalaEnsayo> salasSede;
    //private ArrayList<Instrumento> instrumentos;
    private ArrayList<ObjetoReservable> reservables;
    
    
    public Sede(Domicilio dom) {
        this.dom = dom;
        //this.salasSede = new ArrayList<>();
        //this.instrumentos= new ArrayList<>();
        this.reservables = new ArrayList<>();
    }
    
    
}
