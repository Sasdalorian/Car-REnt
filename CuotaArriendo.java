public class CuotaArriendo {
    private int numCuota;
    private int valorCuota;
    private boolean pagada;
    
    public CuotaArriendo(int numCuota, int valorCuota, boolean pagada) {
        this.numCuota = numCuota;
        this.valorCuota = valorCuota;
        this.pagada = pagada;
    }
    
    public int getNumCuota() {
        return numCuota;
    }
    
    public void setNumCuota(int numCuota) {
        if (numCuota > 0) {
            this.numCuota = numCuota;
        } else {
            System.out.println("Error: El número de cuota debe ser mayor a 0");
        }
    }
    
    public int getValorCuota() {  
        return valorCuota;
    }
    
    public void setValorCuota(int valorCuota) { 
        if (valorCuota > 0) {
            this.valorCuota = valorCuota;
        } else {
            System.out.println("Error: El valor de la cuota debe ser mayor a 0");
        }
    }
    
    public boolean isPagada() {
        return pagada;
    }
    
    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
    
    // Método según el diagrama
    public boolean pagarCuota() {
        if (!pagada) {
            pagada = true;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Cuota #" + numCuota + " - Valor: $" + valorCuota + " - " + (pagada ? "Pagada" : "Pendiente");
    }
}