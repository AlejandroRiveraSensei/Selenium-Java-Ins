package javaexercises;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {
    public static void main(String[] args) {
        List<Figure> figuras = new ArrayList<>();
        figuras.add(new Circulo(3));
        figuras.add(new Cuadrado(4));

        for(Figure f : figuras){
            f.dibujar();
            System.out.println("Area: " + f.calcularArea());
        }
    }
}
