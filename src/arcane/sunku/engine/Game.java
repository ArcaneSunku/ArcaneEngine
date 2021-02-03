package arcane.sunku.engine;

import arcane.sunku.engine.render.Window;
import arcane.sunku.engine.utilities.Handler;

public class Game implements Runnable {

    public static boolean running;
    private static Window window;

    private Thread thread;

    private final GameAdapter game;

    /**
     * creates a proper game class that takes in the interface of game
     * transforming it into a GameAdapter. However we should be passing
     * a game adapter regardless
     *
     * @param gameInterface should be a GameAdapter
     */
    public Game(IGame gameInterface) {
        game = (GameAdapter) gameInterface;
        window = new Window(game.getTitle(), game.getWidth(), game.getHeight());

        running = false;
    }

    public synchronized void start() {
        if(running) return;

        thread = new Thread(this, "Main_Thread");
        running = true;
        thread.start();
    }

    private synchronized void stop() {
        if(running) running = false;

        try {
            Handler.getPlayer().close();
            window.dispose();
            thread.join(1);
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void init() {
        window.createWindow();
        game.initialize();
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
                update(delta / tickLimit);
                delta--;
            }

            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                window.setTitle(game.getTitle() + " | fps: " + frames);
                frames = 0;
            }
        }

        stop();
    }

    private void update(double dt) {
        if(game != null)
            game.update(dt);
    }

    private void render() {
        if(game != null)
            game.render();
    }

    public static Window getWindow() {
        return window;
    }
}
