package PackageGUI;

import Modelo.Cliente;
import Modelo.Main;

import javax.swing.*;
import java.awt.*;

public class VistaClientes extends JPanel {
    private JTextField txtCedula, txtNombre;
    private JCheckBox vigente;

    public VistaClientes(CardLayout cardLayout, JPanel panelContenido) {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel vistaClientesT = new JLabel("CLIENTES");
        vistaClientesT.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 0;
        add(vistaClientesT, gbc);

        // Cedula
        JLabel cedulaC = new JLabel("Cedula:");
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(cedulaC, gbc);

        // Campo Cedula
        txtCedula = new JTextField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtCedula, gbc);

        // Nombre
        JLabel nombreC = new JLabel("Nombre:");
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(nombreC, gbc);

        // Campo Nombre
        txtNombre = new JTextField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtNombre, gbc);

        // ¿Vigente?
        JLabel vigenteLabel = new JLabel("¿Vigente?");
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(vigenteLabel, gbc);

        // CheckBox Vigente
        vigente = new JCheckBox("Sí");
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(vigente, gbc);

        // Botón Agregar
        JButton agregarCliente = new JButton("Agregar");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 0;
        add(agregarCliente, gbc);

        // Accion Boton
        agregarCliente.addActionListener(e -> {
            if (!txtNombre.getText().trim().isEmpty() && !txtCedula.getText().trim().isEmpty()) {

                Cliente nuevo = new Cliente(txtCedula.getText(), txtNombre.getText(), vigente.isSelected());
                System.out.println("\nCliente agregado:");
                System.out.println(nuevo);

                //Agregar a la lista Clientes
                Main.getClientes().add(nuevo);
                //Actualizar JComboBox VistaArriendos
                ((VistaArriendos) panelContenido.getComponent(1)).actualizarClientes();
                ((VistaPago) panelContenido.getComponent(2)).actualizarClientes();

                //Actualizar TextField
                txtNombre.setText("");
                txtCedula.setText("");
                vigente.setSelected(false);

                //Cambio de Panel
                cardLayout.show(panelContenido, "PANEL2");
                System.out.println("Cambio a Vista Arriendos");
            } else {
                System.out.println("Falta llenar los campos");
            }
        });

        // Espaciador para empujar todo arriba
        gbc.gridy = 99;
        gbc.weighty = 1;
        add(Box.createVerticalGlue(), gbc);
    }
}
