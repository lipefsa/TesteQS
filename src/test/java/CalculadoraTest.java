import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Random;

public class CalculadoraTest {
    private Calculadora calculadora = new Calculadora();

    @Test
     void somarDoisNumerosPositivos() { 
        Random random = new Random(); 
        int a = random.nextInt(100);
        int b = random.nextInt(100); 
         
        int resultadoEsperado = a + b; 
        
        int resultado = calculadora.somar(a, b); 
        assertEquals(resultadoEsperado, resultado); 
    } 

    @Test
    void somarDoisNumerosNegativos() { 
        Random random = new Random(); 
        int a = -random.nextInt(100); 
        int b = -random.nextInt(100);  
        
        int resultadoEsperado = (a + b); 
        
        int resultado = calculadora.somar(a, b); 
        assertEquals(resultadoEsperado, resultado); 
    }

    @Test
    void somarComZero() {
        Random random = new Random(); 
        int a = random.nextInt(100); 
        int b = 0; 
        
        int resultadoEsperado = a + b; 
        
        int resultado = calculadora.somar(a, b); 
        assertEquals(resultadoEsperado, resultado); 
    }

    @Test
    void somarNumerosGrandes() {
        Random random = new Random(); 
        int a = random.nextInt(1000000); 
        int b = random.nextInt(1000000);  
        
        int resultadoEsperado = a + b; 
        
        int resultado = calculadora.somar(a, b); 
        assertEquals(resultadoEsperado, resultado); 
    }


    @Test
    void subtrairDoisNumerosPositivos() {
        Random random = new Random();
        int a = random.nextInt(100); 
        int b = random.nextInt(100);  
        
        int resultadoEsperado = a - b; 
        
        int resultado = calculadora.subtrair(a, b); 
        assertEquals(resultadoEsperado, resultado); 
    }

    @Test
    void subtrairDoisNumerosNegativos() {
        Random random = new Random(); 
        int a = -random.nextInt(100); 
        int b = -random.nextInt(100);  
        
        int resultadoEsperado = (a - b); 
        
        int resultado = calculadora.subtrair(a, b); 
        assertEquals(resultadoEsperado, resultado); 
    }

    @Test
    void subtrairComZero() {
        Random random = new Random(); 
        int a = random.nextInt(100); 
        int b = 0;  
        
        int resultadoEsperado = a - b; 
        
        int resultado = calculadora.subtrair(a, b); 
        assertEquals(resultadoEsperado, resultado); 
    }

    @Test
    void subtrairNumerosGrandes() {
        Random random = new Random(); 
        int a = random.nextInt(1000000); 
        int b = random.nextInt(1000000);  
        
        int resultadoEsperado = a - b; 
        
        int resultado = calculadora.subtrair(a, b); 
        assertEquals(resultadoEsperado, resultado); 
    }


    @Test
    void multiplicarDoisNumerosPositivos() { 
        Random random = mock(Random.class); 
        Calculadora calculadora = new Calculadora();
        when(random.nextInt()).thenReturn(5).thenReturn(3);
        int resultado = calculadora.multiplicar(random.nextInt(), random.nextInt()); 
        assertEquals(15, resultado); 
    }

    @Test
    void multiplicarDoisNumerosNegativos() {
        Random random = mock(Random.class); 
        Calculadora calculadora = new Calculadora();
        when(random.nextInt()).thenReturn(-5).thenReturn(-3);
        int resultado = calculadora.multiplicar(random.nextInt(), random.nextInt()); 
        assertEquals(15, resultado);  
    }

    @Test
    void multiplicarPorZero() {
        Random random = mock(Random.class); 
        Calculadora calculadora = new Calculadora();
        when(random.nextInt()).thenReturn(9);
        int resultado = calculadora.multiplicar(random.nextInt(), 0); 
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
        Random random = mock(Random.class); 
        Calculadora calculadora = new Calculadora();
        when(random.nextInt()).thenReturn(6).thenReturn(2);
        int resultado = calculadora.dividir(random.nextInt(), random.nextInt()); 
        assertEquals(3, resultado); 
    }

    @Test
    void dividirPorNumeroNegativo() {
        Random random = mock(Random.class); 
        Calculadora calculadora = new Calculadora();
        when(random.nextInt()).thenReturn(8).thenReturn(-2);
        int resultado = calculadora.dividir(random.nextInt(), random.nextInt()); 
        assertEquals(-4, resultado); 
    }

    @Test
    void excecaoParaDivisaoPorZero() {
        Calculadora calculadora = new Calculadora();
        Random random = mock(Random.class); 
        int dividendo = random.nextInt();
        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(dividendo, 0);
        }, "Divisão por zero");
    }

    @Test
    void dividirNumeroPorEleMesmo() {
        Random random = mock(Random.class); 
        Calculadora calculadora = new Calculadora();
        when(random.nextInt()).thenReturn(5).thenReturn(5);
        int resultado = calculadora.dividir(random.nextInt(), random.nextInt());
        assertEquals(1, resultado);
    }
}