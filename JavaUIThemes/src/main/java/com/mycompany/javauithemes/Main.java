package com.mycompany.javauithemes;

import com.formdev.flatlaf.FlatLightLaf;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Ejecuta el método createAndShowGUI en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Crea el marco principal de la aplicación
        JFrame frame = new JFrame("Java UI Themes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Crea el panel para los botones
        JPanel buttonPanel = new JPanel();
        JButton jtattooButton = new JButton("JTattoo");
        JButton flatlafButton = new JButton("FlatLaf");
        JButton substanceButton = new JButton("Substance");

        // Añade los botones al panel de botones
        buttonPanel.add(jtattooButton);
        buttonPanel.add(flatlafButton);
        buttonPanel.add(substanceButton);
        
        // Añade el panel de botones al marco, en la parte superior
        frame.add(buttonPanel, BorderLayout.NORTH);

        // Crea el panel de visualización
        JPanel displayPanel = new JPanel();
        frame.add(displayPanel, BorderLayout.CENTER);

        // Añade un ActionListener para el botón de JTattoo
        jtattooButton.addActionListener(e -> {
            try {
                // Establece el LookAndFeel de JTattoo
                UIManager.setLookAndFeel(new HiFiLookAndFeel());
                // Actualiza la interfaz gráfica para aplicar el nuevo LookAndFeel
                SwingUtilities.updateComponentTreeUI(frame);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // Muestra los componentes gráficos en el panel de visualización
            showComponents(displayPanel);
        });

        // Añade un ActionListener para el botón de FlatLaf
        flatlafButton.addActionListener(e -> {
            try {
                // Establece el LookAndFeel de FlatLaf
                UIManager.setLookAndFeel(new FlatLightLaf());
                // Actualiza la interfaz gráfica para aplicar el nuevo LookAndFeel
                SwingUtilities.updateComponentTreeUI(frame);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // Muestra los componentes gráficos en el panel de visualización
            showComponents(displayPanel);
        });

        // Añade un ActionListener para el botón de Substance
        substanceButton.addActionListener(e -> {
            try {
                // Establece el LookAndFeel de Substance
                UIManager.setLookAndFeel(new SubstanceBusinessLookAndFeel());
                // Actualiza la interfaz gráfica para aplicar el nuevo LookAndFeel
                SwingUtilities.updateComponentTreeUI(frame);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // Muestra los componentes gráficos en el panel de visualización
            showComponents(displayPanel);
        });

        // Hace visible el marco
        frame.setVisible(true);
    }

    private static void showComponents(JPanel panel) {
        // Elimina todos los componentes actuales del panel
        panel.removeAll();
        // Establece un nuevo layout de rejilla (GridLayout) con 2 filas y 3 columnas, y espacios de 5 píxeles
        panel.setLayout(new GridLayout(2, 3, 5, 5));

        // Añade diferentes componentes gráficos al panel
        panel.add(new JButton("Elemento gráfico A"));
        panel.add(new JLabel("Elemento gráfico B"));
        panel.add(new JTextField("Elemento gráfico C"));
        panel.add(new JCheckBox("Elemento gráfico D"));
        panel.add(new JRadioButton("Elemento gráfico E"));

        // Actualiza y repinta el panel para reflejar los nuevos componentes añadidos
        panel.revalidate();
        panel.repaint();
    }
}
