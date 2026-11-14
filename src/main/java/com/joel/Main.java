package com.joel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        do{
            GestionVehiculos.mostrarMenu();
            op=sc.nextInt();sc.nextLine();
        }while(true);
    }
}