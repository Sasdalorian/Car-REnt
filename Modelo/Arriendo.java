//package Modelo;
//
////Model
//public class Arriendo {
//    private int numArriendo; // Agregado según el diagrama
//    private Cliente cliente;  // Modificado para usar la clase Cliente
//    private Vehiculo vehiculo;
//    private int diasArriendo; // Renombrado de dias a diasArriendo
//    private Date fechaArriendo; // Agregado según el diagrama
//
//    // Constructor modificado para usar Cliente
//    public Arriendo(int numArriendo, int diasArriendo, Cliente cliente, Vehiculo vehiculo, Date fechaArriendo) {
//        this.numArriendo = numArriendo;
//        this.diasArriendo = diasArriendo;
//        this.cliente = cliente;
//        this.vehiculo = vehiculo;
//        this.fechaArriendo = fechaArriendo;
//    }
//
//    // Método compatible con el código existente
//    public int calcularTotal() {
//        return obtenerMontoAPagar(vehiculo.getPrecioPorDia());
//    }
//
//    // Métodos según el diagrama
//    public double obtenerMontoAPagar(int precioDiario) {
//        return diasArriendo * precioDiario;
//    }
//
//    public boolean evaluarArriendo() {
//        return cliente.isVigente() && vehiculo.getCondicion() == 'D';
//    }
//
//    // Getters y setters
//    public int getNumArriendo() {
//        return numArriendo;
//    }
//
//    public void setNumArriendo(int numArriendo) {
//        this.numArriendo = numArriendo;
//    }
//
//    public Date getFechaArriendo() {
//        return fechaArriendo;
//    }
//
//    public void setFechaArriendo(Date fechaArriendo) {
//        this.fechaArriendo = fechaArriendo;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public String getClienteNombre() {
//        return cliente != null ? cliente.getNombre() : "";
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public Vehiculo getVehiculo() {
//        return vehiculo;
//    }
//
//    public void setVehiculo(Vehiculo vehiculo) {
//        this.vehiculo = vehiculo;
//    }
//
//    public int getDiasArriendo() {
//        return diasArriendo;
//    }
//
//    public void setDiasArriendo(int diasArriendo) {
//        this.diasArriendo = diasArriendo;
//    }
//
//}
