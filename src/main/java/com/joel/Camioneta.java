package com.joel;

public class Camioneta extends Vehiculo{
    private double capacidadCarga;

    public Camioneta(String placa, String marca, String modelo, double tarifaInicial, double capacidadCarga) {
        super(placa, marca, modelo, tarifaInicial);
        setCapacidadCarga(capacidadCarga);
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        if (capacidadCarga >= 0) {
            this.capacidadCarga = capacidadCarga;
        }else{
            System.out.println("Capacidad negativo");
        }
    }

    @Override
    public double calcularTarifaDiaria() {
        if (this.capacidadCarga >= 1.5){
            return super.calcularTarifaDiaria()+(super.calcularTarifaDiaria()*0.15);
        }else{
            return super.calcularTarifaDiaria();
        }
    }

    @Override
    public String toString() {
        return "[CAMIONETA]\n"+super.toString()+"Capacidad de carga: "+capacidadCarga;
    }
}
