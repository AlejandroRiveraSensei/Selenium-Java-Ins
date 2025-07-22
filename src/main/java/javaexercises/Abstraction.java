package javaexercises;

public class Abstraction {
    public static void main(String[] args) {
        Figure figure = new Cuadrado(5);
        figure.dibujar();
        System.out.println("Area: " + figure.calcularArea());
    }
}

abstract class Figure{
    public abstract void dibujar();
    public abstract double calcularArea();
}

class Circulo extends Figure{
    private double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    public void dibujar(){
        System.out.println("Dibujando un circulo...");
    }

    public double calcularArea(){
        return Math.PI * radio * radio;
    }
}

class Cuadrado extends Figure{
    private double lado;

    public Cuadrado(double lado){
        this.lado = lado;
    }

    public void dibujar(){
        System.out.println("Dibujando un cuadrado...");
    }

    public double calcularArea(){
        return lado * lado;
    }
}