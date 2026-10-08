import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame {

    public VentanaInicio() {
        setTitle("Guía UPB - Navegación");
        setSize(420, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        // Fondo general gris muy claro
        getContentPane().setBackground(new Color(240, 243, 246));

        // Cabecera superior institucional azul
        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(null);
        panelHeader.setBounds(0, 0, 420, 180);
        panelHeader.setBackground(new Color(0, 51, 102));
        add(panelHeader);

        // Logo de la UPB (Asegúrate de tener 'logo_upb.png' en la carpeta)
        JLabel lblLogo = new JLabel();
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setBounds(110, 15, 200, 65);
        ImageIcon iconoOriginal = new ImageIcon("logo_upb.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(160, 55, Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(imagenEscalada));
        panelHeader.add(lblLogo);

        JLabel lblGuia = new JLabel("Guía UPB", SwingConstants.CENTER);
        lblGuia.setBounds(60, 90, 300, 30);
        lblGuia.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblGuia.setForeground(Color.WHITE);
        panelHeader.add(lblGuia);

        // Tarjeta central de bienvenida
        JPanel panelCard = new JPanel();
        panelCard.setLayout(null);
        panelCard.setBounds(30, 200, 360, 110);
        panelCard.setBackground(Color.WHITE);
        panelCard.setBorder(BorderFactory.createLineBorder(new Color(218, 225, 233), 1, true));
        add(panelCard);

        JLabel lblSub = new JLabel("Estado del Sistema");
        lblSub.setBounds(20, 15, 200, 20);
        lblSub.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblSub.setForeground(new Color(110, 120, 130));
        panelCard.add(lblSub);

        JLabel lblInfo = new JLabel("<html><b>Sistema listo para calcular rutas óptimas</b><br>Campus Seccional Bucaramanga</html>");
        lblInfo.setBounds(20, 40, 320, 45);
        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblInfo.setForeground(new Color(70, 80, 90));
        panelCard.add(lblInfo);

        // Botón "Nueva Búsqueda" (Garantizado sin interferencias)
        JButton btnEmpezar = new JButton("Nueva Búsqueda");
        btnEmpezar.setBounds(30, 335, 360, 45);
        btnEmpezar.setBackground(new Color(0, 82, 155));
        btnEmpezar.setForeground(Color.WHITE);
        btnEmpezar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnEmpezar.setFocusPainted(false);
        btnEmpezar.setOpaque(true);
        btnEmpezar.setContentAreaFilled(true);
        btnEmpezar.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        btnEmpezar.setBorder(BorderFactory.createEmptyBorder());
        add(btnEmpezar);

        // Acción del botón: Abre VentanaCampus y destruye esta ventana
        btnEmpezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaCampus().setVisible(true);
                dispose();
            }
        });
    }
}