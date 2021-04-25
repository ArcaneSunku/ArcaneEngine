package arcane.sunku.engine.render;

import arcane.sunku.engine.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends Canvas {

    private static Window mInstance;

    private final JFrame frame;

    private String title;
    private int width, height;

    private Window() {
        frame = new JFrame();
    }

    public static Window get() {
        if(mInstance == null)
            mInstance = new Window();

        return mInstance;
    }

    public void createWindow(String title, int width, int height) {
        get().title = title;
        get().width = width;
        get().height = height;

        Dimension dimension = new Dimension(get().width, get().height);

        get().setMinimumSize(dimension);
        get().setMaximumSize(dimension);
        get().setPreferredSize(dimension);

        get().frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                if(Game.running)
                    Game.running = false;
            }

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);

                if(Game.running)
                    Game.running = false;
            }
        });

        frame.setTitle(get().title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIgnoreRepaint(true);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setIgnoreRepaint(true);
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
    public int width() { return width; }
    public int height() { return height; }

    public void setTitle(String title) {
        frame.setTitle(title);
    }

}
