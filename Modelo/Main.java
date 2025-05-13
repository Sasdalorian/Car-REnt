package Modelo;

import PackageGUI.*;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    // Listas globales de clientes y vehículos
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static void main(String[] args) {
        // CREACIÓN DE CLIENTES
        Cliente diana = new Cliente("12345678-9", "Diana", true);
        Cliente guts = new Cliente("98765432-1", "Guts", false);
        Cliente obiWan = new Cliente("12378945-6", "Obi Wan", true);

        clientes.add(diana);
        clientes.add(guts);
        clientes.add(obiWan);

        System.out.println("CLIENTES REGISTRADOS");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // CREACIÓN DE VEHÍCULOS
        Auto auto1 = new Auto("ABC123", "Modelo1", "Marca1");
        Furgon furgon1 = new Furgon("DEF456", "Modelo2", "Marca2");
        Camioneta cam1 = new Camioneta("GHI789", "Modelo3", "Marca3");

        vehiculos.add(auto1);
        vehiculos.add(furgon1);
        vehiculos.add(cam1);

        System.out.println("\nVEHÍCULOS REGISTRADOS");
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }

        // ARRIENDO PARA OBI WAN CON CUOTAS
        Arriendo arriendo = new Arriendo(1, 5, obiWan, auto1, new Date());

        arriendo.agregarCuota(new CuotaArriendo(1, 20000, false));
        arriendo.agregarCuota(new CuotaArriendo(2, 20000, false));

        obiWan.agregarArriendo(arriendo);

        // INICIALIZAR INTERFAZ GRÁFICA
        new MainGUI();
    }

    // Métodos públicos para acceder desde otras clases
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
