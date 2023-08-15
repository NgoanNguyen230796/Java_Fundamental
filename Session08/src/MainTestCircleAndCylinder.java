import java.util.Arrays;
import java.util.Scanner;

public class MainTestCircleAndCylinder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Circle sc1=new Circle();
        Cylinder cy1=new Cylinder();

        sc1.inputDataCircle(sc);
        cy1.inputDataCylinder(sc);

        System.out.println(sc1.toString());
        sc1.acreageCircle();

        System.out.println(cy1.toString());
        cy1.acreageCylinder();

        sc1.displayDataCircle();

        cy1.displayDataCylinder();



    }
}
