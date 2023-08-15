import java.util.Scanner;

public class BT05_UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final float TYGIAVND = 23000;
        System.out.println("Nhập vào số tiền USD mà bạn muốn chuyển đổi");
        float money = sc.nextLong();
        System.out.println("Giá trị VND sau khi chuyển đổi là :" + (money * TYGIAVND));
    }
}
