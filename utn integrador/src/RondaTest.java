import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RondaTest {
    @Test
    public void testRemoverEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo("Equipo 1"));
        equipos.add(new Equipo("Equipo 2"));
        equipos.add(new Equipo("Equipo 3"));
        equipos.add(new Equipo("Equipo 4"));

        Ronda ronda = new Ronda();
        ronda.setCantEquiposLlave(4);
        ronda.removerEquipos(equipos);

        assertEquals(2, equipos.size());
        assertEquals("Equipo 1", equipos.get(0).getNombre());
        assertEquals("Equipo 2", equipos.get(1).getNombre());
    }

}