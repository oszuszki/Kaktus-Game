package com.game.panels;

import com.game.appearance.Map;
import com.game.entities.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;



public class GamePanel extends JPanel implements Runnable, KeyListener {

    private boolean settingUpMap = true;

    private Thread thread;
    boolean running = false;

    private int FPS =60;
    private long targetTime = 1000/FPS;
    int MAX_FRAME_SKIPS = 5;

    public static BufferedImage[] images;

    public GamePanel()  {
        addKeyListener(this);
        setFocusable(true);

        //temporary
        images = new BufferedImage[17];

        try {
            images[0] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/redx.png"));
            images[1] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/runr1.png"));
            images[2] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/runr2.png"));
            images[3] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/runr3.png"));
            images[4] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/runr4.png"));
            images[5] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/runl1.png"));
            images[6] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/runl2.png"));
            images[7] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/runl3.png"));
            images[8] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/runl4.png"));
            images[9] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/mel.png"));
            images[10] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/calib.png"));
            images[11] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/mer.png"));
            images[12] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/arrow_l.png"));
            images[13] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/arrow_r.png"));
            images[14] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/spike_up.png"));
            images[15] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/upr.png"));
            images[16] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/upl.png"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        start();
    }

    public void start() {
        running = true;

        thread = new Thread(this);
        thread.start();

    }

    public void update() {
        repaint();

        Player.move();



    }

    @Override
    public void run() {
        long start, diff, sleep, skippedFrames;

        while(running) {
            start = System.currentTimeMillis();
            skippedFrames = 0;

            update();

            diff = System.currentTimeMillis() - start;
            sleep = targetTime - diff;

            if (sleep > 0) {
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (sleep < 0 && skippedFrames < MAX_FRAME_SKIPS) {
                sleep += targetTime;
                skippedFrames++;
            }
        }

    }

    public void paint(Graphics g) {
        super.paintComponent(g);


        Map.draw(g);
        Player.draw(g);
        setBackground(Color.black);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Player.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Player.keyReleased(e.getKeyCode());
    }
}
