package PackageGUI;

import javax.swing.*;
import java.awt.*;

public class VistaArriendos extends JPanel {
    private JTextField txtFechaArriendo;
    private JTextField txtDias;
    private JTextField txtPrecio;
    private JTextField txtCantCuotas;

    public VistaArriendos() {
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
        JComboBox<String> seleccionarCliente = new JComboBox<>();
        // EJEMPLO
        seleccionarCliente.addItem("Seleccionar Cliente");
        seleccionarCliente.addItem("Cliente 1");
        seleccionarCliente.addItem("Cliente 2");
        seleccionarCliente.setSelectedIndex(0);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(seleccionarCliente, gbc);

        // Seleccionar Vehículo
        JComboBox<String> seleccionarVehiculo = new JComboBox<>();
        //EJEMPLO
        seleccionarVehiculo.addItem("Seleccionar Vehiculo");
        seleccionarVehiculo.addItem("Vehiculo 1");
        seleccionarVehiculo.addItem("Vehiculo 2");
        seleccionarVehiculo.setSelectedIndex(0);

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(seleccionarVehiculo, gbc);

        //Boton Agregar Cliente
        JButton irACliente = new JButton("Ingresar nuevo Cliente");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        add(irACliente, gbc);

        // Fecha Arriendo (etiqueta + campo)
        JPanel panelFecha = new JPanel(new BorderLayout(5, 0));
        panelFecha.add(new JLabel("Fecha Arriendo:"), BorderLayout.CENTER);

        txtFechaArriendo = new JTextField(10);
        panelFecha.add(txtFechaArriendo, BorderLayout.EAST);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(panelFecha, gbc);

        // Dias (etiqueta + campo)
        JPanel panelDias = new JPanel(new BorderLayout(5, 0));
        panelDias.add(new JLabel("Dias:"), BorderLayout.CENTER);

        txtDias = new JTextField(10);
        panelDias.add(txtDias, BorderLayout.EAST);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(panelDias, gbc);

        // Precio por dia
        JPanel panelPrecio = new JPanel(new BorderLayout(5, 0));
        panelPrecio.add(new JLabel("Precio por dia:"), BorderLayout.CENTER);

        txtPrecio = new JTextField(10);
        panelPrecio.add(txtPrecio, BorderLayout.EAST);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(panelPrecio, gbc);

        // Cantidad de Cuotas
        JPanel panelCantCuotas = new JPanel(new BorderLayout(5, 0));
        panelCantCuotas.add(new JLabel("Cantidad de Cuotas:"), BorderLayout.CENTER);

        txtCantCuotas = new JTextField(10);
        panelCantCuotas.add(txtCantCuotas, BorderLayout.EAST);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(panelCantCuotas, gbc);

        // Monto a PAGAR
        JPanel panelMontoPagar = new JPanel(new BorderLayout(5, 0));
        panelMontoPagar.add(new JLabel("Monto a Pagar:"), BorderLayout.WEST);
        // Crear JLabel vacío para el monto
        JLabel montoTotal = new JLabel("", SwingConstants.CENTER);
        panelMontoPagar.add(montoTotal, BorderLayout.CENTER);
        // Agregar el panel al GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);
        add(panelMontoPagar, gbc);

        // Guardar arriendo y mostrar cuotas
        JButton GuardaryMostrar = new JButton("Guardar arriendo y mostrar cuotas >>");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        add(GuardaryMostrar, gbc);

        // Cuotas a pagar
        JLabel cuotasApagar = new JLabel("CUOTAS A PAGAR", SwingConstants.CENTER);
        gbc.gridy = 2;
        gbc.gridx = 1;
        add(cuotasApagar, gbc);

        // Cuadro para Mostrar Cuotas
        // FALTA CODE

        // Boton Pagar Cuotas
        JButton pagarPCuota = new JButton("Pagar primera cuota");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pagarPCuota, gbc);


        // Espaciador para empujar todo arriba
        gbc.gridy = 99;
        gbc.weighty = 1;
        add(Box.createVerticalGlue(), gbc);
    }
}
