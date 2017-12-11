package JavaOne.LabThree.Wielokąty;

import java.util.ArrayList;

public class Rectangle extends Polygon {

    public Rectangle(int a, int b) {
        ArrayList<Integer> sides=new ArrayList<Integer>();
        sides.add(2*a);
        sides.add(2*b);
        setSides(sides);
    }

    public double surface() {
        return (getSides().get(0)*getSides().get(1))/4;
    }
}
