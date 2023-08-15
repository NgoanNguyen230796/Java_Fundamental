import java.util.Scanner;

public class BT02_Ung_Dung_Tinh_Tien_Lai {
    public static void main(String[] args) {
//        chúng ta sẽ xây dựng một ứng dụng cho phép tính tiền cho vay lãi
//        của một ngân hàng.
//        Ứng dụng cho phép nhập vào 3 tham số: số lượng tiền cho vay, tỉ lệ lãi suất theo
//        tháng, số tháng cho vay. Ứng dụng sẽ hiển thị tổng số tiền có được khi hết thời hạn
//        cho vay.
//        Công thức:
//        Số_tiền_lãi = Số_tiền_gửi * tỉ_lệ_lãi_suất (% năm) / 12 * số_tháng_gửi

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số tiền cho vay=");
        double money = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập vào số tháng cho vay=");
        int month = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập vào lãi suất theo tháng (% năm)=");
        double interestRate = Double.parseDouble(sc.nextLine());
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * (interestRate / 100) / 12 * month;
        }
        System.out.printf("Số tiền lãi trong vòng " + month + " tháng là %f ", totalInterest);


    }
}
