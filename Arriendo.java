//Model
public class Arriendo {
    private String cliente;
    private Vehiculo vehiculo;
    private int dias;

    public Arriendo(String cliente, Vehiculo vehiculo, int dias) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;
    }

    public int calcularTotal() {
        return vehiculo.getPrecioPorDia() * dias;
    }

    public String getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public int getDias() {
        return dias;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
}
