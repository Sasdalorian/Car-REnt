
public class Furgon extends Vehiculo {

    public Furgon(String patente, String modelo, String marca) {
        super(patente, modelo, marca);
    }

    @Override
    public String getTipo() {
        return "Furgón";
    }

    @Override
    public int getPrecioPorDia() {
        return 40000;
    }
}
