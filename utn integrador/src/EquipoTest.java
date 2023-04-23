import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EquipoTest {

    @Test
    public void testSumarGolesNuevos() {
        Equipo equipo = new Equipo("Equipo 1");
        equipo.setCantGolesTorneo(5);
        equipo.sumarGolesNuevos(3);
        assertEquals(8, equipo.getCantGolesTorneo());
    }


    @Test
    public void testSetNombre() {
        Equipo equipo = new Equipo();
        equipo.setNombre("Equipo A");
        assertEquals("Equipo A", equipo.getNombre());
    }

    @Test
    public void testSetAndGetCantGolesTorneo() {
        Equipo equipo = new Equipo();
        equipo.setCantGolesTorneo(10);
        assertEquals(10, equipo.getCantGolesTorneo());
    }

}
