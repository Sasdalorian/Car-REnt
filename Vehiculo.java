
public abstract class Vehiculo {
    protected String patente;
    protected String modelo;
    protected String marca;

    public Vehiculo(String patente, String modelo, String marca) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
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
}
