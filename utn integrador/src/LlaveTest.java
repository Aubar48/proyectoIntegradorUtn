import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LlaveTest {

    @Test
    @DisplayName("Prueba para armar una llave válida")
    public void testArmarLlavesValido() {
        // Crear lista de equipos para la llave
        List<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("Equipo 1"));
        listaEquipos.add(new Equipo("Equipo 2"));
        listaEquipos.add(new Equipo("Equipo 3"));
        listaEquipos.add(new Equipo("Equipo 4"));
        listaEquipos.add(new Equipo("Equipo 5"));
        listaEquipos.add(new Equipo("Equipo 6"));
        listaEquipos.add(new Equipo("Equipo 7"));
        listaEquipos.add(new Equipo("Equipo 8"));

        // Crear una llave con los equipos desde el índice 0
        Llave llave = new Llave();
        llave.armarLlaves(listaEquipos, 0);

        // Verificar que la llave tiene los equipos correctos
        List<Equipo> equiposLlaveEsperados = Arrays.asList(
                new Equipo("Equipo 1"),
                new Equipo("Equipo 2"),
                new Equipo("Equipo 3"),
                new Equipo("Equipo 4")
        );
        Assertions.assertEquals(equiposLlaveEsperados, llave.getEquiposListaLlave(), "Los equipos de la llave son incorrectos");
    }

    @Test
    @DisplayName("Prueba para armar una llave con índice fuera de rango")
    public void testArmarLlavesIndiceFueraDeRango() {
        // Crear lista de equipos para la llave
        List<Equipo> listaEquipos = new ArrayList<>();
        listaEquipos.add(new Equipo("Equipo 1"));
        listaEquipos.add(new Equipo("Equipo 2"));
        listaEquipos.add(new Equipo("Equipo 3"));
        listaEquipos.add(new Equipo("Equipo 4"));

        // Crear una llave con los equipos desde un índice fuera de rango
        Llave llave = new Llave();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> llave.armarLlaves(listaEquipos, 4), "Se esperaba una excepción al especificar un índice fuera de rango");
    }
}
