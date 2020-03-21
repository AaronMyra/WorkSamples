package ca.nscc.Shapes;

import ca.nscc.GUI.DrawingPane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Mario extends Shape{

    public Mario(int height, int width, int xPos, int yPos){
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPos);
        this.setyPosition(yPos);
    }

    @Override
    public void drawShape(Graphics g, DrawingPane drawingPane) {
        try {
            BufferedImage img1 = ImageIO.read(getClass().getResourceAsStream("Mario_Jump.gif"));
            g.drawImage(img1, this.getxPosition(), this.getyPosition(), drawingPane);
        }
        catch (Exception e){
            System.out.println("File not Found");
        }
    }

    @Override
    public void moveShape() {
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }

}
