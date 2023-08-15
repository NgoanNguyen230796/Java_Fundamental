import java.util.Scanner;

public class BT03_SuDungToanTu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập vào chiều dài của hình chữ nhật");
        float a=sc.nextFloat();
        System.out.println("Nhập vào chiều rộng của hình chữ nhật");
        float b=sc.nextFloat();

        System.out.println("Diện tích của hình chữ nhật là :"+(a*b));


    }
}
