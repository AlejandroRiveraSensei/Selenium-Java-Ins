package javaexercises;

public class Constructors {
    public static void main(String[] args) {
        Alumno sensei = new Alumno("Alejandro", 33);
        sensei.presentarse();

        Alumno alumno = new Alumno("Andrea",22);
        alumno.presentarse();
    }
}

class Alumno{
    String nombre;
    int edad;

    public Alumno(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public void presentarse(){
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }
}
