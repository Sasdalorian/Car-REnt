package PackageGUI;

import javax.swing.*;
import java.awt.*;

public class VistaPago extends JPanel {
    public VistaPago() {
        setBackground(Color.YELLOW);
        JLabel pagarCuotasT = new JLabel("PAGAR CUOTAS");
        pagarCuotasT.setFont(new Font("Arial", Font.BOLD, 16));
        add(pagarCuotasT);
    }
}
