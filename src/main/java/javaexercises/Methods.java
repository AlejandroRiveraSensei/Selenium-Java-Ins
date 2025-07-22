package javaexercises;

public class Methods {

    public static void main(String[] argd){
        saludar("Rivera");
        int resultado = sumar(120, 230, 300);
        System.out.println("suma: " + resultado);

    }

    public static void saludar(String apellido){
        System.out.println("Hola, " + apellido + "!");
    }

    public static int sumar(int a, int b){
        return  a + b;
    }

    public static int sumar(int a, int b, int c){
        return  a + b + c;
    }
}
