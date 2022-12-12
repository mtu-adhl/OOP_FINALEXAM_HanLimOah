package finalexam.shapeapp2022;

import java.awt.*;

public class Oval extends AbstractShape implements Drawable{
    private Color colour;
    private boolean filled;
    public Oval(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY, Color colour, boolean filled) {
        super(topLeftX, topLeftY, bottomRightX, bottomRightY);
        setColour(colour);
        setFilled(filled);
    }

    @Override
    public String toString() {
        return "Type: " + getType() + "\n" +
                super.toString() +
                "Colour: " + getColor() + "\n" +
                "Filled: " + ((isFilled())?"Yes":"No") + "\n";
    }

    @Override
    public void setColour(Color colour) {
        this.colour = colour;
    }

    @Override
    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    @Override
    public Color getColor() {
        return this.colour;
    }

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public String getType() {
        return "Oval";
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(colour);
        if(!filled)
            g.drawOval(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
        else
            g.fillOval(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
    }
}
