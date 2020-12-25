package com.game.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable{

    private Thread thread;
    boolean running = false;

    private int FPS =60;
    private long targetTime = 1000/FPS;
    int MAX_FRAME_SKIPS = 5;

    public GamePanel()  {

        start();
    }

    public void start() {
        running = true;

        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        long start, diff, sleep, skippedFrames;

        while(running) {
            start = System.currentTimeMillis();
            skippedFrames = 0;
            
            repaint();

            diff = System.currentTimeMillis() - start;
            sleep = targetTime - diff;
            System.out.println(sleep);

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

        Random rand = new Random();
        int r = rand.nextInt(2);
        if (r == 1)
            setBackground(Color.CYAN);
        else
            setBackground(Color.red);
    }
}
