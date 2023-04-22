import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Partido {
    //CREO LOS ATRIBUTOS PRIVADOS Y LOS INICIALIZO CON UN NUMERO ENTERO RANDOM PARA SIMULAR LOS GOLES DE LOS EQUIPOS DURANTE EL PARTIDO.
    private int golesEquipoLocal;

    private int golesEquipoVisitante;


    // CREO SU CONSTRUCTOR VACIO
    public Partido() {
    }
    // CREO SU CONSTRUCTOR CON PARAMETROS Y PUBLICOS
    public Partido(int golesEquipoLocal, int golesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }
    // CREO SUS GETTERS AND SETTERS Y PUBLICOS
    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }
    // CREO SU TOSTRING QUE ES UN MSJ PARA MOSTRAR INFORMACION DE LOS ATRIBUTOS DE LA CLASE DE FORMA ORDENADA Y PUBLICO.
    @Override
    public String toString() {
        return "Partido" +
                "golesEquipoLocal=" + golesEquipoLocal +
                "golesEquipoVisitante=" + golesEquipoVisitante;
    }

    public void golesRandom(){
        this.golesEquipoVisitante = (int)(Math.random() * + 6);
        this.golesEquipoLocal =  (int)(Math.random() * + 6);
    }

//    public void golesArreglados(){
//        Scanner input = new Scanner(in);
//        this.golesEquipoVisitante = input.nextInt();
//        this.golesEquipoLocal =  input.nextInt();
//    }

    public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante){
        int maxIntentos = 5;
        int intentos = 0;
        boolean empate = false;

        do {
            // Generar goles aleatorios
            golesRandom();
            // Mostrar resultado del partido
            JOptionPane.showMessageDialog(null,equipoLocal.getNombre()+ " " +
                    this.golesEquipoLocal+ " - " + this.golesEquipoVisitante + " " +
                    equipoVisitante.getNombre(), "Resultados del partido ",JOptionPane.INFORMATION_MESSAGE);
            //Sumar los goles de los equipos
            equipoLocal.sumarGolesNuevos(this.golesEquipoLocal);
            equipoVisitante.sumarGolesNuevos(this.golesEquipoVisitante);
            // Logica
            if (this.golesEquipoLocal > this.golesEquipoVisitante) {
                equipoVisitante.setAutorizacion(false);
                equipoLocal.setResultadoPartido(Resultado.GANADOR);
                equipoVisitante.setResultadoPartido(Resultado.PERDEDOR);
                JOptionPane.showMessageDialog(null,"Ganador: " + equipoLocal.getNombre()
                        , "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return equipoLocal;
            } else if (this.golesEquipoLocal == this.golesEquipoVisitante) {
                JOptionPane.showMessageDialog(null,"El partido ha quedado en empate. Se jugarán penales para definir al ganador."
                        , "Resultado", JOptionPane.INFORMATION_MESSAGE);
                empate = true;
            } else {
                equipoLocal.setAutorizacion(false);
                equipoLocal.setResultadoPartido(Resultado.PERDEDOR);
                equipoVisitante.setResultadoPartido(Resultado.GANADOR);
                JOptionPane.showMessageDialog(null,"Ganador: " + equipoVisitante.getNombre()
                        , "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return equipoVisitante;
            }

            // Si hubo empate, definir por penales
            if (empate) {
                int golesPenalesEquipoLocal = (int)(Math.random() * 11);
                int golesPenalesEquipoVisitante = (int)(Math.random() * 11);

                JOptionPane.showMessageDialog(null,"Resultado de los penales: " + equipoLocal.getNombre() + " " +
                                golesPenalesEquipoLocal + " - " + golesPenalesEquipoVisitante + " " + equipoVisitante.getNombre()
                        , "Resultado", JOptionPane.INFORMATION_MESSAGE);

                if (golesPenalesEquipoLocal > golesPenalesEquipoVisitante) {
                    equipoVisitante.setAutorizacion(false);
                    equipoLocal.setResultadoPartido(Resultado.GANADOR);
                    equipoVisitante.setResultadoPartido(Resultado.PERDEDOR);
                    JOptionPane.showMessageDialog(null,"Ganador: " + equipoLocal.getNombre()
                            , "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    return equipoLocal;
                } else {
                    equipoLocal.setAutorizacion(false);
                    equipoLocal.setResultadoPartido(Resultado.PERDEDOR);
                    equipoVisitante.setResultadoPartido(Resultado.GANADOR);
                    JOptionPane.showMessageDialog(null,"Ganador: " + equipoVisitante.getNombre()
                            , "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    return equipoVisitante;
                }
            }

            intentos++;
        } while (intentos < maxIntentos);

        JOptionPane.showMessageDialog(null,"No se ha podido determinar un ganador");


        return null;
    }
    }