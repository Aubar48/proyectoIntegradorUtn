import javax.swing.*;
import java.util.List;

public class Jugador {
    //CREO LOS ATRIBUTOS
    private Equipo equipoSeleccionado;
    private int puntaje;
    // CREO SU CONSTRUCTOR VACIO Y PUBLICO
    public Jugador() {
    }
    // CREO SU CONSTRUCTOR CON TODOS SUS PARAMENTROS Y PUBLICO
    public Jugador(Equipo equipoSeleccionado, int puntaje) {
        this.equipoSeleccionado = equipoSeleccionado;
        this.puntaje = puntaje;
    }
    // CREO SUS GETTERS Y SETTERS PUBLICOS
    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }

    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    // CREO SU TOSTRING QUE ES UN MSJ PARA MOSTRAR INFORMACION DE LOS ATRIBUTOS DE LA CLASE DE FORMA ORDENADA Y PUBLICO.
    @Override
    public String toString() {
        return "Jugador{" +
                "equipoSeleccionado=" + equipoSeleccionado +
                ", puntaje=" + puntaje +
                '}';
    }
    // CREO SUS METODOS
    public void elegirEquipo(List<Equipo> listaEquipos){
        JOptionPane.showMessageDialog(null,"Selecione su equipo","Seleccion de equipo", JOptionPane.INFORMATION_MESSAGE);
        String listaEquiposMensaje ="Equipos: \n";
        for (int i = 0; i < listaEquipos.size() ; i++) {
        listaEquiposMensaje+=(i+1) + ". " + listaEquipos.get(i).getNombre() + "\n ";
            JOptionPane.showMessageDialog(null,listaEquiposMensaje,"Seleccion de equipo", JOptionPane.INFORMATION_MESSAGE);
    }
//        for (Equipo equipo : listaEquipos) {
//            System.out.println(listaEquipos.indexOf(equipo)+1 + " Nombre del equipo: " + equipo.getNombre());
//
//        }
        int indiceEquipo=0;
        do {
            indiceEquipo = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Ingrese el indice del equipo que quiere seleccionar",
                    "Seleccion del equipo del usuario", JOptionPane.INFORMATION_MESSAGE)) -1;
        }while (indiceEquipo<0 || indiceEquipo>7);
        JOptionPane.showMessageDialog(null,"seleccionaste a: " +
                listaEquipos.get(indiceEquipo).getNombre());
        this.equipoSeleccionado = listaEquipos.get(indiceEquipo);
    }
    public void sumarPuntos(){

        if (equipoSeleccionado.isAutorizacion()){

            puntaje++;
        }
    }
}
