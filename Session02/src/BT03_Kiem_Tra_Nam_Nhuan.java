import java.util.Scanner;

public class BT03_Kiem_Tra_Nam_Nhuan {
    public static void main(String[] args) {
//        chúng ta sẽ phát triển một ứng dụng nhằm kiểm tra xem một năm
//        có phải là năm nhuận hay không.
        Scanner sc = new Scanner(System.in);
        int year;
        System.out.print("Nhập vào số năm=");
        year = Integer.parseInt(sc.nextLine());
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("Năm " + year + " là năm nhuận");
        } else {
            System.out.println("Năm " + year + " là năm không nhuận");
        }


    }
}
