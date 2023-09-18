package GUI;


import com.sun.tools.javac.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BoardBackground extends JPanel {

    private int screenWidth ;
    private int screenHeight ;
    private BufferedImage background;
    private JFrame window;

    public BoardBackground(JFrame window){
        this.window=window;
        this.setFullScreenHeightAndWidth();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setFocusable(true);
        try {
            background = ImageIO.read(new File("Board.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();

    }




    public void setFullScreenHeightAndWidth(){
        GraphicsDevice gd =  GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(window);

        screenHeight= window.getHeight();
        screenWidth= window.getWidth();
    }

    public void paintComponent(Graphics g ) {
        super.paintComponent(g);
        g.drawImage(background,0,0,screenWidth,screenHeight,null);
    }
}
