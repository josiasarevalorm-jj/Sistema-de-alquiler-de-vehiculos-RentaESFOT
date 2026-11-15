package com.joel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionVehiculos g=new GestionVehiculos();
        Scanner sc = new Scanner(System.in);
        boolean aire;
        int op;
        do{
            GestionVehiculos.mostrarMenu();
            op=sc.nextInt();sc.nextLine();
            if(op==1){
                System.out.println("Registrar auto");
                System.out.println("Placa: ");
                String placa = sc.nextLine();
                System.out.println("Marca: ");
                String marca = sc.nextLine();
                System.out.println("Modelo: ");
                String modelo = sc.nextLine();
                System.out.println("Tarifa diaria base: ");
                double tarifaInicial = sc.nextDouble();
                System.out.println("Numero de puertas: ");
                int numeroPuertas = sc.nextInt();sc.nextLine();
                System.out.println("¿Tiene aire acondicionado? (s/n)");
                String aireAcondicionado = sc.nextLine();
                if(aireAcondicionado.equalsIgnoreCase("s")){
                    aire = true;
                }else{
                    aire = false;
                }
                g.registrarAuto(placa,marca,modelo,tarifaInicial,numeroPuertas,aire);

            }else if(op==2){
                System.out.println("Registrar camioneta");
                System.out.println("Placa: ");
                String placa = sc.nextLine();
                System.out.println("Marca: ");
                String marca = sc.nextLine();
                System.out.println("Modelo: ");
                String modelo = sc.nextLine();
                System.out.println("Tarifa diaria base: ");
                double tarifaInicial = sc.nextDouble();
                System.out.println("Capacidad de carga (t): ");
                double capacidadCarga = sc.nextDouble();sc.nextLine();
                g.registrarCamioneta(placa,marca,modelo,tarifaInicial,capacidadCarga);
            }else if(op==3){
                System.out.println("Mostrar vehiculos");
                g.mostrarVehiculos();
            }else if(op==4){
                boolean aplica;
                double des;
                System.out.println("Placa: ");
                String placa = sc.nextLine();
                System.out.println("Dias: ");
                int dias = sc.nextInt();sc.nextLine();
                System.out.println("¿Aplica descuento? (s/n): ");
                String descuento= sc.nextLine();
                if (descuento.equalsIgnoreCase("s")){
                    System.out.println("Porcentaje de descuento: ");
                    des=sc.nextDouble();
                    aplica = true;
                    g.cotizarAlquiler(placa,dias,aplica,des);
                }else{
                    des=0.0;
                    aplica = false;
                    g.cotizarAlquiler(placa,dias,aplica,des);
                }
            }else if (op==5){
                g.mostrarEstadisticas();
            }else if(op==6){
                System.out.println("Saliendo..");
                break;
            }
        }while(true);
    }
}