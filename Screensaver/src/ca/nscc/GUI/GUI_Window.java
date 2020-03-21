package ca.nscc.GUI;

import javax.swing.*;
import java.awt.*;

public class GUI_Window extends JFrame{

    private int windowHeight = 450,
            windowWidth = 600,
            windowXPos = 100,
            windowYPos = 100;

    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        GUI_Window gui_window = new GUI_Window();
                        gui_window.setVisible(true);
                    }

                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    public GUI_Window(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(this.windowXPos, this.windowYPos, this.windowWidth, this.windowHeight);

        //JPANEL
        DrawingPane drawingPane = new DrawingPane();
        //USE RGB VALUES
        drawingPane.setBackground(new Color(62, 62, 62));
        drawingPane.setLayout(null);
        add(drawingPane);
    }
}
