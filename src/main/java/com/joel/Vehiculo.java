package com.joel;

public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private double tarifaInicial;

    public Vehiculo(String placa, String marca, String modelo, double tarifaInicial) {
        setPlaca(placa);
        setMarca(marca);
        setModelo(modelo);
        setTarifaInicial(tarifaInicial);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa == null && !placa.isBlank()) {
            this.placa = placa;
        }else{
            System.out.println("Error: Campo vacio.");
            this.placa ="SIN PLACA";
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null && !marca.isBlank()) {
            this.marca = marca;
        }else {
            System.out.println("Error: Campo vacio.");
            this.marca = "SIN MARCA";
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null && !modelo.isBlank()) {
            this.modelo = modelo;
        }else {
            System.out.println("Error: Campo vacio.");
            this.modelo = "SIN MODELO";
        }
    }

    public double getTarifaInicial() {
        return tarifaInicial;
    }

    public void setTarifaInicial(double tarifaInicial) {
        if(tarifaInicial > 0) {
            this.tarifaInicial = tarifaInicial;
        }else{
            System.out.println("Error: tarifa negativa.");
            this.tarifaInicial = 0;
        }
    }

    public double calcularTarifaDiaria(){
        return tarifaInicial;
    }
    public double calcularAlquiler(int dias){
        if(dias > 0){
            return calcularTarifaDiaria()*dias;
        }else {
            System.out.println("Error: Dias invalidos.");
            return calcularTarifaDiaria();
        }

    }
    public double calcularAlquiler(int dias, double porcentajeDescuento){
        if(dias>0 && porcentajeDescuento>=0 && porcentajeDescuento<=50){
            return calcularAlquiler(dias)*(1-porcentajeDescuento/100);
        }else{
            System.out.println("Error: Porcentaje de descuento negativa o dias invalidos.");
            return calcularAlquiler(dias);
        }
    }
    @Override
    public String toString() {
        return "Vehiculo \nPlaca: "+placa+"\nMarca: "+marca+
                "\nModelo: "+modelo+"\nTarifa: "+String.format("%.2f", calcularTarifaDiaria());

    }
}
