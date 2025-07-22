package javaexercises;

import java.util.Arrays;
import java.util.List;

public class Loops {
    public static void main(String[] args){
        // for
        System.out.println("Ciclo for:");
        for(int i = 1; i <= 5; i++){
            System.out.println("Iteracion: " + i);
        }

        //While
        System.out.println("\nCiclo while:");
        int j = 1;
        while (j <= 5){
            System.out.println("Contador: " + j);
            j++;
        }

        //do-while
        System.out.println("\nCiclo do while");
        int k = 100;
        do{
            System.out.println("Numero: " + k);
            k++;
        }while (k <=5);

        //for each
        System.out.println("\nCiclo for-each");
        List<String> frutas = Arrays.asList("Manzana","Banana","Cereza","Pera");
        for (String fruta : frutas){
            System.out.println("Fruta: " + fruta);
        }
    }
}
