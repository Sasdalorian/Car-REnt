package Modelo;

public abstract class Vehiculo {
    protected String patente;
    protected String modelo;
    protected String marca;
    protected char condicion; // 'D' para disponible, 'A' para arrendado

    public Vehiculo(String patente, String modelo, String marca) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.condicion = 'D'; // Por defecto, el vehículo está disponible
    }

    public abstract String getTipo();
    public abstract int getPrecioPorDia();

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public char getCondicion() {
        return condicion;
    }

    public void setCondicion(char condicion) {
        if (condicion == 'D' || condicion == 'A') {
            this.condicion = condicion;
        } else {
            System.out.println("Condición inválida. Debe ser 'D' o 'A'");
        }
    }

    @Override
    public String toString() {
        return getTipo() + " - " + marca + " " + modelo + " (" + patente + ")";
    }
}
