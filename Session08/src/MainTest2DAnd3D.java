import java.util.Arrays;
import java.util.Scanner;

public class MainTest2DAnd3D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Point2D point2D_1=new Point2D();
        point2D_1.inputData2D(sc);

        Point3D point3D_1 =new Point3D();
        point3D_1.inputData3D(sc);

        System.out.println(point2D_1.toString());
        point2D_1.displayData2D();
        System.out.println("getXY"+ Arrays.toString(point2D_1.getXY()));

        System.out.println(point3D_1.toString());
        point3D_1.displayData3D();
        System.out.println("getXYZ"+ Arrays.toString(point3D_1.getXYZ()));
    }
}
