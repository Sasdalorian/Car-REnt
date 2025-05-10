package PackageGUI;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    public MainGUI() {
        setTitle("Sistema de Arriendo de Vehículos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

    // PANEL DE PESTAÑAS
        JPanel panel = new JPanel();
        JButton boton1 = new JButton("Agregar Cliente");
        boton1.setBounds(10, 10, 90, 30);
        JButton boton2 = new JButton("Arriendos con Cuotas");
        boton2.setBounds(110, 10, 90, 30);
        JButton boton3 = new JButton("Pagar Cuotas");
        boton3.setBounds(220, 10, 90, 30);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);

        // PANEL DE CONTENIDO
        JPanel panelContenido = new JPanel(new CardLayout());


        //AGREGAR VISTAS A PANEL DE CONTENIDO
        VistaClientes vistaClientes = new VistaClientes();
        VistaArriendos vistaArriendos = new VistaArriendos();
        VistaPago vistaPago = new VistaPago();

        //AGREGAR VISTAS A PANEL DE CONTENIDO
        panelContenido.add(vistaClientes, "PANEL1");
        panelContenido.add(vistaArriendos, "PANEL2");
        panelContenido.add(vistaPago, "PANEL3");

        CardLayout cl = (CardLayout) panelContenido.getLayout();
        boton1.addActionListener(e -> cl.show(panelContenido, "PANEL1"));
        boton2.addActionListener(e -> cl.show(panelContenido, "PANEL2"));
        boton3.addActionListener(e -> cl.show(panelContenido, "PANEL3"));

        add(panel, BorderLayout.NORTH);
        add(panelContenido, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);

//        add(new JLabel("Nombre del Cliente:"));
//        txtCliente = new JTextField();
//        add(txtCliente);
//
//        add(new JLabel("Marca del Vehículo:"));
//        txtMarca = new JTextField();
//        add(txtMarca);
//
//        add(new JLabel("Modelo del Vehículo:"));
//        txtModelo = new JTextField();
//        add(txtModelo);
//
//        add(new JLabel("Patente del Vehículo:"));
//        txtPatente = new JTextField();
//        add(txtPatente);
//
//        add(new JLabel("Tipo de Vehículo:"));
//        String[] vehiculos = {"Auto", "Camioneta", "Furgón"};
//        comboVehiculo = new JComboBox<>(vehiculos);
//        add(comboVehiculo);
//
//        add(new JLabel("Días de Arriendo:"));
//        txtDias = new JTextField();
//        add(txtDias);
//
//        add(new JLabel("Total a Pagar:"));
//        lblResultado = new JLabel("");
//        add(lblResultado);

//        btnCalcular = new JButton("Calcular total");
//        btnCalcular.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//                calcularTotal();
//            }
//        });
//        add(btnCalcular);
//
//        btnLimpiar = new JButton("Limpiar");
//        btnLimpiar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//                limpiarCampos();
//            }
//        });
//        add(btnLimpiar);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
//    private void calcularTotal() {
//        try {
//            String cliente = txtCliente.getText().trim();
//            String marca = txtMarca.getText().trim();
//            String modelo = txtModelo.getText().trim();
//            String patente = txtPatente.getText().trim();
//            int dias = Integer.parseInt(txtDias.getText().trim());
//            String tipo = (String) comboVehiculo.getSelectedItem();
//
//            Vehiculo vehiculo = null;
//            if (tipo.equals("Auto")) {
//                vehiculo = new Auto(patente, modelo, marca);
//            } else if (tipo.equals("Camioneta")) {
//                vehiculo = new Camioneta(patente, modelo, marca);
//            } else if (tipo.equals("Furgón")) {
//                vehiculo = new Furgon(patente, modelo, marca);
//            }
//
//            Arriendo arriendo = new Arriendo(cliente, vehiculo, dias);
//            lblResultado.setText("$" + arriendo.calcularTotal());
//            guardarArriendo(arriendo, "fichaArriendo.txt");
//
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(this, "Ingrese un número válido de días.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void limpiarCampos() {
//        txtCliente.setText("");
//        txtMarca.setText("");
//        txtModelo.setText("");
//        txtPatente.setText("");
//        txtDias.setText("");
//        lblResultado.setText("");
//        comboVehiculo.setSelectedIndex(0);
//    }
//
//    public static void guardarArriendo(Arriendo arriendo, String nombreArchivo) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
//            writer.write("Arriendo:\n");
//            writer.write("-Cliente: " + arriendo.getCliente() + "\n");
//            writer.write("-Tipo de Vehiculo: " + arriendo.getVehiculo().getTipo() + "\n");
//            writer.write("-Marca: " + arriendo.getVehiculo().getMarca() + "\n");
//            writer.write("-Modelo: " + arriendo.getVehiculo().getModelo() + "\n");
//            writer.write("-Patente: " + arriendo.getVehiculo().getPatente() + "\n");
//            writer.write("-Precio por dia : " + arriendo.getVehiculo().getPrecioPorDia() + "\n");
//            writer.write("-Dias de Arriendo " + arriendo.getDias() + "\n");
//            writer.write("-Precio Total " + arriendo.calcularTotal() + "\n");
//            System.out.println("Datos guardados en " + nombreArchivo);
//        } catch (Exception e) {
//            System.out.println("Error al guardar el archivo: " + e.getMessage());
//        }
//    }
}
