import java.util.Scanner;

public class Cylinder extends Circle{
    private float h;

    public Cylinder() {
    }

    public Cylinder(float r, String color, float h) {
        super(r, color);
        this.h = h;
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "r="+super.getR()+
                ", h=" + h +
                ", color="+super.getColor()+
                '}';
    }
    public float acreageCylinder(){
        final float PI=3.14F;
//        V = π.r2.h
//        V: Thể tích hình trụ.
//        r: bán kính hình trụ.
//        h: chiều cao (khoảng cách 2 đáy của hình trụ)
        return (float)(PI*Math.pow(this.getR(),2)*this.h);


    }
    public void inputDataCylinder(Scanner sc){
        System.out.print("Nhập vào bán kính r của hình trụ =");
        float rCylinder = Float.parseFloat(sc.nextLine());
        setR(rCylinder);
        System.out.print("Nhập vào màu sắc của hình trụ =");
        String colorCylinder = sc.nextLine();
        setColor(colorCylinder);
        System.out.print("Nhập vào chiều cao của hình trụ =");
        this.h = Float.parseFloat(sc.nextLine());
    }
    public void displayDataCylinder(){
        System.out.print("Các thuộc tính của hình tròn là :");
        System.out.printf("Thể tích hình trụ là : %.2f\n",acreageCylinder());
    }

}
