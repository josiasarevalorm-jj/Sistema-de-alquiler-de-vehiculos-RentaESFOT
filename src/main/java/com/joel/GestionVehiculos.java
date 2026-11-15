package com.joel;

import java.util.ArrayList;
import java.util.HashSet;

public class GestionVehiculos {
    private ArrayList<Vehiculo> vehiculos=new ArrayList<>();
    private HashSet<String> placas=new HashSet<>();

    public static void mostrarMenu(){
        System.out.println("--- MENÚ RENTAESFOT ---");
        System.out.println("1.Registrar auto\n2.Registrar camioneta\n3.Mostrar vehiculos" +
                "\n4.Cotizar alquiler\n5.Mostrar estadísticas\n6.Salir\nEscoja una opcion: ");
    }
    public void registrarAuto(String placa,String marca,String modelo,double tarifaInicial,int numPuertas,boolean aireAcondicionado){
        if(tarifaInicial<0){
            System.out.println("Error: tarifa negativa.");
            return;
        }
        if(!placas.add(placa.toUpperCase())){
                System.out.println("Error: esta placa ya existe");
            }else{
                Vehiculo auto=new Auto(placa.toUpperCase(),marca,modelo,tarifaInicial,aireAcondicionado,numPuertas);
                vehiculos.add(auto);
                System.out.println("Auto registrado.");
            }
    }
    public void registrarCamioneta(String placa,String marca,String modelo,double tarifaInicial,double capacidadCarga){
        if(tarifaInicial<0){
            System.out.println("Error: tarifa negativa.");
            return;
        }
        for(Vehiculo v:vehiculos){
            if(placas.add(placa.toUpperCase())){
                System.out.println("Error: esta placa ya existe");
            }else{
                Vehiculo camioneta=new Camioneta(placa.toUpperCase(),marca,modelo,tarifaInicial,capacidadCarga);
                vehiculos.add(camioneta);
                System.out.println("Camioneta registrado.");
                break;
            }
        }

    }
    public void mostrarVehiculos(){
        if(vehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrado.");
            return;
        }
        for(int i=0;i<vehiculos.size();i++){
                System.out.println(vehiculos.get(i));
        }
    }

    public void cotizarAlquiler(String placa, int dias,boolean aplicaDescuento,double porcentajeDescuento){
        double total;
        if(vehiculos.isEmpty()){
            System.out.println("Lista vacia");
        }
            Vehiculo encontrado = buscarPlaca(placa);
            if (encontrado == null) {
                System.out.println("Placa no encontrado");
                return;
            }
            if (dias<=0){
                System.out.println("Numero de dias invalido");
                return;
            }
            if(aplicaDescuento){
                if (porcentajeDescuento<=50 && porcentajeDescuento>=0){
                    total= encontrado.calcularAlquiler(dias,porcentajeDescuento);
                    System.out.println("Total a pagar: "+total);
                }else{
                    System.out.println("Porcentaje de descuento no valido");
                }
            }else{
                total=encontrado.calcularAlquiler(dias);
                System.out.println("Total a pagar: "+total);
            }

    }
    public void mostrarEstadisticas(){
        if(vehiculos.isEmpty()){
            System.out.println("Lista vacia");
            return;
        }
        double tarifaAlta=0.0;
        String marcaAlta=null;
        String modeloAlta=null;
        int totalTarifas=0;
        double sumaTarifas=0.0;
        for(Vehiculo v: vehiculos){
            double tarifaReal= v.calcularTarifaDiaria();
            if(tarifaReal>tarifaAlta) {
                tarifaAlta = tarifaReal;
                marcaAlta = v.getMarca();
                modeloAlta = v.getModelo();
            }
            sumaTarifas+=tarifaReal;
            totalTarifas++;
        }
        double promedio=sumaTarifas/totalTarifas;
        System.out.println("Vehiculo con mayor tarifa diaria: "+marcaAlta+" "+modeloAlta+" ($"+String.format("%.2f",tarifaAlta)+")");
        System.out.println("Promedio de tarifas diarias: $"+String.format("%.2f",promedio));
    }

    public Vehiculo buscarPlaca(String placa) {
        for (Vehiculo v: vehiculos){
            if(v.getPlaca().equalsIgnoreCase(placa)){
                return v;
            }
        }
        return null;
    }

}
