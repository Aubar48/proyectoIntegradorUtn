import javax.swing.*;
import java.util.List;

public class Ronda {
    //CREO LOS ATRIBUTOS PRIVADOS
    private int numRonda;
    private int cantEquiposRonda;
    private int cantEquiposLlave;
    // CREO SU CONSTRUCTOR VACIO Y PUBLICO
    public Ronda() {
    }
    // CREO SU CONSTRUCTOR CON TODOS SUS PARAMENTROS Y PUBLICO
    public Ronda(int numRonda, int cantEquiposRonda, int cantEquiposLlave) {
        this.numRonda = numRonda;
        this.cantEquiposRonda = cantEquiposRonda;
        this.cantEquiposLlave = cantEquiposLlave;
    }
    // CREO SUS GETTERS Y SETTERS PUBLICOS
    public int getNumRonda() {
        return numRonda;
    }

    public void setNumRonda(int numRonda) {
        this.numRonda = numRonda;
    }

    public int getCantEquiposRonda() {
        return cantEquiposRonda;
    }

    public void setCantEquiposRonda(int cantEquiposRonda) {
        this.cantEquiposRonda = cantEquiposRonda;
    }

    public int getCantEquiposLlave() {
        return cantEquiposLlave;
    }

    public void setCantEquiposLlave(int cantEquiposLlave) {
        this.cantEquiposLlave = cantEquiposLlave;
    }
    // CREO SU TOSTRING QUE ES UN MSJ PARA MOSTRAR INFORMACION DE LOS ATRIBUTOS DE LA CLASE DE FORMA ORDENADA Y PUBLICO.
    @Override
    public String toString() {
        return "Ronda{" +
                "numRonda=" + numRonda +
                ", cantEquiposRonda=" + cantEquiposRonda +
                ", cantEquiposLlave=" + cantEquiposLlave +
                '}';
    }
    // CREO SUS METODOS
    public void cuartosFinal(Llave llaveIzquierda, Llave llaveDerecha){

        //Seteo el num de rondas
        this.numRonda = 1;
        //Instancio un objeto partido para usar su metodo
        Partido partido = new Partido();
        //Msj por pantalla de bienvenida de cuartos de final
        JOptionPane.showMessageDialog(null,"Se jugaran los cuartos de final",
        "Cuartos",JOptionPane.INFORMATION_MESSAGE);
        this.cantEquiposLlave = 4;
        for (int i = 0; i < cantEquiposLlave ; i+=2) {
            partido.simularPartido(llaveIzquierda.getEquiposListaLlave().get(i),
                    llaveIzquierda.getEquiposListaLlave().get(i+1));
            partido.simularPartido(llaveDerecha.getEquiposListaLlave().get(i),
                    llaveDerecha.getEquiposListaLlave().get(i+1));


        }
        //Remuevo los equipos
        removerEquipos(llaveIzquierda.getEquiposListaLlave());
        removerEquipos(llaveDerecha.getEquiposListaLlave());
        //Setear la cantidad actual de equipos por llave
        this.cantEquiposLlave = 2;
    }


    public void removerEquipos(List<Equipo> equipos){
        int contEquiposLlaves = cantEquiposLlave;
        for (int i = 0; i < contEquiposLlaves ; i++) {
        Equipo auxEquipo = equipos.get(i);
        if (!auxEquipo.isAutorizacion()){
            equipos.remove(auxEquipo);
            contEquiposLlaves--;
        }
        }
    }
    public void semiFinal(Llave llaveIzquierda, Llave llaveDerecha){
        this.numRonda = 2;
        Partido partido = new Partido();
        JOptionPane.showMessageDialog(null,"Se juega la semi final del torneo",
                "Semi Final", JOptionPane.INFORMATION_MESSAGE);
        partido.simularPartido(llaveIzquierda.getEquiposListaLlave().get(0),
                llaveIzquierda.getEquiposListaLlave().get(1));
        partido.simularPartido(llaveDerecha.getEquiposListaLlave().get(0),
                llaveDerecha.getEquiposListaLlave().get(1));
        removerEquipos(llaveIzquierda.getEquiposListaLlave());
        removerEquipos(llaveDerecha.getEquiposListaLlave());
    }
    public void finalTorneo(Llave llaveIzquierda, Llave llaveDerecha){
        this.numRonda = 3;
        JOptionPane.showMessageDialog(null,"Se juega la final señoras y señores del torneo",
                "Final", JOptionPane.INFORMATION_MESSAGE);
        Partido partido = new Partido();
        Equipo equipo = partido.simularPartido(llaveDerecha.getEquiposListaLlave().get(0),
                llaveIzquierda.getEquiposListaLlave().get(0));
        JOptionPane.showMessageDialog(null,"“Lo única que puedes saber sobre la suerte es que, tarde o temprano, cambia.»\n" +
                "– Bret Harte, autor estadounidense \n"+
                "El ganador del torneo es: " + equipo.getNombre(),"Ganador del torneo",JOptionPane.INFORMATION_MESSAGE);
    }


}
