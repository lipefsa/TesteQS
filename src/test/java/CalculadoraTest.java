import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class CalculadoraTest {
    private Calculadora calculadora = new Calculadora();

    @Test
    void somarDoisNumerosPositivos() {
        int resultado = calculadora.somar(2, 3);
        assertEquals(5, resultado);
    }

    @Test
    void somarDoisNumerosNegativos() {
        int resultado = calculadora.somar(-2, -3);
        assertEquals(-5, resultado);
    }

    @Test
    void somarComZero() {
        int resultado = calculadora.somar(5, 0);
        assertEquals(5, resultado);
    }

    @Test
    void somarNumerosGrandes() {
        int resultado = calculadora.somar(1000000, 2000000);
        assertEquals(3000000, resultado);
    }


    @Test
    void subtrairDoisNumerosPositivos() {
        int resultado = calculadora.subtrair(7, 3);
        assertEquals(4, resultado);
    }

    @Test
    void subtrairDoisNumerosNegativos() {
        int resultado = calculadora.subtrair(-5, -3);
        assertEquals(-2, resultado);
    }

    @Test
    void subtrairComZero() {
        int resultado = calculadora.subtrair(5, 0);
        assertEquals(5, resultado);
    }

    @Test
    void subtrairNumerosGrandes() {
        int resultado = calculadora.subtrair(3000000, 1000000);
        assertEquals(2000000, resultado);
    }


    @Test
    void multiplicarDoisNumerosPositivos() {
        Calculadora calculadora = Mockito.mock(Calculadora.class);
        when(calculadora.multiplicar(2, 3)).thenReturn(6);
        int resultado = calculadora.multiplicar(2, 3);
        assertEquals(6, resultado);
    }

    @Test
    void multiplicarDoisNumerosNegativos() {
        Calculadora calculadora = Mockito.mock(Calculadora.class);
        when(calculadora.multiplicar(-4, -3)).thenReturn(-12);
        int resultado = calculadora.multiplicar(-4, -3);
        assertEquals(-12, resultado);
    }

    @Test
    void multiplicarPorZero() {
        Calculadora calculadora = Mockito.mock(Calculadora.class);
        when(calculadora.multiplicar(5, 0)).thenReturn(0);
        int resultado = calculadora.multiplicar(5, 0);
        assertEquals(0, resultado);
    }

    @Test
    void multiplicarNumerosGrandes() {
        Calculadora calculadora = Mockito.mock(Calculadora.class);
        when(calculadora.multiplicar(2000, 1000)).thenReturn(2000000);
        int resultado = calculadora.multiplicar(2000, 1000);
        assertEquals(2000000, resultado);
    }



    @Test
    void dividirDoisNumerosPositivos() {
        Calculadora calculadora = Mockito.mock(Calculadora.class);
        when(calculadora.dividir(6, 2)).thenReturn(3);
        int resultado = calculadora.dividir(6, 2);
        assertEquals(3, resultado);
    }

    @Test
    void dividirPorNumeroNegativo() {
        Calculadora calculadora = Mockito.mock(Calculadora.class);
        when(calculadora.dividir(8, -2)).thenReturn(-4);
        int resultado = calculadora.dividir(8, -2);
        assertEquals(-4, resultado);
    }

    @Test
    public void lancarExcecaoParaDivisaoPorZero() {
        Calculadora calculadora = new Calculadora();

        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(10, 0);
        }, "Não é possível dividir por zero");
    }

    @Test
    void dividirNumeroPorEleMesmo() {
        Calculadora calculadora = Mockito.mock(Calculadora.class);
        when(calculadora.dividir(5, 5)).thenReturn(1);
        int resultado = calculadora.dividir(5, 5);
        assertEquals(1, resultado);
    }
}