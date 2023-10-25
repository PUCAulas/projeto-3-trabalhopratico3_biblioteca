package tdd1;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.time.Duration;
import java.time.LocalTime;
//import java.time.DateTimeException;
//import java.lang.NullPointerException;;

public class RelogioTest {

    Relogio relogio = new Relogio();

    @Test
    public void testDefinirHora() {
        relogio.definirHora(10, 30, 10);
        assertEquals("10:30:10", relogio.obterHora());
    }

    /*@Test
    public void testDefinirHoraInvalida() {
        assertThrows(IllegalArgumentException.class, () -> relogio.definirHora(25, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> relogio.definirHora(10, 61, 0));
    }*/

    @Test
    public void testReiniciarMeiaNoite() {
        relogio.definirHora(14, 30, 00);
        relogio.reiniciarMeiaNoite();
        assertEquals("00:00", relogio.obterHora());
    }

    @Test
    public void testIniciarCronometro() {
        LocalTime tempoInicial;
        tempoInicial = LocalTime.now();
        relogio.iniciarCronometro();
        assertFalse(tempoInicial.isBefore(tempoInicial));
    }

        @Test
        public void testObterTempoDecorrido() {

            Relogio tempoDecorrido = new Relogio();
            tempoDecorrido.iniciarCronometro();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Duration tempoDecorridoObtido = tempoDecorrido.obterTempoDecorrido();
            assertFalse(tempoDecorridoObtido.toMillis() >= 0);
        }


    @Test
    public void testAtualizarTempo() {

        relogio.definirHora(10, 0, 0);
        relogio.atualizarTempo(1, 30, 15);
        assertEquals("01:30:15", relogio.obterHora());
    }

    @Test
    public void testImprimirFormato24h() {
        relogio.definirHora(15, 45, 30);
        assertEquals("15:45:30", relogio.imprimirFormato24h());
    }

    @Test
    public void testImprimirFormatoAMPM() {
        relogio.definirHora(18, 15, 00);
        assertEquals("06:15:00 PM", relogio.imprimirFormatoAMPM());
    }

    @Test
    public void testAtualizarTempoSistema() {
        relogio.atualizarTempoSistema();
        assertTrue(relogio.obterHora().compareTo("00:00:00") > 0);
    }

}
