package DrawShapes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPickerFrame extends JFrame {
    private JPanel colorPanel;

    public ColorPickerFrame() {
        setTitle("Color Picker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        colorPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE);

        JButton colorButton = new JButton("Choose Color");
        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = JColorChooser.showDialog(ColorPickerFrame.this,
                        "Choose a color", colorPanel.getBackground());
                if (selectedColor != null) {
                    colorPanel.setBackground(selectedColor);
                }
            }
        });

        add(colorButton, BorderLayout.NORTH);
        add(colorPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        ColorPickerFrame frame = new ColorPickerFrame();
        frame.setVisible(true);
    }
}
