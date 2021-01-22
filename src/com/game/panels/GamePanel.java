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
        images = new BufferedImage[23];

        try {
            images[0] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/redx.png"));
            images[1] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/r1.png"));
            images[2] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/r2.png"));
            images[3] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/r3.png"));
            images[4] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/r4.png"));
            images[5] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/r5.png"));
            images[6] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/r6.png"));
            images[7] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/r7.png"));
            images[8] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/r8.png"));
            images[9] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/kaktus_l.png"));
            images[10] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/l1.png"));
            images[11] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/l2.png"));
            images[12] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/l3.png"));
            images[13] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/l4.png"));
            images[14] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/l5.png"));
            images[15] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/l6.png"));
            images[16] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/l7.png"));
            images[17] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/l8.png"));
            images[18] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/calib.png"));
            images[19] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/kaktus_r.png"));
            images[20] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/arrow_l.png"));
            images[21] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/arrow_r.png"));
            images[22] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/spike_up.png"));
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
