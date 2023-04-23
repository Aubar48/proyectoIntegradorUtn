import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PartidoTest {

    @Test
    public void testConstructorConParametros() {
        Partido partido = new Partido(2, 1);
        assertEquals(partido.getGolesEquipoLocal(), 2);
        assertEquals(partido.getGolesEquipoVisitante(), 1);
    }

    @Test
    public void testGolesRandom() {
        Partido partido = new Partido();
        partido.golesRandom();
        assertTrue(partido.getGolesEquipoLocal() >= 0 && partido.getGolesEquipoLocal() <= 5);
        assertTrue(partido.getGolesEquipoVisitante() >= 0 && partido.getGolesEquipoVisitante() <= 5);
    }

    @Test
    public void testSimularPartido() {
        Equipo equipoLocal = new Equipo("Equipo Local");
        Equipo equipoVisitante = new Equipo("Equipo Visitante");
        Partido partido = new Partido(2, 1);
        Equipo equipoGanador = partido.simularPartido(equipoLocal, equipoVisitante);
        assertEquals(equipoGanador, equipoLocal);
        assertEquals(equipoLocal.getResultadoPartido(), Resultado.GANADOR);
        assertEquals(equipoVisitante.getResultadoPartido(), Resultado.PERDEDOR);
    }

}
