package javaexercises;

public class Condicionales {

    public static void main(String[] args){
        int edad = 15;

        //IF
        if (edad >= 18){
            System.out.println("Eres mayor de edad");
        }

        //If-else
        if(edad < 18){
            System.out.println("Eres menor de edad");
        }else{
            System.out.println("Tienes al menos 18 años");
        }

        //IF-ELSE-IF
        int calificacion = 69;
        if(calificacion >= 90){
            System.out.println("Excelente");
        }else if (calificacion >=80){
            System.out.println("Muy bien");
        }else if (calificacion >= 70){
            System.out.println("Bien");
        }else{
            System.out.println("Requiere mejora");
        }

        //IF anidado
        boolean tieneCuenta = false;
        boolean tieneFondos = true;

        if(tieneCuenta){
            if(tieneFondos){
                System.out.println("Puedes hacer un compra");
            }else{
                System.out.println("No tienes fondos suficientes");
            }
        }else{
            System.out.println("No tienes cuenta registrada");
        }

        //Switch
        int diaSemana = 9;

        switch (diaSemana){
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            default:
                System.out.println("Dia invalido");
        }

        //Operadr ternario
        String mensaje = (edad >= 18) ? "Adulto" : "Menor de edad";
        System.out.println("Ternario: " + mensaje);

    }
}
