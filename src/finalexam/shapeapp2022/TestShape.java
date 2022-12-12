package finalexam.shapeapp2022;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestShape {
    public static void main(String[] args) {
        int  i;
        ArrayList<AbstractShape> abstractShapeArrayList;

        Rectangle r1 = new Rectangle(5,19,17,8, Color.RED,false);
        Rectangle r2 = new Rectangle(21,22,5,-5, Color.ORANGE,true);
        Rectangle r3 = new Rectangle(45,20,64,10, Color.GREEN,false);

        Oval o1 = new Oval(27,12,43,-2, Color.BLACK,true);
        Oval o2 = new Oval(32,65,12,33, Color.PINK,false);
        Oval o3 = new Oval(8,30,22,20, Color.MAGENTA,true);

        abstractShapeArrayList = new ArrayList<>(List.of(new AbstractShape[]{r1, r2, r3, o1, o2, o3}));

        System.out.println("All Shapes:\n");
        i = 0;
        for (AbstractShape shape :
                abstractShapeArrayList) {

            System.out.println("Shape " + ++i + " Details\n\n");
            System.out.println(shape);
        }

        Iterator<AbstractShape> iterator = abstractShapeArrayList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getWidth() > 17){
                iterator.remove();
            }
        }

        System.out.println("After removing Shapes that are width > 17:\n");

        i = 0;
        for (AbstractShape shape :
                abstractShapeArrayList) {

            System.out.println("Shape " + ++i + " Details\n\n");
            System.out.println(shape);
        }
    }
}
