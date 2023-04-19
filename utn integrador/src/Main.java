import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // MENSAJE DE BIENVENIDA DEL PROYECTO
        JOptionPane.showMessageDialog(null, "Bienvenido al pronosticador deportivo 2023 - Equipo 3 Utn");
        // CREO LA LISTA DE EQUIPOS
        List<Equipo> listaEquipos = new ArrayList<>();
        // LLENO LA LISTA DE EQUIPOS CON SUS EQUIPOS
            //LLAVE DERECHA
            listaEquipos.add(new Equipo("Eeuu "));
            listaEquipos.add(new Equipo("Dinamarca "));
            listaEquipos.add(new Equipo("Francia "));
            listaEquipos.add(new Equipo("Portugal "));
            // LLAVE IZQUIERDA
            listaEquipos.add(new Equipo("Brasil "));
            listaEquipos.add(new Equipo("Mexico "));
            listaEquipos.add(new Equipo("Alemania "));
            listaEquipos.add(new Equipo("Argentina "));


        // LLAMO AL OBJETO JUGADOR Y AL METODO ELEGIR EQUIPO Y LE CARGO LA LISTA DE EQUIPOS ANTERIORMENTE CREADA.
        Jugador jugador = new Jugador();
        jugador.elegirEquipo(listaEquipos);

//        Llave llaveDerecha = new Llave();
//        llaveDerecha.armarLlaves(listaEquipos, 0);
//        System.out.println("Equipos llave derecha");
//        for (int i = 0; i < llaveDerecha.getEquiposListaLlave().size() ; i++) {
//            System.out.println(llaveDerecha.getEquiposListaLlave().get(i).getNombre());
//        }
//        Llave llaveIzquierda = new Llave();
//        llaveIzquierda.armarLlaves(listaEquipos, 4);
//        System.out.println("Equipos llave izquierda");
//        for (int i = 0; i < llaveIzquierda.getEquiposListaLlave().size() ; i++) {
//            System.out.println(llaveIzquierda.getEquiposListaLlave().get(i).getNombre());
//        }
        // CREO UN OBJETO LLAVE, PARA EL LADO DERECHO Y OTRO PARA EL LADO IZQUIERDO DEL TORNEO
        Llave llaveDerecha = new Llave();
        Llave llaveIzquierda = new Llave();
        // LE DOY EL VALOR POR PARAMETRO INICIAL DEL INDICE ALAS LLAVES > DESDE / HASTA <.
        llaveDerecha.armarLlaves(listaEquipos, 0);
        llaveIzquierda.armarLlaves(listaEquipos, 4);
        // CREO EL OBJETO RONDA Y POR PARAMENTROS INGRESO LAS LLAVES CREADAS ANTERIORMENTE E INICIALIZADAS POR PARAMETROS
        Ronda ronda = new Ronda();
        ronda.cuartosFinal(llaveIzquierda,llaveDerecha);
        //LLAMO A JUGADOR CON SU METODO SUMAR PUNTOS EN CADA RONDA PARA SABER SI SUMA O NO PUNTO DEPENDIENDO LA VICTORIA DEL EQUIPO
        jugador.sumarPuntos();
        ronda.semiFinal(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();
        ronda.finalTorneo(llaveIzquierda,llaveDerecha);
        jugador.sumarPuntos();
        // AL FINAL DEJO UN MSJ QUE DICE EL PUNTAJE DEL EQUIPO SELECCIONADO
        JOptionPane.showMessageDialog(null,"Has conseguido " + jugador.getPuntaje()
        + " por elegir al equipo: " + jugador.getEquipoSeleccionado().getNombre()," Nombre",
                JOptionPane.INFORMATION_MESSAGE);
   }
}