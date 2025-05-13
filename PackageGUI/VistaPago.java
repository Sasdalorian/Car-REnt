package PackageGUI;

import Modelo.Cliente;
import Modelo.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaPago extends JPanel {
    private JComboBox<String> seleccionarCliente;

    public VistaPago() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel pagarCuotasT = new JLabel("PAGAR CUOTAS", SwingConstants.CENTER);
        pagarCuotasT.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(pagarCuotasT, gbc);

        // Seleccionar Cliente
        seleccionarCliente = new JComboBox<>();
        actualizarClientes();

        // EJEMPLO
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(seleccionarCliente, gbc);

        // Seleccionar arriendo
        JLabel seleccionarArriendo = new JLabel("Seleccionar Arriendo");
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(seleccionarArriendo, gbc);

        // Cuadro para seleccionar Arriendos
        // FALTA CODE

        // Boton Mostrar Arriendos Seleccionados
        JButton mostrarPagosArriendo = new JButton("Mostrar Pagos Arriendo Seleccionad \uD83E\uDC83");
        gbc.gridx = 1;
        gbc.weightx = 0.4; // Un poco más ancho si quieres
        add(mostrarPagosArriendo, gbc);
        // Accion Boton
        mostrarPagosArriendo.addActionListener(e -> {
            System.out.println("Mostrar Arriendo");
        });

        // Cuadro para mostrar autos arrendados por el Cliente
        // Falta CODE

        // Cuadro para mostrar cuotas
        // FALTA CODE

        // Espaciador para empujar todo arriba
        gbc.gridy = 99;
        gbc.weighty = 1;
        add(Box.createVerticalGlue(), gbc);
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
}
