package JavaOne.LabThree.Wielokąty;

import java.util.ArrayList;

public abstract class Polygon {
    private ArrayList<Integer> sides;
    public ArrayList<Integer> getSides() {
        return sides;
    }

    public void setSides(ArrayList<Integer> sides ) {
        this.sides = sides;
    }

    public abstract double surface();

    public int perimeter( ArrayList<Integer> sides){
        int surface = 0;
        for (Integer side : sides){
            surface =  (int)surface + side;
        }
        return surface;
    }
}
