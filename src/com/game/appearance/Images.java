package com.game.appearance;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images {
    public static BufferedImage[] blocks;

    public Images() {
        blocks = new BufferedImage[1];

        try {
            blocks[0] = ImageIO.read(this.getClass().getResourceAsStream("/res/images/redx.png"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }
}
