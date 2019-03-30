package arcane.sunku.engine.utilities;

import arcane.sunku.engine.Window;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener {

    public static final int LEFT_CLICK = MouseEvent.BUTTON1, MIDDLE_CLICK = MouseEvent.BUTTON2, RIGHT_CLICK = MouseEvent.BUTTON3;

    private static boolean[] keys, cantPress, justPressed;
    private static boolean[] buttons, cpButton, buttonJP;

    private static float mouseX, mouseY;

    public Input(Window win) {
        keys = new boolean[256];
        buttons = new boolean[10];

        cantPress = new boolean[keys.length];
        justPressed = new boolean[keys.length];
        cpButton = new boolean[keys.length];
        buttonJP = new boolean[keys.length];

        win.addKeyListener(this);
        win.addMouseListener(this);
        win.addMouseMotionListener(this);
    }

    public void update() {
        for(int i = 0; i < keys.length; i++) {
            if(cantPress[i] && !keys[i]) {
                cantPress[i] = false;
            } else if(justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;
            }

            if(!cantPress[i] && keys[i])
                justPressed[i] = true;

        }

        for(int j = 0; j < buttons.length; j++) {
            if(cpButton[j] && !buttons[j]) {
                cpButton[j] = false;
            } else if(buttonJP[j]) {
                cpButton[j] = true;
                buttonJP[j] = false;
            }

            if(!cpButton[j] && buttons[j])
                buttonJP[j] = true;

        }
    }

    // Getters
    public static float getMouseX() { return mouseX; }
    public static float getMouseY() { return mouseY; }

    public static boolean isKeyPressed(int key) { return keys[key]; }
    public static boolean isButtonPressed(int button) { return buttons[button]; }

    public static boolean keyJustPressed(int key) { return justPressed[key]; }
    public static boolean buttonJustPressed(int button) { return buttonJP[button]; }

    // Overrides!
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;

        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;

        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() < 0 || e.getButton() >= buttons.length)
            return;

        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() < 0 || e.getButton() >= buttons.length)
            return;

        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}
