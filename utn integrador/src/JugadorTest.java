import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class JugadorTest {

    @Test
    public void testElegirEquipo() {
        //CREAMOS LA LISTA DE EQUIPOS PARA EL TEST
        List<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo("Equipo 1"));
        equipos.add(new Equipo("Equipo 2"));
        equipos.add(new Equipo("Equipo 3"));

        //CREAMOS UN JUGADOR PARA EL TEST
        Jugador jugador = new Jugador();

        //LLAMAMOS AL MÉTODO PARA ELEGIR EQUIPO CON LA LISTA CREADA
        jugador.elegirEquipo(equipos);

        //VERIFICAMOS QUE EL EQUIPO SELECCIONADO ES VÁLIDO
        Assertions.assertTrue(jugador.getEquipoSeleccionado() != null && equipos.contains(jugador.getEquipoSeleccionado()));
    }

    @Test
    public void testSumarPuntos() {
        //CREAMOS UN EQUIPO PARA EL TEST
        Equipo equipo = new Equipo("Equipo de prueba");

        //CREAMOS UN JUGADOR PARA EL TEST Y ASIGNAMOS EL EQUIPO CREADO
        Jugador jugador = new Jugador();
        jugador.setEquipoSeleccionado(equipo);

        //SUMAMOS PUNTOS AL JUGADOR Y VERIFICAMOS QUE SE HAYAN AGREGADO CORRECTAMENTE
        jugador.sumarPuntos();
        jugador.sumarPuntos();
        jugador.sumarPuntos();
        Assertions.assertEquals(3, jugador.getPuntaje());
    }
}
