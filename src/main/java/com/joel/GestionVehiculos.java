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
        Vehiculo auto=new Auto(placa,marca,modelo,tarifaInicial,aireAcondicionado,numPuertas);
        for(Vehiculo v:vehiculos){
            if(vehiculos.contains(v.getPlaca())){
                System.out.println("Error: esta placa ya existe");
                return;
            }
        }
        auto.calcularTarifaDiaria();
        vehiculos.add(auto);
        System.out.println("Auto registrado.");
    }
    public void registrarCamioneta(String placa,String marca,String modelo,double tarifaInicial,double capacidadCarga){
        Vehiculo camioneta=new Camioneta(placa,marca,modelo,tarifaInicial,capacidadCarga);
        for(Vehiculo v:vehiculos){
            if(vehiculos.contains(v.getPlaca())){
                System.out.println("Error: esta placa ya existe");
                return;
            }
        }
        camioneta.calcularTarifaDiaria();
        vehiculos.add(camioneta);

        System.out.println("Camioneta registrado.");
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
            }
            if (dias<=0){
                System.out.println("Numero de dias invalido");
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
        double tarifaAlta=0.0;
        String marcaAlta=null;
        String modeloAlta=null;
        int totalTarifas=0;
        double sumaTarifas=0.0;
        for(Vehiculo v: vehiculos){

            if(v.getTarifaDiaria()>tarifaAlta){
                tarifaAlta=v.getTarifaDiaria();
                totalTarifas++;
                totalTarifas+=v.getTarifaDiaria();
            }
            if(v.getTarifaDiaria()==tarifaAlta){
                marcaAlta=v.getMarca();
                modeloAlta=v.getModelo();
            }
        }
        double promedio=sumaTarifas/totalTarifas;
        System.out.println("Vehiculo con mayor tarifa diaria: "+marcaAlta+" "+modeloAlta+": ($"+tarifaAlta+")");
        System.out.println("Promedio de tarifas diarias: $"+promedio);
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
