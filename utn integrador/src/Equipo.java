import java.util.Scanner;

import static java.lang.System.in;

public class Equipo {
    //CREO LOS ATRIBUTOS PRIVADOS
    private String nombre;
    private boolean autorizacion = true;
    private Resultado resultadoPartido;
    private int cantGolesTorneo;

    // CREO SU CONSTRUCTOR VACIO Y PUBLICO
    public Equipo() {
    }
    // CREO SU CONSTRUCTOR CON SOLO EL PARAMETRO NOMBRE PARA LLAMAR A LOS EQUIPOS Y PUBLICO
    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    // CREO SU CONSTRUCTOR CON TODOS SUS PARAMENTROS Y PUBLICO
    public Equipo(String nombre, boolean autorizacion, Resultado resultadoPartido, int cantGolesTorneo) {
        this.nombre = nombre;
        this.autorizacion = autorizacion;
        this.resultadoPartido = resultadoPartido;
        this.cantGolesTorneo = cantGolesTorneo;
    }
    // CREO SUS GETTERS Y SETTERS PUBLICOS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Resultado getResultadoPartido() {
        return resultadoPartido;
    }

    public void setResultadoPartido(Resultado resultadoPartido) {
        this.resultadoPartido = resultadoPartido;
    }

    public int getCantGolesTorneo() {
        return cantGolesTorneo;
    }

    public void setCantGolesTorneo(int cantGolesTorneo) {
        this.cantGolesTorneo = cantGolesTorneo;
    }
    // CREO SU TOSTRING QUE ES UN MSJ PARA MOSTRAR INFORMACION DE LOS ATRIBUTOS DE LA CLASE DE FORMA ORDENADA Y PUBLICO.
    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", autorizacion=" + autorizacion +
                ", resultadoPartido=" + resultadoPartido +
                ", cantGolesTorneo=" + cantGolesTorneo +
                '}';
    }
    // CREO EL METODO SUMAR GOLES
    public  void sumarGolesNuevos(int nuevosGoles){
        this.cantGolesTorneo = nuevosGoles;
    }
    Scanner input = new Scanner(in);


}
