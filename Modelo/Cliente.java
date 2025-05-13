package Modelo;

import java.util.ArrayList;

public class Cliente {
    private String cedula;
    private String nombre;
    private boolean vigente;
    private ArrayList<Arriendo> arriendos;  // NUEVO

    public Cliente(String cedula, String nombre, boolean vigente) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.vigente = vigente;
        this.arriendos = new ArrayList<>(); // NUEVO
    }

    // Cedula
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (validarCedula(cedula)) {
            this.cedula = cedula;
        } else {
            System.out.println("Error: Cédula inválida");
        }
    }

    // Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (validarNombre(nombre)) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: Nombre inválido");
        }
    }

    // Vigente
    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    // Arriendos (NUEVO)
    public ArrayList<Arriendo> getArriendos() {
        return arriendos;
    }

    public void agregarArriendo(Arriendo arriendo) {
        arriendos.add(arriendo);
    }

    // Validaciones
    public boolean validarCedula(String cedula) {
        return cedula != null && !cedula.trim().isEmpty();
    }

    public boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + " | cedula: " + cedula + " | vigente: " + vigente;
    }
}
