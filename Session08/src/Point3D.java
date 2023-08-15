import java.util.Scanner;

public class Point3D extends Point2D{
    private float z;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    void setXYZ(float x,float y,float z){
        setX(x);
        setY(y);
        this.z=z;
    }

   public float[] getXYZ(){
        float [] arrXYZ=new float[3];
        arrXYZ[0]=getX();
        arrXYZ[1]=getY();
        arrXYZ[2]=getZ();
        return arrXYZ;
   }

    @Override
    public String toString() {
        return "Point3D{" +
                "x =" + getX() +
                ", y =" + getY() +
                ", z =" + z +
                '}';
    }

    public void inputData3D(Scanner sc){
        System.out.println("Nhập vào tọa độ X và Y , Z  của Point3D :");
        System.out.print("Nhập vào tạo độ X=");
        float x=Float.parseFloat(sc.nextLine());
        setX(x);
        System.out.print("Nhập vào tạo độ Y=");
        float y =Float.parseFloat(sc.nextLine());
        setY(y);
        System.out.print("Nhập vào tạo độ Z=");
        this.z=Float.parseFloat(sc.nextLine());

    }

    public void displayData3D(){
        System.out.println("Lớp Point3D:");
        System.out.printf("Tọa độ X :%.2f - Tọa độ Y :%.2f - Tọa độ Z :%.2f",getX(),getY(),this.z);
    }




}
