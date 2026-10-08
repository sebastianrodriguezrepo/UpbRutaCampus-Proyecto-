import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaResultado extends JFrame {

    public VentanaResultado(String resultadoRuta) {
        setTitle("Resultado Inteligente de Ruta - Guía UPB");
        setSize(430, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        // Fondo general limpio
        getContentPane().setBackground(new Color(240, 243, 246));

        // Cabecera superior institucional
        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(null);
        panelHeader.setBounds(0, 0, 430, 60);
        panelHeader.setBackground(new Color(0, 51, 102));
        add(panelHeader);

        JLabel lblHeaderTitle = new JLabel("Camino a Seguir y Pasos", SwingConstants.CENTER);
        lblHeaderTitle.setBounds(20, 15, 390, 30);
        lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblHeaderTitle.setForeground(Color.WHITE);
        panelHeader.add(lblHeaderTitle);

        // Área de texto con el camino exacto y los pasos calculados
        JTextArea areaDetalles = new JTextArea(resultadoRuta);
        areaDetalles.setEditable(false);
        areaDetalles.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        areaDetalles.setMargin(new Insets(10, 10, 10, 10));
        
        JScrollPane scroll = new JScrollPane(areaDetalles);
        scroll.setBounds(20, 80, 375, 330);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(218, 225, 233), 1));
        add(scroll);

        // Botón para calcular otra ruta (regresa a la ventana de selección)
        JButton btnOtraRuta = new JButton("Calcular Otra Ruta");
        btnOtraRuta.setBounds(20, 430, 375, 45);
        btnOtraRuta.setBackground(new Color(0, 51, 102));
        btnOtraRuta.setForeground(Color.WHITE);
        btnOtraRuta.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnOtraRuta.setFocusPainted(false);
        btnOtraRuta.setOpaque(true);
        btnOtraRuta.setContentAreaFilled(true);
        btnOtraRuta.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        btnOtraRuta.setBorder(BorderFactory.createEmptyBorder());
        add(btnOtraRuta);

        // Acción del botón
        btnOtraRuta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaCampus().setVisible(true);
                dispose();
            }
        });
    }
}