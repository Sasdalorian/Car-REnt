package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Arriendo {
    private int numArriendo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int diasArriendo;
    private Date fechaArriendo;
    private ArrayList<CuotaArriendo> cuotas;  // NUEVO

    public Arriendo(int numArriendo, int diasArriendo, Cliente cliente, Vehiculo vehiculo, Date fechaArriendo) {
        this.numArriendo = numArriendo;
        this.diasArriendo = diasArriendo;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaArriendo = fechaArriendo;
        this.cuotas = new ArrayList<>(); // NUEVO
    }

    public double calcularTotal() {
        return obtenerMontoAPagar(vehiculo.getPrecioPorDia());
    }

    public double obtenerMontoAPagar(int precioDiario) {
        return diasArriendo * precioDiario;
    }

    public boolean evaluarArriendo() {
        return cliente.isVigente() && vehiculo.getCondicion() == 'D';
    }

    // Getters y setters
    public int getNumArriendo() {
        return numArriendo;
    }

    public void setNumArriendo(int numArriendo) {
        this.numArriendo = numArriendo;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Date fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getClienteNombre() {
        return cliente != null ? cliente.getNombre() : "";
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getDiasArriendo() {
        return diasArriendo;
    }

    public void setDiasArriendo(int diasArriendo) {
        this.diasArriendo = diasArriendo;
    }

    // NUEVO: Cuotas
    public ArrayList<CuotaArriendo> getCuotas() {
        return cuotas;
    }

    public void agregarCuota(CuotaArriendo cuota) {
        cuotas.add(cuota);
    }
}
