//package Modelo;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//public class ArriendoCuota extends Arriendo {
//    private int cantCuotas;
//    private ArrayList<CuotaArriendo> cuotas;
//
//    // Constante para el máximo de cuotas permitidas (según el diagrama)
//    private static final int MAX_CUOTAS = 6;
//
//    public ArriendoCuota(int numArriendo, String idAuto, int diasArriendo, Cliente cliente,
//                         Vehiculo vehiculo, Date fechaArriendo, int cantCuotas) {
//        super(numArriendo, idAuto, diasArriendo, cliente, vehiculo, fechaArriendo);
//
//        if (cantCuotas > 0 && cantCuotas <= MAX_CUOTAS) {
//            this.cantCuotas = cantCuotas;
//        } else {
//            throw new IllegalArgumentException("La cantidad de cuotas debe estar entre 1 y " + MAX_CUOTAS);
//        }
//
//        this.cuotas = new ArrayList<>();
//    }
//
//
//    public int getCantCuotas() {
//        return cantCuotas;
//    }
//
//    public void setCantCuotas(int cantCuotas) {
//        if (cantCuotas > 0 && cantCuotas <= MAX_CUOTAS) {
//            this.cantCuotas = cantCuotas;
//        } else {
//            System.out.println("Error: La cantidad de cuotas debe estar entre 1 y " + MAX_CUOTAS);
//        }
//    }
//
//    public ArrayList<CuotaArriendo> getCuotas() {
//        return cuotas;
//    }
//
//    public void setCuotas(ArrayList<CuotaArriendo> cuotas) {
//        if (cuotas.size() <= MAX_CUOTAS && cuotas.size() > 0) {
//            this.cuotas = cuotas;
//        } else {
//            throw new IllegalArgumentException("La cantidad de cuotas debe estar entre 1 y " + MAX_CUOTAS);
//        }
//    }
//
//    // Método para generar las cuotas según las especificaciones
//    public ArrayList<CuotaArriendo> generarCuotas() {
//        ArrayList<CuotaArriendo> listaCuotas = new ArrayList<>();
//        double montoTotal = calcularTotal(); // Usando el método heredado de la clase Arriendo
//        double valorCuota = montoTotal / cantCuotas;
//
//        for (int i = 1; i <= cantCuotas; i++) {
//            CuotaArriendo cuota = new CuotaArriendo(i, valorCuota, false);
//            listaCuotas.add(cuota);
//        }
//
//        return listaCuotas;
//    }
//
//    // Método para ingresar arriendo con cuotas
//    public boolean ingresarArriendoConCuota() {
//        if (evaluarArriendo()) {
//            // ambiar condición del vehículo a 'Arrendado'
//            getVehiculo().setCondicion('A');
//             // Asignar cuotas al arriendo invocando generarCuotas()
//            cuotas = generarCuotas();
//            return true;
//        }
//        return false;
//    }
//
//        // Método para buscar una cuota por número (usado por el controlador)
//    public CuotaArriendo buscarCuota(int numCuota) {
//        for (CuotaArriendo cuota : cuotas) {
//            if (cuota.getNumCuota() == numCuota) {
//                return cuota;
//            }
//        }
//        return null;
//    }
//
//    // Método para pagar una cuota específica (usado por el controlador)
//    public boolean pagarCuota(int numCuota) {
//        CuotaArriendo cuota = buscarCuota(numCuota);
//        if (cuota != null) {
//            return cuota.pagarCuota();
//        }
//        return false;
//    }
//
//}
