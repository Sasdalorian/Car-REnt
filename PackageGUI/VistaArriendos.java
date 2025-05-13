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
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.weightx = 1;
        add(vistaArriendosT, gbc);

        // Seleccionar Cliente
        seleccionarCliente = new JComboBox<>();
        actualizarClientes();
        gbc.gridy = 1; gbc.gridx = 0; gbc.gridwidth = 1; gbc.anchor = GridBagConstraints.EAST;
        add(seleccionarCliente, gbc);

        // Seleccionar Vehículo
        seleccionarVehiculo = new JComboBox<>();
        actualizarVehiculo();
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        add(seleccionarVehiculo, gbc);

        // Botón Agregar Cliente
        JButton irACliente = new JButton("Ingresar nuevo Cliente");
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 1;
        add(irACliente, gbc);
        irACliente.addActionListener(e ->
                cardLayout.show(panelContenido, "PANEL1")
        );

        // Fecha Arriendo
        JPanel panelFecha = new JPanel(new BorderLayout(5, 0));
        panelFecha.add(new JLabel("Fecha Arriendo:"), BorderLayout.CENTER);
        txtFechaArriendo = new JTextField(10);
        panelFecha.add(txtFechaArriendo, BorderLayout.EAST);
        gbc.gridx = 0; gbc.gridy = 3;
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

        // Actualizar precio al seleccionar vehículo
        seleccionarVehiculo.addActionListener(e -> {
            int index = seleccionarVehiculo.getSelectedIndex() - 1;
            if (index >= 0 && index < vehiculos.size()) {
                Vehiculo v = vehiculos.get(index);
                precioDia.setText("$" + v.getPrecioPorDia());
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

        // Monto a pagar
        JPanel panelMontoPagar = new JPanel(new BorderLayout(5, 0));
        montoPagar = new JLabel("");
        panelMontoPagar.add(new JLabel("Monto a Pagar:"), BorderLayout.WEST);
        panelMontoPagar.add(montoPagar, BorderLayout.EAST);
        gbc.gridy = 7;
        add(panelMontoPagar, gbc);

        // Botón Guardar arriendo
        JButton guardaryMostrar = new JButton("Guardar arriendo y mostrar cuotas >>");
        gbc.gridy = 8;
        add(guardaryMostrar, gbc);

        guardaryMostrar.addActionListener(e -> {
            try {
                int clienteIndex  = seleccionarCliente.getSelectedIndex() - 1;
                int vehiculoIndex = seleccionarVehiculo.getSelectedIndex() - 1;
                if (clienteIndex < 0 || vehiculoIndex < 0) {
                    JOptionPane.showMessageDialog(this,
                            "Debe seleccionar un cliente y un vehículo válidos.");
                    return;
                }

                Cliente cliente = Main.getClientes().get(clienteIndex);
                Vehiculo vehiculo = vehiculos.get(vehiculoIndex);

                int dias      = Integer.parseInt(txtDias.getText().trim());
                int cantCtas  = Integer.parseInt(txtCantCuotas.getText().trim());
                if (dias <= 0 || cantCtas <= 0) {
                    JOptionPane.showMessageDialog(this,
                            "Los días y las cuotas deben ser mayores que 0.");
                    return;
                }

                // Crear arriendo con numArriendo dinámico
                int nroArriendo = cliente.getArriendos().size() + 1;
                Arriendo arriendo = new Arriendo(
                        nroArriendo,
                        dias,
                        cliente,
                        vehiculo,
                        new java.util.Date()
                );

                int total      = vehiculo.getPrecioPorDia() * dias;
                int valorCua   = total / cantCtas;
                for (int i = 1; i <= cantCtas; i++) {
                    arriendo.agregarCuota(new CuotaArriendo(i, valorCua, false));
                }

                cliente.agregarArriendo(arriendo);
                montoPagar.setText("$" + total);
                JOptionPane.showMessageDialog(this,
                        "Arriendo registrado con " + cantCtas +
                                " cuotas.\nTotal a pagar: $" + total);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese valores numéricos válidos en días y cuotas.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Ocurrió un error al registrar el arriendo.");
                ex.printStackTrace();
            }
        });

        // Etiqueta y botón para cambiar a "Pagar Cuotas"
        JLabel cuotasApagar = new JLabel("CUOTAS A PAGAR", SwingConstants.CENTER);
        gbc.gridy = 2; gbc.gridx = 1;
        add(cuotasApagar, gbc);

        JButton pagarPCuota = new JButton("Pagar primera cuota");
        gbc.gridx = 1; gbc.gridy = 4;
        add(pagarPCuota, gbc);
        pagarPCuota.addActionListener(e -> {
            seleccionarCliente.setSelectedIndex(0);
            seleccionarVehiculo.setSelectedIndex(0);
            cardLayout.show(panelContenido, "PANEL3");
        });

        // Espaciador inferior
        gbc.gridy = 99; gbc.weighty = 1;
        add(Box.createVerticalGlue(), gbc);
    }

    public void actualizarClientes() {
        seleccionarCliente.removeAllItems();
        seleccionarCliente.addItem("Seleccionar Cliente");
        for (Cliente c : Main.getClientes()) {
            seleccionarCliente.addItem(c.getNombre());
        }
    }

    public void actualizarVehiculo() {
        seleccionarVehiculo.removeAllItems();
        seleccionarVehiculo.addItem("Seleccionar Vehículo");
        vehiculos = Main.getVehiculos();
        for (Vehiculo v : vehiculos) {
            seleccionarVehiculo.addItem(v.getTipo());
        }
    }
}
