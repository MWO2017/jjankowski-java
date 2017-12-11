package JavaOne.LabThree.Wielokąty;

import java.util.ArrayList;

public class Triangle extends Polygon {

    public Triangle(int a, int b, int c) {
        ArrayList<Integer> sides=new ArrayList<Integer>();
        sides.add(a);
        sides.add(b);
        sides.add(c);
        setSides(sides);
    }

    public double surface() {
        double s = ((getSides().get(0) + getSides().get(1) + getSides().get(2)) *(0.5));
        return Math.round(Math.sqrt(s * (s - getSides().get(0)) * (s - getSides().get(1) * (s - getSides().get(2)))));
    }
}
