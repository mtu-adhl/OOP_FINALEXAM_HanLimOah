package finalexam.shapeapp2022;

import java.awt.*;

public interface Drawable {
    void setColour(Color colour);
    void setFilled(Boolean filled);
    Color getColor();
    boolean isFilled();
    void draw(Graphics g);
}
