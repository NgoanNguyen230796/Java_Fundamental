import java.util.Scanner;

public class BT03_InRaChuoiDaoNguoc {
    public static void main(String[] args) {
//      Nhập vào 1 chuỗi, in ra chuỗi đảo ngược
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi thứ 1 =");
        String str1 = sc.nextLine();
//      Sử dụng reverse() trong StringBuilder.
//      Cung cấp sẵn hàm reverse() cho phép đảo ngược chuỗi.
        StringBuilder str = new StringBuilder(str1);
        String str1Reverse = new String(str.reverse().toString());
        System.out.print("Chuỗi sau khi đảo ngược là :" + str1Reverse);
    }
}
