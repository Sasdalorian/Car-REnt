
public class Auto extends Vehiculo {

    public Auto(String patente, String modelo, String marca) {
        super(patente, modelo, marca);
    }

    @Override
    public String getTipo() {
        return "Auto";
    }

    @Override
    public int getPrecioPorDia() {
        return 25000;
    }
}
