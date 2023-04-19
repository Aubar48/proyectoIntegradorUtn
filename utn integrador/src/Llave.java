import java.util.ArrayList;
import java.util.List;

public class Llave {
    //CREO LOS ATRIBUTOS PRIVADOS
    private List<Equipo> equiposListaLlave;
    private String nombreLlave;
    // CREO SU CONSTRUCTOR VACIO Y PUBLICO
    public Llave() {
    }
    // CREO SU CONSTRUCTOR CON PARAMETROS Y PUBLICO
    public Llave(List<Equipo> equiposListaLlave, String nombreLlave) {
        this.equiposListaLlave = equiposListaLlave;
        this.nombreLlave = nombreLlave;
    }
    // CREO SUS GETTERS Y SETTERS Y PUBLICO
    public List<Equipo> getEquiposListaLlave() {
        return equiposListaLlave;
    }

    public void setEquiposListaLlave(List<Equipo> equiposListaLlave) {
        this.equiposListaLlave = equiposListaLlave;
    }

    public String getNombreLlave() {
        return nombreLlave;
    }

    public void setNombreLlave(String nombreLlave) {
        this.nombreLlave = nombreLlave;
    }
    // CREO SU TOSTRING QUE ES UN MSJ PARA MOSTRAR INFORMACION DE LOS ATRIBUTOS DE LA CLASE DE FORMA ORDENADA Y PUBLICO.
    @Override
    public String toString() {
        return "Llave{" +
                "equiposListaLlave=" + equiposListaLlave +
                ", nombreLlave='" + nombreLlave + '\'' +
                '}';
    }

    public void armarLlaves(List<Equipo> listaGeneral, int indiceInicial){
        List<Equipo> equiposLlave = new ArrayList<>();
        for (int i = indiceInicial; i < indiceInicial+4 ; i++) {
            equiposLlave.add(listaGeneral.get(i));
        }
        this.equiposListaLlave = equiposLlave;
    }
}
