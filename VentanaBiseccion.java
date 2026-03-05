import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaBiseccion extends JFrame {

    private JTextField txtA, txtB, txtC, txtLimA, txtLimB, txtError;
    private JTextArea areaResultado;

    public VentanaBiseccion() {

        setTitle("Método de Bisección");
        setSize(330, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panelDatos = new JPanel(new GridLayout(6,2,5,5));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(15,15,10,15));

        panelDatos.add(new JLabel("Coeficiente ax²:"));
        txtA = new JTextField(6);
        panelDatos.add(txtA);

        panelDatos.add(new JLabel("Coeficiente bx:"));
        txtB = new JTextField(6);
        panelDatos.add(txtB);

        panelDatos.add(new JLabel("Coeficiente c:"));
        txtC = new JTextField(6);
        panelDatos.add(txtC);

        panelDatos.add(new JLabel("Límite inferior (a):"));
        txtLimA = new JTextField(6);
        panelDatos.add(txtLimA);

        panelDatos.add(new JLabel("Límite superior (b):"));
        txtLimB = new JTextField(6);
        panelDatos.add(txtLimB);

        panelDatos.add(new JLabel("Error permitido:"));
        txtError = new JTextField(6);
        panelDatos.add(txtError);

        add(panelDatos, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCalcular.setMaximumSize(new Dimension(120,30));

        panelCentro.add(btnCalcular);
        panelCentro.add(Box.createRigidArea(new Dimension(0,10)));

        areaResultado = new JTextArea(5, 20);
        areaResultado.setEditable(false);
        areaResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        areaResultado.setMaximumSize(new Dimension(280,100));

        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setMaximumSize(new Dimension(300,120));

        panelCentro.add(scroll);

        add(panelCentro, BorderLayout.CENTER);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    double a = Double.parseDouble(txtA.getText());
                    double b = Double.parseDouble(txtB.getText());
                    double c = Double.parseDouble(txtC.getText());
                    double limA = Double.parseDouble(txtLimA.getText());
                    double limB = Double.parseDouble(txtLimB.getText());
                    double error = Double.parseDouble(txtError.getText());

                    String resultado = Funcion.metodoBiseccion(a,b,c,limA,limB,error);
                    areaResultado.setText(resultado);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Ingresa solo números válidos",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}