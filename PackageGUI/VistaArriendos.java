package PackageGUI;

import Modelo.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaArriendos extends JPanel {
    private JTextField txtFechaArriendo;
    private JTextField txtDias;
    private JTextField txtCantCuotas;
    private JLabel montoPagar;
    private ArrayList<Vehiculo> vehiculos;
    private JComboBox<String> seleccionarCliente;
    private JComboBox<String> seleccionarVehiculo;

    public VistaArriendos(CardLayout cardLayout, JPanel panelContenido) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel vistaArriendosT = new JLabel("ARRIENDO CON CUOTAS", SwingConstants.CENTER);
        vistaArriendosT.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        add(vistaArriendosT, gbc);

        // Seleccionar Cliente
        seleccionarCliente = new JComboBox<>();
        actualizarClientes();

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(seleccionarCliente, gbc);

        // Seleccionar Vehículo
        seleccionarVehiculo = new JComboBox<>();
        actualizarVehiculo();

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(seleccionarVehiculo, gbc);

        // Botón Agregar Cliente
        JButton irACliente = new JButton("Ingresar nuevo Cliente");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        add(irACliente, gbc);
        irACliente.addActionListener(e -> {
            System.out.println("Cambio a Agregar Cliente");
            cardLayout.show(panelContenido, "PANEL1");
        });

        // Fecha Arriendo
        JPanel panelFecha = new JPanel(new BorderLayout(5, 0));
        panelFecha.add(new JLabel("Fecha Arriendo:"), BorderLayout.CENTER);
        txtFechaArriendo = new JTextField(10);
        panelFecha.add(txtFechaArriendo, BorderLayout.EAST);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(panelFecha, gbc);

        // Días
        JPanel panelDias = new JPanel(new BorderLayout(5, 0));
        panelDias.add(new JLabel("Días:"), BorderLayout.CENTER);
        txtDias = new JTextField(10);
        panelDias.add(txtDias, BorderLayout.EAST);

        gbc.gridy = 4;
        add(panelDias, gbc);

        // Precio por día
        JPanel panelPrecio = new JPanel(new BorderLayout(5, 0));
        JLabel precioDia = new JLabel("");
        panelPrecio.add(new JLabel("Precio por día:"), BorderLayout.WEST);
        panelPrecio.add(precioDia, BorderLayout.EAST);

        gbc.gridy = 5;
        add(panelPrecio, gbc);

        // Actualizar Precio cuando se selecciona vehículo
        seleccionarVehiculo.addActionListener(e -> {
            int index = seleccionarVehiculo.getSelectedIndex() - 1;
            if (index >= 0 && index < vehiculos.size()) {
                Vehiculo seleccionado = vehiculos.get(index);
                precioDia.setText("$" + seleccionado.getPrecioPorDia());
            } else {
                precioDia.setText("");
            }
        });

        // Cantidad de Cuotas
        JPanel panelCantCuotas = new JPanel(new BorderLayout(5, 0));
        panelCantCuotas.add(new JLabel("Cantidad de Cuotas:"), BorderLayout.CENTER);
        txtCantCuotas = new JTextField(10);
        panelCantCuotas.add(txtCantCuotas, BorderLayout.EAST);

        gbc.gridy = 6;
        add(panelCantCuotas, gbc);

        // Monto a Pagar
        JPanel panelMontoPagar = new JPanel(new BorderLayout(5, 0));
        panelMontoPagar.add(new JLabel("Monto a Pagar:"), BorderLayout.WEST);
        JLabel montoPagar = new JLabel("");
        panelMontoPagar.add(montoPagar, BorderLayout.EAST);

        gbc.gridy = 7;
        add(panelMontoPagar, gbc);

        // Botón Guardar
        JButton guardaryMostrar = new JButton("Guardar arriendo y mostrar cuotas >>");
        gbc.gridy = 8;
        add(guardaryMostrar, gbc);
        guardaryMostrar.addActionListener(e -> {
            System.out.println("Guardar arriendo y mostrar cuotas");
        });

        // Cuotas a pagar
        JLabel cuotasApagar = new JLabel("CUOTAS A PAGAR", SwingConstants.CENTER);
        gbc.gridy = 2;
        gbc.gridx = 1;
        add(cuotasApagar, gbc);

        // Botón Pagar primera cuota
        JButton pagarPCuota = new JButton("Pagar primera cuota");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(pagarPCuota, gbc);
        pagarPCuota.addActionListener(e -> {
            System.out.println("Cambio de Vista a Pagar");
            cardLayout.show(panelContenido, "PANEL3");
        });
    }

    // Actualizar clientes de la lista
    public void actualizarClientes() {
        seleccionarCliente.removeAllItems();
        seleccionarCliente.addItem("Seleccionar Cliente");

        ArrayList<Cliente> clientes = Main.getClientes();
        for (Cliente c : clientes) {
            seleccionarCliente.addItem(c.getNombre());
        }
    }

    // Actualizar vehiculos de la lista
    public void actualizarVehiculo() {
        seleccionarVehiculo.removeAllItems();
        seleccionarVehiculo.addItem("Seleccionar Vehículo");

        vehiculos = Main.getVehiculos();
        for (Vehiculo v : vehiculos) {
            seleccionarVehiculo.addItem(v.getTipo());
        }
    }
}
