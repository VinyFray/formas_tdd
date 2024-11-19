package org.example;

public class Quadrado implements FormaGeometrica {

    @Override
    public double calcularArea(double[] lados) {
        validarVertices(lados);

        if(lados.length == 1){
            return lados[0]*lados[0];
        }

        return lados[0]*lados[1];
    }

    private void validarVertices(double[] vertices){
        if(vertices.length > 2)
            throw new RuntimeException("Para calcular o quadrado é necessario somente dois lados");
        if(vertices.length > 1){
            if(vertices[0] != vertices[1])
                throw new RuntimeException("Os lados do quadrado devem ser iguais");
        }

        for (double vertice : vertices){
            if(vertice == 0)
                throw new RuntimeException("Zero absoluto é inválido");
            if(vertice < 0)
                throw new RuntimeException("Formas não possuiem numeros negativos");
        }

    }
}
