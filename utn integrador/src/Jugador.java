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

        String listaEquiposMensaje = """
                “En el juego, el pecado mortal es confundir una mala jugada con mala suerte.»
                – Ian Fleming, escritor inglés creador de James Bond\s
                Equipos: ☺\s
                """;
        for (int i = 0; i < listaEquipos.size() ; i++) {
            listaEquiposMensaje+=(i+1) + ". " + listaEquipos.get(i).getNombre() + listaEquipos.get(i).getDescripcion()+ "\n ";
        }

        int indiceEquipo=0;
        boolean valido = false;
        do {
            try {
                indiceEquipo = Integer.parseInt(JOptionPane.showInputDialog(null,
                        listaEquiposMensaje,
                        "Menu de seleccion de equipo del usuario", JOptionPane.QUESTION_MESSAGE)) -1;
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número entero válido del indice de la lista de equipos ❤", "ERROR MSJ", JOptionPane.ERROR_MESSAGE);
            }
        } while (!valido || indiceEquipo < 0 || indiceEquipo >= listaEquipos.size());
        JOptionPane.showMessageDialog(null,"Seleccionaste a: " + listaEquipos.get(indiceEquipo).getNombre() + "\n " + "Buena suerte en tu eleccion", "Esta por iniciar el torneo", JOptionPane.WARNING_MESSAGE);
        this.equipoSeleccionado = listaEquipos.get(indiceEquipo);
    }

    public void sumarPuntos(){

        if (equipoSeleccionado.isAutorizacion()){

            puntaje++;
        }
    }
}
