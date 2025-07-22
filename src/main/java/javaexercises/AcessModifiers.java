package javaexercises;

public class AcessModifiers {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Sensei",1000.00);
        cuenta.mostrarSaldo();
    }
}

class Cuenta{
    private String titular;
    private double saldo;

    public Cuenta(String titular, double saldo){
        this.titular = titular;
        this.saldo = saldo;
    }

    public void mostrarSaldo(){
        System.out.println("Titular: " + titular);
        System.out.println("Saldo disponible: $" + saldo);
    }
}