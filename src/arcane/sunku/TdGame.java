package arcane.sunku;

import arcane.sunku.engine.Game;
import arcane.sunku.engine.Handler;
import arcane.sunku.engine.Window;
import arcane.sunku.engine.states.StateManager;
import arcane.sunku.states.GameState;
import arcane.sunku.states.MenuState;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class TdGame implements Game {

    public static final String TITLE = "2D Engine";
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    private Handler handler;
    private StateManager stateManager;
    private Thread thread;
    private Window window;

    public static boolean running;

    public TdGame() {
        window = new Window(TITLE, WIDTH, HEIGHT);
        stateManager = new StateManager();
        running = false;
    }

    public synchronized void start() {
        if(running) return;

        thread = new Thread(this, "Game_Thread");
        running = true;
        thread.start();
    }

    private synchronized void stop() {
        if(running) running = false;

        try {
            window.dispose();
            thread.join(1);
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void init() {
        Assets.load();
        window.createWindow();
        handler = new Handler(stateManager, window);

        stateManager.addState(new MenuState()); // 0
        stateManager.addState(new GameState());   // 1

        Handler.switchState(0);
    }

    @Override
    public void run() {
        init();

        long lastTime = System.nanoTime();
        double tickLimit = 60.0;
        double ns = 1000000000.0 / tickLimit;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1) {
                update();
                delta--;
            }

            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                window.setTitle(TITLE + " | fps: " + frames);
                frames = 0;
            }
        }

        stop();
    }

    @Override
    public void update() {
        handler.update();

        stateManager.update();
    }

    public void render() {
        BufferStrategy bufferStrategy = window.getBufferStrategy();

        if(bufferStrategy == null) {
            window.createBufferStrategy(2);
            return;
        }

        try {
            Graphics g = bufferStrategy.getDrawGraphics();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, window.getWidth(), window.getHeight());

            stateManager.render((Graphics2D) g);

            g.dispose();
        } finally {
            bufferStrategy.show();
        }
    }
}
