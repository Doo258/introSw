package org.upao.intro;

import javax.swing.*;
import java.awt.*;

public class MiPanel extends JPanel {
    
    int x = 50, y = 50, diametro = 100;
    
    MiPanel() {
        this.setPreferredSize(new Dimension(400, 400));
        this.setBackground(Color.orange);
        this.setOpaque(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(x, y, diametro, diametro);
    }
    
}
