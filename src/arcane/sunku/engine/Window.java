package arcane.sunku.engine;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    private JFrame frame;
    private String title;

    public Window(String title, int width, int height) {
        this.title = title;

        Dimension dim = new Dimension(width, height);

        setMinimumSize(dim);
        setMaximumSize(dim);
        setPreferredSize(dim);
    }

    public void createWindow() {
        frame = new JFrame(title);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setFocusable(true);
        requestFocus();
    }

    public void dispose() {
        frame.dispose();
        title = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        frame.setTitle(title);
    }

}
