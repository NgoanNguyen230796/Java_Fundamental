public class Triangle {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }


    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    //getArea
    public void getArea() {
//        S = ½. A2. sin 60o = A2. (3 /4). Trong đó A chính là cạnh của tam giác đều.
        double s = (double) (Math.pow(this.side1, 2) * (3 / 4));
        System.out.println("Diện tích tam giác đều là :" + s);
    }

    public void getPerimeter() {
//        Chu vi tam giác đều = (3 × a) đơn vị. trong đó 'a' = độ dài mỗi cạnh của tam giác.
        double c = (double) (3 * this.side1);
        System.out.println("Chu vi tam giác đều là :" + c);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }


}
