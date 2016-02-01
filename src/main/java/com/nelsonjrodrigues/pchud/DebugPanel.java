package com.nelsonjrodrigues.pchud;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nelsonjrodrigues.pchud.world.Worlds;



public class DebugPanel extends JFrame {

    private static final long serialVersionUID = 1L;

    private ObjectMapper mapper = new ObjectMapper();
    private JLabel label = new JLabel();
    private Worlds worlds;

    public DebugPanel(Worlds worlds) {
        mapper.setVisibility(mapper.getSerializationConfig()
                                   .getDefaultVisibilityChecker()
                                   .withFieldVisibility(Visibility.ANY));

        this.worlds = worlds;
        worlds.addPropertyChangeListener(e -> {
            SwingUtilities.invokeLater(this::update);
        });

        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        JScrollPane scroller = new JScrollPane(label,
                                               JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                               JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.setLayout(new BorderLayout());
        this.add(scroller, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        update();
    }

    private void update() {
        String json;
        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.worlds);
        }
        catch (JsonProcessingException e) {
            json = e.getMessage();
            e.printStackTrace(System.out);
        }
        label.setText("<html><pre>" + json + "</pre></html>");
    }

}
