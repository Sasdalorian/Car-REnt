
public class Camioneta extends Vehiculo {

    public Camioneta(String patente, String modelo, String marca) {
        super(patente, modelo, marca);
    }

    @Override
    public String getTipo() {
        return "Camioneta";
    }

    @Override
    public int getPrecioPorDia() {
        return 35000;
    }
}
