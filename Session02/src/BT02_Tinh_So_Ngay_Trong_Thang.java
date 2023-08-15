import java.util.Scanner;

public class BT02_Tinh_So_Ngay_Trong_Thang {
    public static void main(String[] args) {
//        Viết một chương trình tính số ngày trong tháng của một tháng cho trước.
//        Trong một năm, tháng 2 có thể có 28 hoặc 29 ngày,
//        các tháng 1, 3, 5, 7, 8,10, 12 có 31 ngày,
//        các tháng còn lại có 30 ngày.

        Scanner sc = new Scanner(System.in);
        int month, year;
        System.out.print("Nhập vào số tháng =");
        month = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập vào số năm =");
        year = Integer.parseInt(sc.nextLine());
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + month + " Năm " + year + " có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " + month + " Năm " + year + " có 30 ngày");
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    System.out.println("Tháng " + month + " Năm " + year + " có 29 ngày");
                } else {
                    System.out.println("Tháng " + month + " Năm " + year + " có 28 ngày");
                }
                break;
        }

    }
}
