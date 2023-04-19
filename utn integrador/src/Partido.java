import javax.swing.*;
public class Partido {
    //CREO LOS ATRIBUTOS PRIVADOS Y LOS INICIALIZO CON UN NUMERO ENTERO RANDOM PARA SIMULAR LOS GOLES DE LOS EQUIPOS DURANTE EL PARTIDO.
    private int golesEquipoLocal =  (int)(Math.random() * + 6);

    private int golesEquipoVisitante = (int)(Math.random() * + 6);
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
        return "Partido{" +
                "golesEquipoLocal=" + golesEquipoLocal +
                ", golesEquipoVisitante=" + golesEquipoVisitante +
                '}';
    }
    // CREO SUS METODOS
//    public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante){
//        //Muestra un msj con el resultado del partido
//        JOptionPane.showMessageDialog(null,equipoLocal.getNombre()+ " " +
//                        this.golesEquipoLocal+ " - " + this.golesEquipoVisitante + " " +
//                        equipoVisitante.getNombre(), "Resultados del partido",JOptionPane.INFORMATION_MESSAGE);
//        //Suma los goles de los equipos
//        equipoLocal.sumarGolesNuevos(this.golesEquipoLocal);
//        equipoVisitante.sumarGolesNuevos(this.golesEquipoVisitante);
//        //Logica
//        if (this.golesEquipoLocal>this.golesEquipoVisitante){
//            equipoVisitante.setAutorizacion(false);
//            equipoLocal.setResultadoPartido(Resultado.GANADOR);
//            equipoVisitante.setResultadoPartido(Resultado.PERDEDOR);
//            JOptionPane.showMessageDialog(null,"Ganador: " + equipoLocal.getNombre()
//            , "Resultado", JOptionPane.INFORMATION_MESSAGE);
//            return equipoLocal;
//
//        } else if (this.golesEquipoLocal==this.golesEquipoVisitante) {
//            JOptionPane.showMessageDialog(null,"Se jugara el desempate entre "+
//                    equipoLocal.getNombre() + " " + equipoVisitante.getNombre(),"Resultado",
//                    JOptionPane.INFORMATION_MESSAGE);
//            equipoLocal.setResultadoPartido(Resultado.EMPATE);
//            equipoVisitante.setResultadoPartido(Resultado.EMPATE);
//        simularPartido(equipoLocal,equipoVisitante);
//        }else{
//        equipoLocal.setAutorizacion(false);
//        equipoLocal.setResultadoPartido(Resultado.PERDEDOR);
//        equipoVisitante.setResultadoPartido(Resultado.GANADOR);
//            JOptionPane.showMessageDialog(null,"Ganador: " + equipoVisitante.getNombre()
//                    , "Resultado", JOptionPane.INFORMATION_MESSAGE);
//        return equipoVisitante;
//        }
//        return null;
//    }

    public Equipo simularPartido(Equipo equipoLocal, Equipo equipoVisitante){
        int maxIntentos = 3;
        int intentos = 0;

        do {
            // Generar goles aleatorios
            this.golesEquipoLocal = (int) (Math.random() * 6);
            this.golesEquipoVisitante = (int) (Math.random() * 6);

            // Mostrar resultado del partido
            JOptionPane.showMessageDialog(null,equipoLocal.getNombre()+ " " +
                    this.golesEquipoLocal+ " - " + this.golesEquipoVisitante + " " +
                    equipoVisitante.getNombre(), "Resultados del partido",JOptionPane.INFORMATION_MESSAGE);

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
                JOptionPane.showMessageDialog(null,"El partido ha quedado en empate, se volverá a jugar.","Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
                equipoLocal.setResultadoPartido(Resultado.EMPATE);
                equipoVisitante.setResultadoPartido(Resultado.EMPATE);
            } else {
                equipoLocal.setAutorizacion(false);
                equipoLocal.setResultadoPartido(Resultado.PERDEDOR);
                equipoVisitante.setResultadoPartido(Resultado.GANADOR);
                JOptionPane.showMessageDialog(null,"Ganador: " + equipoVisitante.getNombre()
                        , "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return equipoVisitante;
            }

            intentos++;
        } while (intentos < maxIntentos);

        JOptionPane.showMessageDialog(null,"No se ha podido determinar un ganador después de " + maxIntentos + " intentos.","Resultado",
                JOptionPane.INFORMATION_MESSAGE);
        return null;
    }


}
