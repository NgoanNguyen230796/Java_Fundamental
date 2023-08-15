import java.util.Scanner;

public class Point2D {
    private float x;
    private float y;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] arrXY=new float[2];
        arrXY[0]=this.x;
        arrXY[1]=this.y;
        return arrXY;
    }


    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


    public void inputData2D(Scanner sc){
        System.out.println("Nhập vào tọa độ X và Y của Point2D :");
        System.out.print("Nhập vào tạo độ X=");
        this.x=Float.parseFloat(sc.nextLine());
        System.out.print("Nhập vào tạo độ Y=");
        this.y=Float.parseFloat(sc.nextLine());
    }

    public void displayData2D(){
        System.out.println("Lớp Point2D:");
        System.out.printf("Tọa độ X :%.2f - Tọa độ Y :%.2f\n",this.x,this.y);
    }


}
