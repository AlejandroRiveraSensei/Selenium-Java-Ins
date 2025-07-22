package javaexercises;

import java.util.ArrayList;
import java.util.List;

public class ListAndArrays {
    public static void main(String[] args){
        //Areglo fijo
        String[] colores = {"rojo","verde","azul"};
        System.out.println("Arreglo:");
        for (int i = 0; i < colores.length; i ++){
            System.out.println("Color[" + i + "]" + colores[i]);
        }


        //Lista dinamica
        List<String> animales = new ArrayList<>();
        animales.add("perro");
        animales.add("gato");
        animales.add("loro");
        System.out.println("\nLista: ");
        for (String animal : animales){
            System.out.println("Animal: " + animal);
        }

        animales.remove("gato");
        animales.add("conejo");

        System.out.println("\nLista Actualizada: ");
        for (String animal : animales){
            System.out.println("Animal: " + animal);
        }

    }


}
