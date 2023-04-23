import javax.swing.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        int bucleFin = 0;
        mensajeTeam3();
        do {
            try {
                int option = Integer.parseInt(JOptionPane.showInputDialog(null,
                        """
                                Somos lo que fuimos, y de nada sirve apostar por el futuro si no hemos echado cuentas con nuestro pasado.\s
                                “Suerte es lo que sucede cuando la preparación y la oportunidad se encuentran.»\s
                                – Séneca, filósofo romano
                                 Option 1: Iniciar pronostico
                                 Option 2: Salir""",
                        "Menu Pronosticador deportivo 2023 - UTN ARGENTINA PROGRAMA 4.0 JAVA", JOptionPane.INFORMATION_MESSAGE));
                switch(option){
                    case 1:
                        // CREO LA LISTA DE EQUIPOS
                        List<Equipo> listaEquipos = new ArrayList<>();
                        // LLENO LA LISTA DE EQUIPOS CON SUS EQUIPOS
                        //LLAVE DERECHA
                        listaEquipos.add(new Equipo("Uruguay ヅ "));
                        listaEquipos.add(new Equipo("Venezuela ヅ "));
                        listaEquipos.add(new Equipo("Francia ヅ "));
                        listaEquipos.add(new Equipo("Portugal ヅ "));
                        // LLAVE IZQUIERDA
                        listaEquipos.add(new Equipo("Brasil ヅ "));
                        listaEquipos.add(new Equipo("Mexico ヅ "));
                        listaEquipos.add(new Equipo("Alemania ヅ "));
                        listaEquipos.add(new Equipo("Argentina ヅ "));

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
                        JOptionPane.showMessageDialog(null,"“En el juego, muchos deben perder para que pocos ganen.»\n" +
                                        "– George Bernard Shaw, dramaturgo irlandés \n"+
                                        "Muchas gracias por ocupar el pronosticador deportivo \n "+
                                        "Has conseguido " + jugador.getPuntaje()
                                        + " puntos, por elegir al equipo: " + jugador.getEquipoSeleccionado().getNombre(),"PROGRAMA FINALIZADO - UTN ARGENTINA PROGRAMA 4.0 JAVA",
                                JOptionPane.INFORMATION_MESSAGE);

                        break;
                    case 2:{
                        bucleFin = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el valor numerico 2 si desea salir",
                                "Menu para salir", JOptionPane.INFORMATION_MESSAGE));
                        break;
                    }
                    default:
                        JOptionPane.showMessageDialog(null, "Elija solo valores numericos del indice del menu ❤","ERROR MSJ",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico del indice del menu ❤","ERROR MSJ",JOptionPane.ERROR_MESSAGE);
            }

        }while (bucleFin != 2);


    }
    public static void mensajeTeam3(){
        JOptionPane.showMessageDialog(null, """
                Bienvenido al pronosticador deportivo 2023 - UTN Equipo 3
                 TEAM 1: Ezequiel Leon  ☺
                 TEAM 2: Nahuel Ezequiel Argandoña ☺\s
                 TEAM 3: Matias Roberto ☺\s
                 TEAM 4: Celeste Gimenez ☺\s
                 TEAM 5: Santos Patricio augusto ☺\s""","Pronosticador deportivo 2023 - UTN ARGENTINA PROGRAMA 4.0 JAVA", JOptionPane.INFORMATION_MESSAGE);

    }

}

