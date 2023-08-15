import java.util.Arrays;
import java.util.Scanner;

public class BT05_ChuanHoaChuoiTheoQuyTac {
    public static void main(String[] args) {
//        Nhập vào một chuỗi, chuẩn hóa chuỗi theo quy tắc:
//        a. Không có khoảng trắng ở 2 đầu
//        b. Mỗi từ cách nhau 1 khoảng trắng
//        c. Ký tự đầu tiên của mỗi từ được viết hoa, các ký tự khác viết thường

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào chuỗi thứ 1 =");
        String str = sc.nextLine();
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
//        sử dụng phương thức split() để tách xâu thành mảng các từ
        String temp[] = str.split(" ");
        str="";
        System.out.println(Arrays.toString(temp));
        for (int i = 0; i <temp.length ; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) // ? ^-^
                str += " ";
        }
        System.out.println("Chuỗi sau khi chuẩn hóa theo quy tắc  là :"+str);

    }
}
