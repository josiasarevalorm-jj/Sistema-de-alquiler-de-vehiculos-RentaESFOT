package com.joel;

public class Auto extends Vehiculo {
    private int numPuertas;
    private boolean aireAcondicionado;

    public Auto(String placa, String marca, String modelo, double tarifaInicial, boolean aireAcondicionado, int numPuertas) {
        super(placa, marca, modelo, tarifaInicial);
        setNumPuertas(numPuertas);
        setAireAcondicionado(aireAcondicionado);
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        if (numPuertas > 0 && numPuertas <= 10) {
            this.numPuertas = numPuertas;
        }else{
            System.out.println("Error: Puertas invalidas. Se asigo 4");
            this.numPuertas = 4;
        }
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public double calcularTarifaDiaria() {
        if(aireAcondicionado){
            System.out.println("Tarifa de 10$ extra por tener aire acondicionado.");
            return super.calcularTarifaDiaria()+10;
        }else {
            return super.calcularTarifaDiaria();
        }
    }

    @Override
    public String toString() {
        return "[AUTO]\n"+super.toString()+"\nNumero de puertas: "+numPuertas+"\nAire acondicionado: "+aireAcondicionado;
    }
}
