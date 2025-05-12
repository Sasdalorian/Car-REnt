package Modelo;

import PackageGUI.*;

import java.util.ArrayList;

public class Main {
    // Hacer que clientes y vehiculos sean variables estáticas de la clase Main
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public static void main(String[] args) {
        // CREACION DE CLIENTES
        clientes.add(new Cliente("12345678-9", "Diana", true));
        clientes.add(new Cliente("98765432-1", "Guts", false));
        clientes.add(new Cliente("12378945-6", "Obi Wan", true));

        System.out.println("CLIENTES REGISTRADOS");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // CREACION DE VEHICULOS Y LISTA
        vehiculos.add(new Auto("ABC123", "Modelo1", "Marca1"));
        vehiculos.add(new Furgon("DEF456", "Modelo2", "Marca2"));
        vehiculos.add(new Camioneta("DEF789", "Modelo3", "Marca3"));

        System.out.println("\n VEHICULOS REGISTRADOS");
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }

        // Inicializar GUI
        new MainGUI();
    }

    // Getter para obtener la lista de clientes
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // Getter para obtener la lista de vehículos
    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
