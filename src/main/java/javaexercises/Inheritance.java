package javaexercises;

public class Inheritance {
    public static void main(String[] args) {
        Perro miPerro = new Perro("Solovino");
        miPerro.hablar();
        miPerro.dormir();
    }
}

class Animal{
    public void dormir(){
        System.out.println("El animal duerme...");
    }
}

class Perro extends Animal{
    private String nombre;

    public Perro(String nombre){
        this.nombre = nombre;
    }

    public void hablar(){
        System.out.println(nombre + " dice: Guau!!!");
    }
}