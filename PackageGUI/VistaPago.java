package PackageGUI;

import Modelo.Arriendo;
import Modelo.Cliente;
import Modelo.CuotaArriendo;
import Modelo.Main;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class VistaPago extends JPanel {
    private JComboBox<String> seleccionarCliente;
    private JComboBox<String> seleccionarArriendo; // NUEVO
    private JTextArea areaCuotas; // NUEVO
    private JPanel panelCuotas;

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
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(seleccionarCliente, gbc);

        // Seleccionar arriendo
        JLabel seleccionarArriendoLabel = new JLabel("Seleccionar Arriendo");
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(seleccionarArriendoLabel, gbc);

        seleccionarArriendo = new JComboBox<>(); // NUEVO
        gbc.gridx = 1;
        gbc.weightx = 0.4;
        add(seleccionarArriendo, gbc);

        // Botón Mostrar Cuotas
        JButton mostrarPagosArriendo = new JButton("Mostrar Pagos Arriendo Seleccionado 💃");
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        add(mostrarPagosArriendo, gbc);

        // Panel para mostrar cuotas como checkboxes
        panelCuotas = new JPanel();
        panelCuotas.setLayout(new BoxLayout(panelCuotas, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(panelCuotas);
        scroll.setPreferredSize(new Dimension(400, 200));
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        add(scroll, gbc);


        // Cuadro para pagar cuotas
        JButton PagarCuotasArriendos = new JButton("Pagar Cuotas de arriendo");
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        add(PagarCuotasArriendos, gbc);
        PagarCuotasArriendos.addActionListener(e -> pagarCuotas());

        // Evento para botón
        mostrarPagosArriendo.addActionListener(e -> MostrarCuotas());

        // Evento para actualizar arriendos al cambiar cliente
        seleccionarCliente.addActionListener(e -> actualizarArriendos());
    }

    //Sincorinizacion de clases
    private static class CheckboxCuota {
        JCheckBox checkBox;
        CuotaArriendo cuota;

        CheckboxCuota(JCheckBox checkBox, CuotaArriendo cuota) {
            this.checkBox = checkBox;
            this.cuota = cuota;
        }
    }




    // Pagar cuotas de arriendos
    private ArrayList<CheckboxCuota> checkboxCuotas = new ArrayList<>();
    private ArrayList<CheckboxCuota> checkBoxesCuotas = new ArrayList<>();
    private void pagarCuotas() {

        String clienteNombre = (String) seleccionarCliente.getSelectedItem();
        int arriendoIndex = seleccionarArriendo.getSelectedIndex();

        if (clienteNombre == null || arriendoIndex < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente y un arriendo válido.");
            return;
        }

        Cliente cliente = buscarClientePorNombre(clienteNombre);
        if (cliente == null) return;

        Arriendo arriendo = cliente.getArriendos().get(arriendoIndex);
        ArrayList<CuotaArriendo> cuotas = arriendo.getCuotas();

        boolean pagadoAlMenosUno = false;

        for (CheckboxCuota item : checkboxCuotas) {
            if (item.checkBox.isSelected() && !item.cuota.isPagada()) {
                item.cuota.setPagada(true);
                pagadoAlMenosUno = true;
            }
        }


        if (pagadoAlMenosUno) {
            JOptionPane.showMessageDialog(this, "Cuotas seleccionadas pagadas exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionaron nuevas cuotas para pagar.");
        }

        MostrarCuotas(); // Refrescar panel con estado actualizado

    }



    // Cargar clientes al ComboBox
    public void actualizarClientes() {
        seleccionarCliente.removeAllItems();
        seleccionarCliente.addItem("Seleccionar Cliente");
        for (Cliente c : Main.getClientes()) {
            seleccionarCliente.addItem(c.getNombre());
        }
    }

    // NUEVO: Cargar arriendos del cliente seleccionado
    private void actualizarArriendos() {
        seleccionarArriendo.removeAllItems();
        String nombreSeleccionado = (String) seleccionarCliente.getSelectedItem();
        if (nombreSeleccionado == null || nombreSeleccionado.equals("Seleccionar Cliente")) return;

        Cliente cliente = buscarClientePorNombre(nombreSeleccionado);
        if (cliente != null) {
            for (Arriendo arriendo : cliente.getArriendos()) {
                seleccionarArriendo.addItem("Vehículo: " + arriendo.getVehiculo().getPatente());
            }
        }
    }

    // NUEVO: Mostrar cuotas del arriendo seleccionado
    private void MostrarCuotas() {
        int arriendoIndex = seleccionarArriendo.getSelectedIndex();
        panelCuotas.removeAll();

        String clienteNombre = (String) seleccionarCliente.getSelectedItem();
        if (clienteNombre == null || arriendoIndex < 0) {
            panelCuotas.add(new JLabel("Seleccione Cliente y un arriendo válido."));
            panelCuotas.revalidate();
            panelCuotas.repaint();
            return;
        }

        Cliente cliente = buscarClientePorNombre(clienteNombre);
        if (cliente == null) return; // ✅ Solo se detiene si no encuentra el cliente

        Arriendo arriendo = cliente.getArriendos().get(arriendoIndex);
        ArrayList<CuotaArriendo> cuotas = arriendo.getCuotas();

        checkboxCuotas.clear(); // En lugar de checkBoxesCuotas.clear()

        for (CuotaArriendo cuota : cuotas) {
            boolean pagada = cuota.isPagada();
            JCheckBox check = new JCheckBox("Monto: $" + cuota.getValorCuota() +
                    " | Pagada: " + (pagada ? "Sí" : "No"));
            check.setSelected(pagada);
            check.setEnabled(!pagada); // Solo seleccionables si no están pagadas

            checkboxCuotas.add(new CheckboxCuota(check, cuota)); // Enlaza cuota
            panelCuotas.add(check);
        }

        panelCuotas.revalidate();
        panelCuotas.repaint();
    }


    // Buscar cliente por nombre (recomendable usar RUT en vez de nombre si hay ambigüedad)
    private Cliente buscarClientePorNombre(String nombre) {
        for (Cliente c : Main.getClientes()) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }
}
