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
    public void registrarAuto(Auto auto){
        vehiculos.add(auto);
        System.out.println("Auto registrado.");
    }
    public void registrarCamioneta(Camioneta camioneta){
        vehiculos.add(camioneta);
        System.out.println("Camioneta registrado.");
    }
    public void mostrarVehiculos(){
        for(int i=0;i<vehiculos.size();i++){
            if (!vehiculos.isEmpty()){
                System.out.println(vehiculos.get(i));
            }else{
                System.out.println("Lista vacia.");
                break;
            }
        }
    }
    public void cotizarAlquiler(String placa, int dias){
        if(vehiculos.isEmpty()){
            System.out.println("Lista vacia");
        }

    }
    public String buscarPlaca(String placa) {
        for (int i = 0; i < placas.size(); i++) {
            if (placas.contains(placa)) {
                return placa;
            } else {
                System.out.println("Placa no existe");
                return null;
            }
        }
        return null;
    }
}
