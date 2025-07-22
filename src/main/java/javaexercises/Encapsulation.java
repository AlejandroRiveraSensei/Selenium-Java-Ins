package javaexercises;

public class Encapsulation {
    public static void main(String[] args) {
        Persona alejandro = new Persona("Alejandro", 33);
        System.out.println("Nombre: " + alejandro.getNombre());
        System.out.println("Edad: " + alejandro.getEdad());

        alejandro.setEdad(34);
        System.out.println("Edad actualizada: " + alejandro.getEdad());

    }
}

class Persona{
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        if (edad > 0){
            this.edad = edad;
        }
    }
}