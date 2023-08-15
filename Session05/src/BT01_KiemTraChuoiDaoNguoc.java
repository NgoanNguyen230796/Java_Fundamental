import java.util.Arrays;
import java.util.Scanner;

public class BT01_KiemTraChuoiDaoNguoc {
    public static void main(String[] args) {
//        Nhập vào 2 chuỗi từ bàn phím, kiểm tra 2 chuỗi có phải là đảo ngược nhau hay
//        không. Nếu có thì in ra “YES” ngược lại “NO
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi thứ 1 =");
        String str1 = sc.nextLine();
        System.out.print("Nhập vào chuỗi thứ 2 =");
        String str2 = sc.nextLine();
//        Sử dụng reverse() trong StringBuilder.
//        Cung cấp sẵn hàm reverse() cho phép đảo ngược chuỗi.
        StringBuilder str= new StringBuilder(str1);
        String str1Reverse= new String (str.reverse().toString());
//        so sánh chuỗi str1Reverse và str2 không phân biệt hoa thường
        if(str1Reverse.equalsIgnoreCase(str2)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }


    }
}
