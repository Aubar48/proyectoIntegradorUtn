import javax.swing.*;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bucleFin = 0;
        mensajeTeam3();
        do {
            try {
                int option = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Option 1: Iniciar pronostico" + "\n " +
                                "Option 2: Salir",
                        "Menu Pronosticador deportivo 2023 - Argentina programa 4.0 - UTN Java", JOptionPane.INFORMATION_MESSAGE));
                switch(option){
                    case 1:
                        // CREO LA LISTA DE EQUIPOS
                        List<Equipo> listaEquipos = new ArrayList<>();
                        // LLENO LA LISTA DE EQUIPOS CON SUS EQUIPOS
                        //LLAVE DERECHA
                        listaEquipos.add(new Equipo("Uruguay "));
                        listaEquipos.add(new Equipo("Venezuela "));
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

                        //metodo util java collections para cambiar dos valores de una lista por su indice
                        //Collections.swap(listaEquipos, 7, 3);
                        //metodo remover de la lista un equipo por consola
                        //listaEquipos.remove(input.nextInt());

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

                        break;
                    case 2:{
                        bucleFin = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el valor numerico 2 si desea salir",
                                "Menu para salir", JOptionPane.INFORMATION_MESSAGE));
                        break;
                    }
                    default:
                        JOptionPane.showMessageDialog(null, "Elija solo valores del indice, vuelva pronto","ERROR MSJ",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico","ERROR MSJ",JOptionPane.ERROR_MESSAGE);
            }

        }while (bucleFin != 2);


    }
    public static void mensajeTeam3(){
        JOptionPane.showMessageDialog(null, "Bienvenido al pronosticador deportivo 2023 - UTN Equipo 3" + "\n " +
                "TEAM: Ezequiel Leon " + "\n " +
                "TEAM: Nahuel Ezequiel Argandoña " + "\n " +
                "TEAM: Matias Roberto" + "\n " +
                "TEAM: Celeste Gimenez" + "\n " +
                "TEAM: Santos Patricio augusto","Pronosticador deportivo 2023 - Argentina programa 4.0 - UTN Java", JOptionPane.INFORMATION_MESSAGE);

    }

}

