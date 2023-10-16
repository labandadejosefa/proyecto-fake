/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domination.mvc.model;

/**
 *
 * @author giann
 */
public class Domicilio {
    private String provincia;
    private String localidad;
    private String partido;
    private String calle;
    private String altura;

    public Domicilio(String provincia, String localidad, String partido, String calle, String altura) {
        this.provincia = provincia;
        this.localidad = localidad;
        this.partido = partido;
        this.calle = calle;
        this.altura = altura;
    }
    
}
