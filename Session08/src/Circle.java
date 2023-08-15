import java.util.Scanner;

public class Circle {
    private float r;
    private String color;

    public Circle() {
    }

    public Circle(float r, String color) {
        this.r = r;
        this.color = color;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //cài đè phương thức toString

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                ", color='" + color + '\'' +
                '}';
    }
    // diện tích hình tròn

    public float acreageCircle(){
        //Diện tích của hình tròn
        //S=pi*r^2;
        final float PI=3.14F;
        return (float)(Math.pow(this.r,2)*PI);

    }

    public void inputDataCircle(Scanner sc){
        System.out.print("Nhập vào bán kính r của hình tròn =");
        this.r = Float.parseFloat(sc.nextLine());
        System.out.print("Nhập vào màu sắc của hình tròn =");
        this.color = sc.nextLine();
    }
    public void displayDataCircle(){
        System.out.printf("Diện tích hình tròn là : %.2f\n",acreageCircle());
    }
}
