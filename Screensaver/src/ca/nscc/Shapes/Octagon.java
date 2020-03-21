package ca.nscc.Shapes;

import ca.nscc.GUI.DrawingPane;

import java.awt.*;

public class Octagon extends Shape {

    public Octagon(int height, int width, int xPos, int yPos, Color color){
        this.setHeight(height);
        this.setWidth(width);
        this.setxPosition(xPos);
        this.setyPosition(yPos);
        this.setColor(color);
    }

    @Override
    public void drawShape(Graphics g, DrawingPane drawingPane) {
        //set color
        g.setColor(this.getColor());
        // line (/) top left
        g.drawLine(this.getxPosition() + (this.getWidth() / 3), this.getyPosition(), this.getxPosition(), this.getyPosition() + (this.getHeight() / 3));
        //line (|) left side
        g.drawLine(this.getxPosition(), this.getyPosition() + (this.getHeight() / 3), this.getxPosition(), this.getyPosition() + ((this.getHeight() / 3)) * 2);
        //line (\) botom left
        g.drawLine(this.getxPosition(), this.getyPosition() + ((this.getHeight() / 3) * 2), this.getxPosition() + (this.getWidth() / 3), this.getyPosition() + this.getHeight());
        //line (-) bottom
        g.drawLine(this.getxPosition() + (this.getWidth() / 3), this.getyPosition() + this.getHeight(), this.getxPosition() + ((this.getWidth() /3) * 2), this.getyPosition() + this.getHeight());
        //line (/) bottom right
        g.drawLine(this.getxPosition() + ((this.getWidth() /3) * 2), this.getyPosition() + this.getHeight(), this.getxPosition() + this.getWidth(), this.getyPosition() + ((this.getHeight() / 3) * 2));
        //line (|) right side
        g.drawLine(this.getxPosition() + this.getWidth(), this.getyPosition() + ((this.getHeight() / 3) * 2), this.getxPosition() + this.getWidth(), this.getyPosition() + (this.getHeight() / 3));
        //line (\) top right
        g.drawLine(this.getxPosition() + this.getWidth(), this.getyPosition() + (this.getHeight() / 3), this.getxPosition() + ((this.getWidth() / 3) * 2 ), this.getyPosition());
        //line (-) top
        g.drawLine(this.getxPosition() + ((this.getWidth() / 3) * 2 ), this.getyPosition(), this.getxPosition() + (this.getWidth() / 3) , this.getyPosition());
    }

    @Override
    public void moveShape() {
        this.setxPosition(this.getxPosition() + this.getxSpeed());
        this.setyPosition(this.getyPosition() + this.getySpeed());
    }
}
