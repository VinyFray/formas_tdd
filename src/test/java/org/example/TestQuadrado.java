package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQuadrado {

    private FormaGeometrica quadrado;

    @BeforeEach
    public void setUp(){
        quadrado = new Quadrado();
    }

    @Test
    public void testeQuandoQuadradoRecebeDoisValoresIguaisEValidos(){
        double resultado = quadrado.calcularArea(new double[]{2, 2});

        assertEquals(4, resultado);
    }

    @Test
    public void testeQuandoFornecidoSomenteUmLadoValidoParaCalculo(){
        double resultado = quadrado.calcularArea(new double[]{5});

        assertEquals(25, resultado);
    }


    @Test
    public void testeQuandoQuadradoRecebeDoisValoresDiferentes(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {quadrado.calcularArea(new double[]{4, 2});});
        assertEquals("Os lados do quadrado devem ser iguais", exception.getMessage());
    }

    @Test
    public void testeQuandoFormaRecebeNumeroNegativo(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {quadrado.calcularArea(new double[]{-2, -2});});
        assertEquals("Formas não possuiem numeros negativos", exception.getMessage());
    }

    @Test
    public void testeQuandoFormaRecebeZeroAbsoluto(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {quadrado.calcularArea(new double[]{0, 0});});
        assertEquals("Zero absoluto é inválido", exception.getMessage());
    }

    @Test
    public void testeQuandoMaisDeDoisValoresForemFornecidos(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {quadrado.calcularArea(new double[]{9, 9, 9});});
        assertEquals("Para calcular o quadrado é necessario somente dois lados", exception.getMessage());
    }
}
