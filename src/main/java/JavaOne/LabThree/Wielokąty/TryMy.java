package JavaOne.LabThree.Wielokąty;

public class TryMy {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(30,30);
        Triangle triangle = new Triangle(3,5,10);
        Square sq = new Square(30);

        System.out.println(rectangle.perimeter(rectangle.getSides()));
        System.out.println(rectangle.surface());
        System.out.println(triangle.perimeter(triangle.getSides()));
        System.out.println(triangle.surface());
        System.out.println(sq.perimeter(sq.getSides()));
        System.out.println(sq.surface());

    }
}
