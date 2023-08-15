import java.util.Scanner;

public class BT01_Giai_Phuong_Trinh_Bac_1 {
    public static void main(String[] args) {
//        Viết chương trình giải phương trình bậc một ax + b = 0
//        (với a, b là 2 số nguyên nhập từ bàn phím).
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào hệ số a=");
        int a, b;
        double nghiem;
        a = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập vào hệ số b=");
        b = Integer.parseInt(sc.nextLine());
        System.out.println("Phương trình bạn vừa nhập vào là :" + a + "x+" + b + "=0");
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình vô số nghiệm");
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        } else {
            //Ép kiểu để cho ra kết qảu chính xác
            nghiem = (double) -b / a;
            System.out.println("Phương trình có nghiệm x=" + nghiem);
        }

    }
}
