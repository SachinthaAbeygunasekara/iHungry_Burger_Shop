package util;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class RoundedJComboBox {

    public static void makeComboBoxRounded(JComboBox<?> comboBox, int radius, Color bgColor, Color borderColor) {
        comboBox.setOpaque(false);
        comboBox.setFocusable(false);
        comboBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 25));

        // Renderer for left-aligned text
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                lbl.setOpaque(false);
                lbl.setHorizontalAlignment(SwingConstants.LEFT);
                lbl.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));

                if (isSelected) {
                    lbl.setBackground(Color.WHITE); // dropdown selection bg
                    lbl.setOpaque(true);
                }

                return lbl;
            }
        });

        // Custom UI
        comboBox.setUI(new BasicComboBoxUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int w = c.getWidth();
                int h = c.getHeight();

                // Background
                g2.setColor(bgColor);
                g2.fillRoundRect(0, 0, w, h, radius, radius);

                // Border
                g2.setColor(borderColor);
                g2.drawRoundRect(0, 0, w - 1, h - 1, radius, radius);

                g2.dispose();

                super.paint(g, c);
            }

            @Override
            protected JButton createArrowButton() {
                JButton arrow = new JButton("▼");
                arrow.setBorder(BorderFactory.createEmptyBorder());
                arrow.setContentAreaFilled(false);
                arrow.setFocusPainted(false);
                arrow.setOpaque(false);
                arrow.setForeground(Color.BLACK);
                arrow.setFont(new Font("Arial", Font.BOLD, 10));
                return arrow;
            }
        });
    }
}
