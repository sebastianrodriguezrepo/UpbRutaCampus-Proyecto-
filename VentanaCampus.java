import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCampus extends JFrame {
    
    private JComboBox<String> comboOrigen;
    private JComboBox<String> comboDestino;
    private JComboBox<String> comboCerrado;
    private JCheckBox checkSinEscaleras;
    private JButton btnCalcular;
    private JButton btnRegresar;
    private JLabel lblMapa;

    public VentanaCampus() {
        setTitle("Selección de Ruta - Guía UPB");
        setSize(430, 620);
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

        JLabel lblHeaderTitle = new JLabel("Selección de Ruta y Preferencias", SwingConstants.CENTER);
        lblHeaderTitle.setBounds(20, 15, 390, 30);
        lblHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblHeaderTitle.setForeground(Color.WHITE);
        panelHeader.add(lblHeaderTitle);

        // Contenedor tipo tarjeta blanca para los selectores
        JPanel panelForm = new JPanel();
        panelForm.setLayout(null);
        panelForm.setBounds(20, 75, 375, 230);
        panelForm.setBackground(Color.WHITE);
        panelForm.setBorder(BorderFactory.createLineBorder(new Color(218, 225, 233), 1, true));
        add(panelForm);

        // Origen
        JLabel lblOrigen = new JLabel("Origen:");
        lblOrigen.setBounds(15, 12, 100, 20);
        lblOrigen.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelForm.add(lblOrigen);

        String[] edificios = {
            "Edificio A", "Edificio B", "Edificio C", "Edificio D", 
            "Edificio E", "Edificio F", "Edificio G", "Edificio H", 
            "Edificio I", "Edificio J", "Edificio K", "Edificio L", 
            "Cafeteria Verde", "Cafeteria casi L", "Porteria 1", "Porteria 2"
        };

        comboOrigen = new JComboBox<>(edificios);
        comboOrigen.setBounds(15, 32, 345, 28);
        panelForm.add(comboOrigen);

        // Destino
        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setBounds(15, 68, 100, 20);
        lblDestino.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelForm.add(lblDestino);

        comboDestino = new JComboBox<>(edificios);
        comboDestino.setBounds(15, 88, 345, 28);
        panelForm.add(comboDestino);

        // Edificio cerrado (Mantenimiento)
        JLabel lblCerrado = new JLabel("Edificio en Mantenimiento:");
        lblCerrado.setBounds(15, 124, 180, 20);
        lblCerrado.setFont(new Font("Segoe UI", Font.BOLD, 12));
        panelForm.add(lblCerrado);

        String[] edificiosConNinguno = new String[edificios.length + 1];
        edificiosConNinguno[0] = "Ninguno (Todo abierto)";
        System.arraycopy(edificios, 0, edificiosConNinguno, 1, edificios.length);

        comboCerrado = new JComboBox<>(edificiosConNinguno);
        comboCerrado.setBounds(15, 144, 345, 28);
        panelForm.add(comboCerrado);

        // Checkbox de escaleras
        checkSinEscaleras = new JCheckBox("Evitar escaleras (Ruta accesible)");
        checkSinEscaleras.setBounds(15, 185, 345, 25);
        checkSinEscaleras.setBackground(Color.WHITE);
        checkSinEscaleras.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panelForm.add(checkSinEscaleras);

        // Botón Calcular Ruta Sólido
        btnCalcular = new JButton("Calcular Ruta");
        btnCalcular.setBounds(20, 318, 375, 42);
        btnCalcular.setBackground(new Color(0, 51, 102));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCalcular.setFocusPainted(false);
        btnCalcular.setOpaque(true);
        btnCalcular.setContentAreaFilled(true);
        btnCalcular.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        btnCalcular.setBorder(BorderFactory.createEmptyBorder());
        add(btnCalcular);

        // AQUÍ ESTÁ LA IMAGEN DEL MAPA DEBAJO DEL BOTÓN DE CALCULAR
        lblMapa = new JLabel();
        lblMapa.setHorizontalAlignment(SwingConstants.CENTER);
        lblMapa.setBounds(20, 372, 375, 140);
        
        ImageIcon iconoOriginal = new ImageIcon("mapa_ruta.png.png");
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(375, 140, Image.SCALE_SMOOTH);
        lblMapa.setIcon(new ImageIcon(imagenEscalada));
        lblMapa.setBorder(BorderFactory.createLineBorder(new Color(218, 225, 233), 1, true));
        lblMapa.setBackground(Color.WHITE);
        lblMapa.setOpaque(true);
        add(lblMapa);

        // Botón para regresar al inicio
        btnRegresar = new JButton("Regresar al Inicio");
        btnRegresar.setBounds(20, 525, 375, 30);
        btnRegresar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnRegresar.setForeground(new Color(100, 110, 120));
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setBorderPainted(false);
        add(btnRegresar);

        // Acciones
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularRutaSeleccionada();
            }
        });

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaInicio().setVisible(true);
                dispose();
            }
        });
    }

    private void calcularRutaSeleccionada() {
        String origen = (String) comboOrigen.getSelectedItem();
        String destino = (String) comboDestino.getSelectedItem();
        String seleccionadoCerrado = (String) comboCerrado.getSelectedItem();
        boolean sinEscaleras = checkSinEscaleras.isSelected();

        String edificioCerrado = seleccionadoCerrado.equals("Ninguno (Todo abierto)") ? "" : seleccionadoCerrado;

        if (origen.equals(destino)) {
            JOptionPane.showMessageDialog(this, "El origen y el destino son el mismo edificio.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ejecutamos la lógica de la inteligencia (el grafo)
        Grafo grafo = new Grafo();
        String resultado = grafo.calcularRuta(origen, destino, sinEscaleras, edificioCerrado);

        // Abre la tercera vista (VentanaResultado) con el camino a seguir y los pasos
        new VentanaResultado(resultado).setVisible(true);
        dispose();
    }
}